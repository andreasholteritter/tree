package no.ritter.tree.controller;

import no.ritter.tree.entity.Tree;
import no.ritter.tree.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(
        name = "Pre path for controller",
        path = "/tree"
)
@Controller
public class TreeController {

    @Autowired
    TreeService service;

    @RequestMapping("/hello")
    public ResponseEntity<String> greeting
            () {
        return new ResponseEntity<>("Hello world", HttpStatus.OK);
    }

    @RequestMapping(
            name = "Create a tree",
            path = "/",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Integer> saveTree
            (@RequestBody Tree tree) {
        service.save(tree);
        return new ResponseEntity<>(tree.getId(), HttpStatus.OK);
    }

    @RequestMapping(
            name = "Create trees from list",
            path = "/list",
            method = RequestMethod.POST
    )
    public ResponseEntity saveAllTrees
            (@RequestBody List<Tree> trees) {
        service.saveAll(trees);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @RequestMapping(
            name = "Find a tree by id",
            path = "/id/{id}",
            method = RequestMethod.GET
    )
    public ResponseEntity<Tree> findTreeById
            (@PathVariable("id") int id) {
        Tree tree = service.findById(id).get();
        return new ResponseEntity<>(tree, HttpStatus.OK);
    }

    @RequestMapping(
            name = "Exist tree by id",
            path = "/exist/{id}",
            method = RequestMethod.GET
    )
    public ResponseEntity<Boolean> existsTreeById
            (@PathVariable("id") int id) {
        boolean request = service.existsById(id);
        return new ResponseEntity<>(request, HttpStatus.OK);
    }

    @RequestMapping(
            name = "Find all trees",
            path = "/find-all",
            method = RequestMethod.GET
    )
    public ResponseEntity<List<Tree>> findAllTrees
            () {
        List<Tree> trees = new ArrayList<>();
        service.findAll().forEach(tree -> trees.add(tree));
        return new ResponseEntity<>(trees, HttpStatus.OK);
    }

    @RequestMapping(
            name = "Find all trees by id",
            path = "/find",
            method = RequestMethod.GET
    )
    public ResponseEntity<List<Tree>> findAllTreesById
            (@RequestBody Iterable<Integer> integers) {
        List<Tree> trees = new ArrayList<>();
        service.findAllById(integers).forEach(tree -> trees.add(tree));
        return new ResponseEntity<>(trees, HttpStatus.OK);
    }

    @RequestMapping(
            name = "Count all trees",
            path = "/count",
            method = RequestMethod.GET
    )
    public ResponseEntity<Long> countTrees
            () {
        Long count = service.count();
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    @RequestMapping(
            name = "Delete a tree by id",
            path = "/{id}",
            method = RequestMethod.DELETE
    )
    public ResponseEntity deleteTreeById
            (@PathVariable("id") int id) {
        service.deleteById(id);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @RequestMapping(
            name = "Delete a tree",
            path = "/",
            method = RequestMethod.DELETE
    )
    public ResponseEntity deleteTree
            (@RequestBody Tree tree) {
        service.delete(tree);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @RequestMapping(
            name = "Delete a list of trees",
            path = "/delete-list",
            method = RequestMethod.DELETE
    )
    public ResponseEntity deleteTreeList
            (@RequestBody Iterable<Tree> trees) {
        service.deleteAll(trees);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @RequestMapping(
            name = "Delete all trees",
            path = "/delete-all",
            method = RequestMethod.DELETE
    )
    public ResponseEntity deleteAllTrees
            () {
        service.deleteAll();
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
