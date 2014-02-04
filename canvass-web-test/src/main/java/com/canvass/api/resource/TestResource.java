package com.canvass.api.resource;

import com.canvass.api.json.BillJson;
import com.canvass.data.DataStore;
import com.canvass.data.model.Bill;
import com.canvass.data.model.BillVersion;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created By: jordancote
 * Created On: 12/30/13
 */
@Singleton
@Path("test/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TestResource {
    private final DataStore dataStore;
    private final Logger logger;

    @Inject
    public TestResource(DataStore dataStore, Logger logger) {
        this.dataStore = dataStore;
        this.logger = logger;
    }

    @POST
    @Path("wipedb")
    public void postWipeDb() {

    }


}
