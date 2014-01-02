package com.canvass.api.resource;

import com.google.inject.Singleton;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created By: jordancote
 * Created On: 12/30/13
 */
@Singleton
@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class HelloResource {
    @GET
    @Path("hi")
    public String hello() {
        return "hi!";
    }
}
