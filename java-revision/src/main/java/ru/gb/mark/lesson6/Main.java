package ru.gb.mark.lesson6;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.apache.tomcat.util.descriptor.web.FilterDef;
import org.apache.tomcat.util.descriptor.web.FilterMap;
import ru.gb.mark.lesson6.servlet.HelloServlet;
import ru.gb.mark.lesson6.servlet.SecurityFilter;

import java.io.File;

public class Main {

    public static void main(String[] args) throws LifecycleException {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        tomcat.getConnector();
        tomcat.setBaseDir("temp");
        String contextPath = "/";
        String docBase = new File(".").getAbsolutePath();
        Context context = tomcat.addContext(contextPath, docBase);
        FilterDef filterDef = new FilterDef();
        String filterName = SecurityFilter.class.getName();
        filterDef.setFilterName(filterName);
        filterDef.setFilterClass(filterName);
        filterDef.setFilter(new SecurityFilter());
        context.addFilterDef(filterDef);
        FilterMap map = new FilterMap();
        map.setFilterName(filterName);
        map.addURLPattern("/*");
        context.addFilterMap(map);
        tomcat.addServlet(contextPath, HelloServlet.class.getSimpleName(), new HelloServlet());
        context.addServletMappingDecoded("/hello", "HelloServlet");
        tomcat.start();
        tomcat.getServer().await();
    }
}

