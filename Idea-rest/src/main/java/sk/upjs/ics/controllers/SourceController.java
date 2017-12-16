package sk.upjs.ics.controllers;

import io.swagger.annotations.ApiOperation;
import sk.upjs.ics.entity.impl.Source;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sk.upjs.ics.services.interfaces.ISourceService;

import java.util.List;

/**
 * Created by Tomas on 18.11.2017.
 */
@RestController
@RequestMapping("/sources")
public class SourceController {

    private final ISourceService sourceService;

    @Autowired
    public SourceController(ISourceService sourceService) {
        this.sourceService = sourceService;
    }

    @ApiOperation(value = "Get list of all sources.")
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List<Source> getAllSources() {
        return sourceService.getAll();
    }

    @ApiOperation(value = "Get source with the ID")
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Source getSource(@PathVariable("id") Long id) {
        return sourceService.findById(id);
    }

    @ApiOperation(value = "Do fulltext search on source's attributes")
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public @ResponseBody List<Source> searchSource(@RequestParam("target") String target) {
        return sourceService.doFulltextSearch(target);
    }

    @ApiOperation(value = "Insert a new source to the database")
    @ResponseStatus(value = HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST)
    public void createSource(@RequestBody Source source) {
        sourceService.merge(source);
    }

    @ApiOperation(value = "Insert a list of new sources to the database")
    @ResponseStatus(value = HttpStatus.CREATED)
    @RequestMapping(value = "/all", method = RequestMethod.POST)
    public void createSources(@RequestBody List<Source> sources) {
        sourceService.mergeAll(sources);
    }

    @ApiOperation(value = "Update an existing source")
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(method = RequestMethod.PUT)
    public void updateSource(@RequestBody Source source) {
        sourceService.merge(source);
    }

    @ApiOperation(value = "Remove the source with the ID")
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void removeSource(@PathVariable("id") Long id) {
        sourceService.removeById(id);
    }
}
