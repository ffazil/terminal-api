package com.tracebucket.x.terminal.api.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by sadath on 18-May-15.
 */
@Configuration
@ComponentScan(basePackages = {"com.tracebucket.x.terminal.api.rest"})
public class WebConfiguration {
}