package com.owner.ms.person.commons;

import java.util.List;
import java.util.Map;

public interface GenericService<I, O> {
    String save(I entity, String perId) throws Exception;
    String save(I entity) throws Exception;
    void delete(String perId) throws Exception;
    O get(String perId) throws Exception;
    Map<String, Object> getAsMap(String perId) throws Exception;
    List<O> getAll() throws Exception;
}
