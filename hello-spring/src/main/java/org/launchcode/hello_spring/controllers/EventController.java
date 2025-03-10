package org.launchcode.hello_spring.controllers;

import jakarta.validation.Valid;
import org.launchcode.hello_spring.data.EventCategoryRepository;
import org.launchcode.hello_spring.data.EventRepository;
import org.launchcode.hello_spring.data.TagRepository;
import org.launchcode.hello_spring.models.Event;
import org.launchcode.hello_spring.models.EventCategory;
import org.launchcode.hello_spring.models.Tag;
import org.launchcode.hello_spring.models.dto.EventTagDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("events")
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private EventCategoryRepository eventCategoryRepository;

    @Autowired
    private TagRepository tagRepository;

    // findAll, save, findById

    /**
     * -> afiseaza o lista de evenimente statice
     */
    @GetMapping
    public String displayAllEvents(@RequestParam(required = false) Integer categoryId, Model model){

        if (categoryId == null){
            model.addAttribute("title","All Events");
            model.addAttribute("events", eventRepository.findAll());
        } else {
            Optional<EventCategory> result =eventCategoryRepository.findById(categoryId);
            if (result.isEmpty()){
                model.addAttribute("title","Invalid Category ID: " +  categoryId);
            } else {
                EventCategory category = result.get();
                model.addAttribute("title", "Events in category: " + tagRepository);
                model.addAttribute("events", category.getEvents());
            }
        }

        return "events/index";
    }

    @GetMapping("create")
    public String displayCreateEventForm(Model model){
        model.addAttribute("title","Create Event");
        model.addAttribute(new Event()); // primeste un id, de aceea avem doar evenimente cu id-uri pare
        model.addAttribute("categories", eventCategoryRepository.findAll()); // categories trebuie sa coincida cu numele din create.html
        return "events/create";
    }

    @PostMapping("create")
    public String processCreateEventForm(@ModelAttribute @Valid Event newEvent,
                                         Errors errors, Model model){
        if (errors.hasErrors()) {
            model.addAttribute("title", "Create Event");
            model.addAttribute("categories", eventCategoryRepository.findAll());
            return "events/create";
        }
        eventRepository.save(newEvent);
        return "redirect:/events";
    }

    @GetMapping("delete")
    public String displayDeleteEventForm(Model model){
        model.addAttribute("title", "Delete Events");
        model.addAttribute("events", eventRepository.findAll());
        return "events/delete";
    }

    @PostMapping("delete")
    public String processDeleteEventsForm(@RequestParam(required = false) int[] eventIds) {
        if (eventIds != null) {
            for (int id : eventIds) {
                eventRepository.deleteById(id);
            }
        }
        return "redirect:/events";
    }


 @GetMapping("detail")
 public String displayEventDetails(@RequestParam Integer eventId, Model model){
        Optional<Event> result = eventRepository.findById(eventId);

        if (result.isEmpty()){
            model.addAttribute("title", "Invalid Event ID: " + eventId);
        } else {
            Event event = result.get();
            model.addAttribute("title", event.getName() + "Details");
            model.addAttribute("event", event);
            model.addAttribute("tags", event.getTags());
        }
        return "events/detail";
    }

    // responds to /events/add-tag?eventId=13
    @GetMapping("add-tag")
    public String displayAddTagForm(@RequestParam Integer eventId, Model model) {
        Optional<Event> result = eventRepository.findById(eventId);

        if (result.isEmpty()) {
            model.addAttribute("title", "Invalid Event ID");
            return "redirect:/events";
        }

        Event event = result.get();
        model.addAttribute("title", "Add Tag to: " + event.getName());
        model.addAttribute("tags", tagRepository.findAll());
        EventTagDTO eventTag = new EventTagDTO();
        eventTag.setEvent(event);
        model.addAttribute("eventTag", eventTag);

        return "events/add-tag";
    }


    @PostMapping("add-tag")
    public String processAddTagForm(@ModelAttribute @Valid EventTagDTO eventTag, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Tag to: " + eventTag.getEvent().getName());
            model.addAttribute("tags", tagRepository.findAll());
            return "events/add-tag";
        }

        Event event = eventTag.getEvent();
        Tag tag = eventTag.getTag();

        if (!event.getTags().contains(tag)) {
            event.addTag(tag);
            eventRepository.save(event);
        }

        return "redirect:detail?eventId=" + event.getId();
    }

}
