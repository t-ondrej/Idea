package sk.upjs.ics.controllers;

import io.swagger.annotations.ApiOperation;
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

    @ApiOperation(value = "Get list of all nodes")
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List<Node> getAllNodes() {
        return nodeService.getAll();
    }

    @ApiOperation(value = "Get node with the ID")
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Node getNode(@PathVariable("id") Long id) {
        return nodeService.findById(id);
    }

    @ApiOperation(value = "Do fulltext search on node's attributes")
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public @ResponseBody List<Node> searchNode(@RequestParam("target") String target) {
        return nodeService.doFulltextSearch(target);
    }

    @ApiOperation(value = "Insert a new node to the database")
    @ResponseStatus(value = HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST)
    public void createNode(@RequestBody Node node) {
        nodeService.merge(node);
    }

    @ApiOperation(value = "Insert a list of new nodes to the database")
    @ResponseStatus(value = HttpStatus.CREATED)
    @RequestMapping(value = "/all", method = RequestMethod.POST)
    public void createNodes(@RequestBody List<Node> nodes) {
        nodeService.mergeAll(nodes);
    }

    @ApiOperation(value = "Update an existing node")
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(method = RequestMethod.PUT)
    public void updateNode(@RequestBody Node node) {
        nodeService.merge(node);
    }

    @ApiOperation(value = "Remove the node with the ID")
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void removeNode(@PathVariable("id") Long id) {
        nodeService.removeById(id);
    }
}
