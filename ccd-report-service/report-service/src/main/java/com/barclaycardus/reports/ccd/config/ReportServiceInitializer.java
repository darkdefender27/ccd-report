package com.barclaycardus.reports.ccd.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;


/**
 * Created by abhishek on 18/01/16.
 */
public class ReportServiceInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext root = new AnnotationConfigWebApplicationContext();
        root.scan("com.barclaycardus.reports.ccd");

        servletContext.addListener(new ContextLoaderListener(root));
    }

}
