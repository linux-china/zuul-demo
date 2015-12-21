package org.mvnsearch.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * portal controller
 *
 * @author linux_china
 */
@RestController
public class PortalController {

    @RequestMapping("/")
    public String index() {
        return "hello";
    }
}
