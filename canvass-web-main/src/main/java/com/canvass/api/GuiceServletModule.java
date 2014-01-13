package com.canvass.api;

import org.apache.catalina.servlets.DefaultServlet;

import com.canvass.api.resource.BillResource;
import com.canvass.api.resource.HelloResource;
import com.canvass.data.DataStore;
import com.canvass.data.HibernateDataStore;
import com.canvass.filter.SecurityContextFilter;
import com.canvass.servlet.EnrollServlet;
import com.canvass.servlet.LoginServlet;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.google.inject.Scopes;
import com.google.inject.servlet.ServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;

public class GuiceServletModule extends ServletModule {
    @Override
    protected void configureServlets() {
        bind(DataStore.class).to(HibernateDataStore.class);

        // hook Resources to Guice Servlet
        bind(HelloResource.class);
        bind(BillResource.class);

        // hook Jersey into Guice Servlet
        bind(GuiceContainer.class);

        // hook Jackson into Jersey as the POJO <-> JSON mapper
        bind(JacksonJsonProvider.class).in(Scopes.SINGLETON);
        
        bind(DefaultServlet.class).in(Scopes.SINGLETON);

        // Filters
        // These are processed in order that they appear here
        filter("/api/*").through(SecurityContextFilter.class);

        // Routing
        // These are processed in order that they appear here
        serve("/api/*").with(GuiceContainer.class);
        serve("/enroll").with(EnrollServlet.class);
        serve("/login").with(LoginServlet.class);
        serve("/*").with(DefaultServlet.class);
        }
}