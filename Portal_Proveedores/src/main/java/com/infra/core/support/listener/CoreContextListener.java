




package com.infra.core.support.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class CoreContextListener implements ServletContextListener {
    private static final String LOAD_TX_ACCIONES = "LOAD_TX_ACCIONES";
    private static Logger logger = LoggerFactory.getLogger(CoreContextListener.class);

    
    
    @Override    
    public void contextInitialized(ServletContextEvent sce) {
        logger.info("CoreContextListener.contextInitialized");
        logger.info(":::::::::::::::::: Cargando Acciones y Tx's ::::::::::::::");

        try {
            ServletContext ctx = sce.getServletContext();
            String attribute = (String) ctx.getInitParameter(LOAD_TX_ACCIONES);
            if ("true".equalsIgnoreCase(attribute)) {
                WebApplicationContext springContext = WebApplicationContextUtils.getWebApplicationContext(ctx);
                AutowireCapableBeanFactory factory = springContext.getAutowireCapableBeanFactory();
                factory.autowireBeanProperties(this, AutowireCapableBeanFactory.AUTOWIRE_BY_TYPE, false);
                logger.info("Revisando las acciones");
            } else {
                logger.info("No se cargaran las acciones y transacciones");
            }
        } catch (Exception e) {
            logger.error("Error al inicializar el contexto", e);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logger.info("CoreContextListener.contextDestroyed");

    }

}
