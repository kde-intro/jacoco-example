package com.kde.testautomation.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

import static org.springframework.web.bind.annotation.RequestMethod.GET;


@RestController
public class DemoController {

    private final AtomicLong counter = new AtomicLong(); // LondAdder can be preferable

    @RequestMapping(path = "/handler1", method = GET)
    @ResponseBody public String response1() {
        return "response1";
    }

    @RequestMapping(path = "/handler2/{msg}", method = GET)
    @ResponseBody public String response2(@PathVariable String msg) {
        return msg;
    }

    @RequestMapping(path = "/handler3", method = GET)
    @ResponseBody public String response3() {
        return String.valueOf(counter.incrementAndGet());
    }

}
