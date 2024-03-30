package br.com.curso.api;

import io.micronaut.context.annotation.Factory;
import io.micronaut.http.client.LoadBalancer;
import io.micronaut.http.client.loadbalance.DiscoveryClientLoadBalancerFactory;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Factory
public class GatewayLoadBalancersFactory {

    public Map<String, LoadBalancer> serviceLoadBalancers(GatewayProperties properties,
                                                          DiscoveryClientLoadBalancerFactory factory) {
        Set<String> services = properties.getServices();
        Map<String, LoadBalancer> loadBalancers = new HashMap<>();
        services.forEach(serviceName -> loadBalancers.put(serviceName, factory.create(serviceName)));
        return Collections.unmodifiableMap(loadBalancers);
    }
}
