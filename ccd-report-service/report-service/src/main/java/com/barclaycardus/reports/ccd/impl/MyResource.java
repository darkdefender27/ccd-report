package com.barclaycardus.reports.ccd.impl;

import com.barclaycardus.reports.ccd.config.ReportServiceConfigHolder;
import com.barclaycardus.reports.ccd.exception.CustomException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Component
@Path("myresource")
public class MyResource {

    @Inject
    ReportServiceConfigHolder reportServiceConfigHolder;

    private static final Logger log = LoggerFactory.getLogger(MyResource.class);

    @GET
    @Path("get")
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        log.info("info - request received!");
        log.debug("debug - request received");
        log.info("info - request processed!");
        log.debug("debug - request processed");
        return "Got it!";
    }

    @GET
    @Path("greeting")
    @Produces(MediaType.TEXT_PLAIN)
    public String greet(@DefaultValue("Guest") @QueryParam("name") String name) {
        if(name.matches("^[A-Z][a-zA-Z]+$")){
            return ("Hello " + name + "!");
        }
        throw new CustomException("not a valid name!");
    }

    @GET
    @Path("fault")
    @Produces(MediaType.TEXT_PLAIN)
    public String throwException() throws Exception {
        throw new Exception("stop bugging me!");
    }

    @GET
    @Path("environment")
    @Produces(MediaType.TEXT_PLAIN)
    public String getEnvironmentMessage(@QueryParam("env") String env) {
        return ("Environment: " + reportServiceConfigHolder.getMessageForService(env));
    }

}
