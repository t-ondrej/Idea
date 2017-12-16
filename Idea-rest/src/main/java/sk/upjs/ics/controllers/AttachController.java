package sk.upjs.ics.controllers;

import io.swagger.annotations.ApiOperation;
import sk.upjs.ics.entity.impl.Attach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sk.upjs.ics.services.interfaces.IAttachService;

import java.util.List;

/**
 * Created by Tomas on 18.11.2017.
 */
@RestController
@RequestMapping("/attachs")
public class AttachController {

    private final IAttachService attachService;

    @Autowired
    public AttachController(IAttachService attachService) {
        this.attachService = attachService;
    }

    @ApiOperation(value = "Get list of all attachs")
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List<Attach> getAllAttachs() {
        return attachService.getAll();
    }

    @ApiOperation(value = "Get attach with the ID")
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Attach getAttach(@PathVariable("id") Long id) {
        return attachService.findById(id);
    }

    @ApiOperation(value = "Do fulltext search on attach's attributes")
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public @ResponseBody List<Attach> searchAttach(@RequestParam("target") String target) {
        return attachService.doFulltextSearch(target);
    }

    @ApiOperation(value = "Insert a new attach to the database")
    @ResponseStatus(value = HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST)
    public void createAttach(@RequestBody Attach attach) {
        attachService.merge(attach);
    }

    @ApiOperation(value = "Insert list of new attachs to the database")
    @ResponseStatus(value = HttpStatus.CREATED)
    @RequestMapping(value = "/all", method = RequestMethod.POST)
    public void createAttachs(@RequestBody List<Attach> attachs) {
        attachService.mergeAll(attachs);
    }

    @ApiOperation(value = "Update existing attach in database")
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(method = RequestMethod.PUT)
    public void updateAttach(@RequestBody Attach attach) {
        attachService.merge(attach);
    }

    @ApiOperation(value = "Remove the attach with the ID")
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void removeAttach(@PathVariable("id") Long id) {
        attachService.removeById(id);
    }
}
