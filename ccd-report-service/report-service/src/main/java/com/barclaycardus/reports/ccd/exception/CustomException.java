package com.barclaycardus.reports.ccd.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/**
 * Created by abhishek on 18/01/16.
 */
public class CustomException extends WebApplicationException{

    public CustomException(String message) {
        super(Response.status(Response.Status.BAD_REQUEST).entity(message).build());
    }

}
