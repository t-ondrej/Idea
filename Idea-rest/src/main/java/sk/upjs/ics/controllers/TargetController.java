package sk.upjs.ics.controllers;

import sk.upjs.ics.entity.impl.Target;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sk.upjs.ics.services.interfaces.ITargetService;

import java.util.List;

/**
 * Created by Tomas on 18.11.2017.
 */
@RestController
@RequestMapping("/targets")
public class TargetController {

    private final ITargetService targetService;

    @Autowired
    public TargetController(ITargetService targetService) {
        this.targetService = targetService;
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET)
    public List<Target> getAllTargets() {
        return targetService.getAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Target getTarget(@PathVariable("id") Long id) {
        return targetService.findById(id);
    }
}
