package sk.upjs.ics.controllers;

import io.swagger.annotations.ApiOperation;
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

    @ApiOperation(value = "Get list of all targets")
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List<Target> getAllTargets() {
        return targetService.getAll();
    }

    @ApiOperation(value = "Get target with the ID")
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Target getTarget(@PathVariable("id") Long id) {
        return targetService.findById(id);
    }

    @ApiOperation(value = "Do fulltext search on target's attributes")
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public @ResponseBody List<Target> searchTarget(@RequestParam("target") String target) {
        return targetService.doFulltextSearch(target);
    }

    @ApiOperation(value = "Insert a new target to the database")
    @ResponseStatus(value = HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST)
    public void createTarget(@RequestBody Target target) {
        targetService.merge(target);
    }

    @ApiOperation(value = "Insert a list of new targets to the database")
    @ResponseStatus(value = HttpStatus.CREATED)
    @RequestMapping(value = "/all", method = RequestMethod.POST)
    public void createTargets(@RequestBody List<Target> targets) {
        targetService.mergeAll(targets);
    }

    @ApiOperation(value = "Update an existing target")
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(method = RequestMethod.PUT)
    public void updateTarget(@RequestBody Target target) {
        targetService.merge(target);
    }

    @ApiOperation(value = "Remove the target with the ID")
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void removeTarget(@PathVariable("id") Long id) {
        targetService.removeById(id);
    }
}
