package org.launchcode.hello_spring.models;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Event extends AbstractEntity{

    @NotBlank(message = "Name is required!")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters!")
    private String name;

    // cascade = CascadeType.ALL - operatiile cum ar fi save, delete, update etc. efectuate asupra entitatii trebuie efectuate si asupra entitatii copil
    @OneToOne(cascade = CascadeType.ALL)
    @Valid
    @NotNull
    private EventDetails eventDetails;

    // ONE eventCategory -> MANY events
    @ManyToOne
    @NotNull(message = "Category is required!")
    private EventCategory eventCategory;

    @ManyToMany
    private final List<Tag> tags =  new ArrayList<>();
    public Event(String name, EventCategory eventCategory){
        this.name=name;
        this.eventCategory=eventCategory;
    }

    public EventCategory getEventCategory() {
        return eventCategory;
    }

    public void setEventCategory(EventCategory eventCategory) {
        this.eventCategory = eventCategory;
    }

    public Event() {
    }

    public EventDetails getEventDetails() {
        return eventDetails;
    }

    public void setEventDetails(EventDetails eventDetails) {
        this.eventDetails = eventDetails;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Tag> getTags() {
        return tags;
    }
    public void addTag(Tag tag){
        this.tags.add(tag);
    }

    @Override
    public String toString(){
        return name;
    }

}
