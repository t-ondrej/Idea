package sk.upjs.ics.controllers;

import io.swagger.annotations.ApiOperation;
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

    @ApiOperation(value = "Get list of all events")
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List<Event> getAllEvents() {
        return eventService.getAll();
    }

    @ApiOperation(value = "Get event with the ID")
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Event getEvent(@PathVariable("id") String id) {
        return eventService.findById(id);
    }

    @ApiOperation(value = "Do fulltext search on event's attributes")
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public @ResponseBody List<Event> searchEvent(@RequestParam("target") String target) {
        return eventService.doFulltextSearch(target);
    }

    @ApiOperation(value = "Insert a new event to the database")
    @ResponseStatus(value = HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST)
    public void createEvent(@RequestBody Event event) {
        eventService.merge(event);
    }

    @ApiOperation(value = "Insert list of new events to the database")
    @ResponseStatus(value = HttpStatus.CREATED)
    @RequestMapping(value = "/all", method = RequestMethod.POST)
    public void createEvents(@RequestBody List<Event> events) {
        eventService.mergeAll(events);
    }

    @ApiOperation(value = "Update an existing event in the database")
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(method = RequestMethod.PUT)
    public void updateEvent(@RequestBody Event event) {
        eventService.merge(event);
    }

    @ApiOperation(value = "Remove the event with the ID")
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void removeEvent(@PathVariable("id") String id) {
        eventService.removeById(id);
    }
}
