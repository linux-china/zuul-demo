package org.mvnsearch.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.ProxyRouteLocator;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UrlPathHelper;

/**
 * auth zuul filter
 *
 * @author linux_china
 */
@Component
public class AuthFilter extends ZuulFilter {
    private UrlPathHelper urlPathHelper = new UrlPathHelper();
    private ProxyRouteLocator routeLocator;

    @Autowired
    public AuthFilter(ProxyRouteLocator routeLocator) {
        this.routeLocator = routeLocator;
    }

    public String filterType() {
        return "pre";
    }

    public int filterOrder() {
        return 1;
    }

    public boolean shouldFilter() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        return true;
    }

    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        final String requestURI = this.urlPathHelper.getPathWithinApplication(ctx.getRequest());
        ProxyRouteLocator.ProxyRouteSpec route = this.routeLocator.getMatchingRoute(requestURI);
        return null;
    }
}
