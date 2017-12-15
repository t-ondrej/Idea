package sk.upjs.ics.controllers;

import sk.upjs.ics.entity.impl.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sk.upjs.ics.services.interfaces.IEventService;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Tomas on 14.11.2017.
 */
@RestController
@RequestMapping("/events")
public class EventController {

    private final IEventService eventService;

    @Autowired
    public EventController(IEventService eventService) {
        this.eventService = eventService;
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET)
    public List<Event> getAllEvents() {
        return eventService.getAll();
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST)
    public void addEvent(@RequestBody Event event) {
        eventService.merge(event);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Event getEvent(@PathVariable("id") String id) {
        return eventService.findById(id);
    }
}
