package com.skillstorm.togglezdemo.controller;

import com.skillstorm.togglezdemo.flag.FeatureToggles;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DemoResource {

    private final Environment environment;

    public DemoResource(Environment environment){
        this.environment = environment;
    }

//    @Value("${togglz.features.HELLO_WORLD_FEATURE.enabled:false}")
//    private boolean isHelloWorldFeatureEnabled;

    @GetMapping("/greeting")
    public String greeting() {
        boolean isHelloWorldFeatureEnabled = environment.getProperty("togglz.features.HELLO_WORLD_FEATURE.enabled", Boolean.class, false);
//        if (isHelloWorldFeatureEnabled) {
//            return "Hello, World!";
//        } else {
//            return "App in development.";
//        }

        return isHelloWorldFeatureEnabled ? "Hello World!" : "App still in development...";
    }
}
