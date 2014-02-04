package com.canvass.api;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;

/**
 * Created By: jordancote
 * Created On: 1/1/14
 */
public class TestGuiceServletConfig extends GuiceServletContextListener {

    @Override
    protected Injector getInjector() {
        return Guice.createInjector(new TestGuiceServletModule());
    }
}