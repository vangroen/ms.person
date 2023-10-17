package com.owner.ms.person.commons;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unchecked")
@Service
public abstract class GenericServiceImpl<I, O> implements GenericService<I, O> {

    private Class<O> clazz;

    public GenericServiceImpl(Class<O> entityClass) {
        this.clazz = entityClass;
    }

    @Override
    public String save(I entity) throws Exception {
        return this.save(entity, null);
    }

    @Override
    public String save(I entity, String perId) throws Exception {
        if (perId == null || perId.length() == 0) {
            return getCollection().add(entity).get().getId();
        }

        DocumentReference reference = getCollection().document(perId);
        reference.set(entity);
        return reference.getId();
    }

    @Override
    public void delete(String perId) throws Exception {
        getCollection().document(perId).delete().get();
    }

    @Override
    public O get(String perId) throws Exception {
        DocumentReference ref = getCollection().document(perId);
        ApiFuture<DocumentSnapshot> futureDoc = ref.get();
        DocumentSnapshot document = futureDoc.get();
        if (document.exists()) {
            O object = document.toObject(clazz);
            PropertyUtils.setProperty(object, "perId", document.getId());
            return object;
        }
        return null;
    }

    @Override
    public List<O> getAll() throws Exception {
        List<O> result = new ArrayList<O>();
        Query query = getCollection().orderBy("perCreatedAt", Query.Direction.DESCENDING);
        ApiFuture<QuerySnapshot> querySnapshot = query.get();
        for (QueryDocumentSnapshot doc : querySnapshot.get().getDocuments()) {
            O object = doc.toObject(clazz);
            PropertyUtils.setProperty(object, "perId", doc.getId());
            result.add(object);
        }
        return result;
    }

    @Override
    public Map<String, Object> getAsMap(String perId) throws Exception {
        DocumentReference reference = getCollection().document(perId);
        ApiFuture<DocumentSnapshot> futureDoc = reference.get();
        DocumentSnapshot document = futureDoc.get();
        if (document.exists()) {
            return document.getData();
        }
        return null;
    }

    public abstract CollectionReference getCollection();
}
