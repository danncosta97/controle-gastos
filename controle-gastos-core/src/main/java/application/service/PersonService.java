package application.service;

import java.util.List;

import application.entity.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private EntityManager em;

    public List<Person> findAll() {
        Query query = this.em.createNamedQuery(Person.FIND_ALL);
        return query.getResultList();
    }

}
