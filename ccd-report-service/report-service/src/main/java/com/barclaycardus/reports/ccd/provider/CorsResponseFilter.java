package com.barclaycardus.reports.ccd.provider;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

/**
 * Created by abhishek on 18/01/16.
 */
@Provider
public class CorsResponseFilter implements ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext containerRequestContext, ContainerResponseContext containerResponseContext) throws IOException {
        String origin = containerRequestContext.getHeaderString("Origin");

        if (origin != null && !origin.isEmpty()) {
            MultivaluedMap<String, Object> headers = containerResponseContext.getHeaders();
            headers.add("Access-Control-Allow-Origin", origin);
            headers.add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
            headers.add("Access-Control-Allow-Headers", "X-Requested-With, Content-Type, Accept, Authorization");
        }
    }

}
