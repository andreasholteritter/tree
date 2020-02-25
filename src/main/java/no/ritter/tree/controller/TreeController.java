package no.ritter.tree.controller;

import no.ritter.tree.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TreeController {

    @Autowired
    TreeService service;

    @RequestMapping("/")
    public @ResponseBody
    String greeting() {
        return "Hello, World";
    }
}
