package com.tracebucket.x.terminal.api.config;

import com.tracebucket.tron.context.EnableAutoAssemblerResolution;
import org.springframework.context.annotation.Configuration;

/**
 * Created by sadath on 18-May-15.
 */
@Configuration
@EnableAutoAssemblerResolution(basePackages = {"com.tracebucket.x.terminal.api.rest.assembler"})
public class AssemblerConfiguration {
}