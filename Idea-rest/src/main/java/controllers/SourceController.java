package controllers;

import dao.SourceDao;
import entity.impl.Source;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import services.interfaces.ISourceService;

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

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET)
    public List<Source> getAllSources() {
        List<Source> sources = sourceService.getAll();

        return sources;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Source getSource(@PathVariable("id") Long id) {
        return sourceService.findById(id);
    }
}
