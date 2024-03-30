package br.com.curso.api;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MutableHttpRequest;
import io.micronaut.http.annotation.Filter;
import io.micronaut.http.client.LoadBalancer;
import io.micronaut.http.client.ProxyHttpClient;
import io.micronaut.http.filter.ClientFilterChain;
import io.micronaut.http.filter.FilterChain;
import io.micronaut.http.filter.HttpClientFilter;
import jakarta.inject.Named;
import org.reactivestreams.Publisher;

import java.util.Map;

@Filter("/**")
public class GatewayFilter implements HttpClientFilter {

    @Named("serviceLoadBalancers")
    private final Map<String, LoadBalancer> serviceLoadBalancers;
    private final ProxyHttpClient proxyHttpClient;

    public GatewayFilter(Map<String, LoadBalancer> serviceLoadBalancers, ProxyHttpClient proxyHttpClient) {
        this.serviceLoadBalancers = serviceLoadBalancers;
        this.proxyHttpClient = proxyHttpClient;
    }

    @Override
    public Publisher<? extends HttpResponse<?>> doFilter(MutableHttpRequest<?> request, ClientFilterChain chain) {
        return null;
    }

    @Override
    public Publisher<? extends HttpResponse<?>> doFilter(HttpRequest<?> request, FilterChain chain) {
        return HttpClientFilter.super.doFilter(request, chain);
    }
}
