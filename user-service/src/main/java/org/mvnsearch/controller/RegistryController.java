package org.mvnsearch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClientConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * registry controller
 *
 * @author linux_china
 */
@RequestMapping("/registry")
@RestController
public class RegistryController {
    @Autowired
    private EurekaDiscoveryClientConfiguration lifecycle;

    @RequestMapping("/online")
    public String online() {
        this.lifecycle.start();
        return "success";
    }

    @RequestMapping("/offline")
    public String offline() {
        this.lifecycle.stop();
        return "success";
    }
}
