package com.canvass.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created By: jordancote
 * Created On: 12/30/13
 */
@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CanvassApi {
    @GET
    @Path("hi")
    public String hello() {
        return "hi!";
    }
}
