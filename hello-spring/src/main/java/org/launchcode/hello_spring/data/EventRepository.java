package org.launchcode.hello_spring.data;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.launchcode.hello_spring.models.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Este un Data Access Object (DAO) care permite interactiunea cu baza de date.
 * CrudRepository, o componenta Spring care ofera metode gata facute pentru operatiuni de baz asupra datelor (findAll, save, deleteById etc.)
 * Legatura cu entitatea Event si cheia primara de tip Integer ii spune framework-ului ce tipuri de date sa gestioneze.
 */
@Repository
public interface EventRepository extends CrudRepository<Event, Integer> {
}
