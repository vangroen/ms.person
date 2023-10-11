package com.owner.ms.person.services.impl;

import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.Firestore;
import com.owner.ms.person.commons.GenericServiceImpl;
import com.owner.ms.person.dto.PersonDTO;
import com.owner.ms.person.models.PersonModel;
import com.owner.ms.person.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl extends GenericServiceImpl<PersonModel, PersonDTO> implements PersonService {

    @Autowired
    private Firestore firestore;

    public PersonServiceImpl() {
        super(PersonDTO.class);
    }

    @Override
    public CollectionReference getCollection() {
        return firestore.collection("persona");
    }
}
