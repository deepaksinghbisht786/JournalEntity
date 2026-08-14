package com.example.demo.Service;

import com.example.demo.Entity.Entity;
import com.example.demo.Repo.Journalrepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JournalService {
//    public List<Entity> journallist = new ArrayList<>(); //temp storage
//
//    public List<Entity>  getall(){
//        return journallist;
//    }

    @Autowired
    private Journalrepo journallist;

//    public Entity findbyid(ObjectId idd) {
//        Optional<Entity> result = journallist.findById(idd);
//        return result.orElse(null);
//
//    }
    /// with respose entity
    public ResponseEntity<Entity> findbyid(ObjectId idd){
        Optional<Entity> result = journallist.findById(idd);
        if(!result.isEmpty()){
            return new ResponseEntity<>(result.get(), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public List<Entity> findallin() {
        return journallist.findAll();
    }

    public String AddJournal(Entity eg) {
        if (eg != null) {
            journallist.save(eg);
            return "added";
        }
        return "unable to add null element";
    }

    //updatating a particular
    public String update(Entity abc, ObjectId id) {
        for (Entity search : journallist.findAll()) {
            if (search.getId().equals(id)) {
                search.setContent(abc.getContent());
                search.setTitle(abc.getTitle());
                journallist.save(search);
                return "updated";
            }
        }   //isme dikkat hai
        abc.setId(id);
        journallist.save(abc);
        return "not found added new ";
    }

    //
//
    public String delete(ObjectId id) {
        if (journallist.existsById(id)) {
            journallist.deleteById(id);
            return "Deleted";
        } else {
            return "Not Found";
        }
    }
}
//
//
//

//
