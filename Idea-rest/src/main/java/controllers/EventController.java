package controllers;

import entity.impl.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import services.interfaces.IEventService;

import java.util.List;

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
        List<Event> events = eventService.getAll();

        return events;
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
