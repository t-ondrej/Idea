package controllers;

import entity.impl.Attach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import services.interfaces.IAttachService;

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

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET)
    public List<Attach> getAllAttachs() {
        List<Attach> attachs = attachService.getAll();

        return attachs;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Attach getAttach(@PathVariable("id") Long id) {
        return attachService.findById(id);
    }
}
