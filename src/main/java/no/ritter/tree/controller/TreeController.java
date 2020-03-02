package no.ritter.tree.controller;

import no.ritter.tree.entity.Tree;
import no.ritter.tree.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TreeController {

    @Autowired
    TreeService service;

    @RequestMapping("/")
    public ResponseEntity<String> greeting
            () {
        return new ResponseEntity<>("Hello world", HttpStatus.OK);
    }

    public ResponseEntity<Integer> saveTree
            (@RequestBody Tree tree) {
        service.save(tree);
        return new ResponseEntity<>(tree.getId(), HttpStatus.OK);
    }

    public ResponseEntity saveAllTrees
            (@RequestBody List<Tree> trees) {
        service.saveAll(trees);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    public ResponseEntity<Tree> findTreeById
            (@RequestBody int id) {
        Tree tree = service.findById(id).get();
        return new ResponseEntity<>(tree, HttpStatus.OK);
    }

    public ResponseEntity<Boolean> existsTreeById
            (@RequestBody int id) {
        boolean request = service.existsById(id);
        return new ResponseEntity<>(request, HttpStatus.OK);
    }

    public ResponseEntity<List<Tree>> findAllTrees
            () {
        List<Tree> trees = new ArrayList<>();
        service.findAll().forEach(tree -> trees.add(tree));
        return new ResponseEntity<>(trees, HttpStatus.OK);
    }

    public ResponseEntity<List<Tree>> findAllTreesById
            (@RequestBody Iterable<Integer> integers) {
        List<Tree> trees = new ArrayList<>();
        service.findAllById(integers).forEach(tree -> trees.add(tree));
        return new ResponseEntity<>(trees, HttpStatus.OK);
    }

    public ResponseEntity<Long> countTrees
            () {
        Long count = service.count();
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    public ResponseEntity deleteTreeById
            (@RequestBody int id) {
        service.deleteById(id);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    public ResponseEntity deleteTree
            (@RequestBody Tree tree) {
        service.delete(tree);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    public ResponseEntity deleteTreeList
            (@RequestBody Iterable<Tree> trees) {
        service.deleteAll(trees);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    public ResponseEntity deleteAllTrees
            () {
        service.deleteAll();
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
