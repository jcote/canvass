package com.canvass.api.resource;

import java.util.Date;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.canvass.data.DataStore;
import com.canvass.data.model.Contact;
import com.google.inject.Inject;
import com.google.inject.Singleton;


@Singleton
@Path("contact/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ContactResource {

    private final DataStore dataStore;
    private final Logger logger;

    @Inject
    public ContactResource(DataStore dataStore, Logger logger) {
        this.dataStore = dataStore;
        this.logger = logger;
    }

    @POST
    @Path("contact")
    public void postContact(String email, String firstName, String lastName,  String zipCode)
    {
    	
    	Contact contact = new Contact();
    	contact.setEmail(email);
    	contact.setFirstName(firstName);
    	contact.setLastName(lastName);
    	contact.setZipCode(zipCode);
    	contact.setCreatedOn(new Date());
    	logger.info("posted contact " + contact.getEmail());
    	dataStore.save(contact);
    }


}
