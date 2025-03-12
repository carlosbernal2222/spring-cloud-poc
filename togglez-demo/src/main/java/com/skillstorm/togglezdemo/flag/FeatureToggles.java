package com.skillstorm.togglezdemo.flag;

import org.togglz.core.Feature;
import org.togglz.core.annotation.Label;

public enum FeatureToggles implements Feature {

    @Label("New Hello World functionality.")
    HELLO_WORLD_FEATURE,

    @Label("Beta Feature")
    BETA_FEATURE;
}
