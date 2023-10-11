package com.owner.ms.person.controllers;

import com.owner.ms.person.dto.PersonDTO;
import com.owner.ms.person.models.PersonModel;
import com.owner.ms.person.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping(value = "/owner/person")
@CrossOrigin("*")
public class PersonController {

    @Autowired
    private PersonService ps;

    @GetMapping(value = "/all")
    public List<PersonDTO> getAll() throws Exception {
        return ps.getAll();
    }

    @GetMapping(value = "/find/{id}")
    public PersonDTO find(@PathVariable String id) throws Exception {
        return ps.get(id);
    }

    @PostMapping(value = "/save/{id}")
    public ResponseEntity<Object> save(@RequestBody PersonModel pm, @PathVariable String id) throws Exception {
        if (id == null || id.length() == 0 || id.equals("null")) {
            pm.setPerUUID(UUID.randomUUID().toString());
            id = ps.save(pm);
        } else {
            ps.save(pm, id);
        }
//        return new ResponseEntity<String>(id, HttpStatus.OK);
        Map<String, String> response = new HashMap<>();
        response.put("perId", id);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping(value = "/delete/{id}")
    public ResponseEntity<PersonDTO> delete(@PathVariable String id) throws Exception {
        PersonDTO persona = ps.get(id);
        if (persona != null) {
            ps.delete(id);
        } else {
            return new ResponseEntity<PersonDTO>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<PersonDTO>(persona, HttpStatus.OK);
    }

}
