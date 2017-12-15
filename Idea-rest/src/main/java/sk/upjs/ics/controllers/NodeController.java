package sk.upjs.ics.controllers;

import sk.upjs.ics.entity.impl.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sk.upjs.ics.services.interfaces.INodeService;

import java.util.List;

/**
 * Created by Tomas on 18.11.2017.
 */
@RestController
@RequestMapping("/nodes")
public class NodeController {

    private final INodeService nodeService;

    @Autowired
    public NodeController(INodeService nodeService) {
        this.nodeService = nodeService;
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET)
    public List<Node> getAllNodes() {
        return nodeService.getAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Node getNode(@PathVariable("id") Long id) {
        return nodeService.findById(id);
    }
}
