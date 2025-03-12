package com.example.demo.config;

import com.skillstorm.togglezdemo.flag.FeatureToggles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.togglz.core.Feature;
import org.togglz.core.manager.FeatureManager;
import org.togglz.core.manager.FeatureManagerBuilder;
import org.togglz.core.manager.TogglzConfig;
import org.togglz.core.repository.StateRepository;
import org.togglz.core.repository.cache.CachingStateRepository;
import org.togglz.core.repository.file.FileBasedStateRepository;
import org.togglz.core.repository.mem.InMemoryStateRepository;
import org.togglz.core.user.NoOpUserProvider;
import org.togglz.core.user.UserProvider;
import org.togglz.servlet.user.ServletUserProvider;
import org.togglz.spring.boot.actuate.autoconfigure.TogglzProperties;


import java.io.File;
import java.io.IOException;
import java.util.Map;

public class MyTogglzConfiguration implements TogglzConfig {

    public Class<? extends Feature> getFeatureClass() {
        return FeatureToggles.class;
    }

    public StateRepository getStateRepository() {
        return new FileBasedStateRepository(new File("/tmp/features.properties"));
    }

    public UserProvider getUserProvider() {
        return new NoOpUserProvider();
    }

    @Bean
    public FeatureManager featureManager() {
        return new FeatureManagerBuilder()
                .featureEnum(getFeatureClass())
                .stateRepository(getStateRepository())
                .userProvider(getUserProvider())
                .build();
    }
}
