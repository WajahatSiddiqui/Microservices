package com.wajahat.docker.docker.demo.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Resource for Docker Demo
// Created by Wajahat
@RestController
@RequestMapping("/rest/demo")
public class DockerDemoResource {

    @GetMapping
    public String hello() {
        return "Hi, There !!! This is Docker resource !!!";
    }
}
