package br.com.curso.api;

import io.micronaut.context.annotation.ConfigurationProperties;

import java.util.Set;

@ConfigurationProperties("gateway")
public class GatewayProperties {
    public Set<String> getServices() {
        return services;
    }

    public void setServices(Set<String> services) {
        this.services = services;
    }

    private Set<String> services;
}
