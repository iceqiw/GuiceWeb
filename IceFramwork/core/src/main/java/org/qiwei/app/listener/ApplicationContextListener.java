package org.qiwei.app.listener;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import org.apache.log4j.Logger;
import org.qiwei.app.module.Servlet3Module;
import org.qiwei.app.module.TestModule;

import javax.servlet.annotation.WebListener;

@WebListener
public class ApplicationContextListener extends GuiceServletContextListener {
    private static final Logger logger = Logger.getLogger(ApplicationContextListener.class);

    @Override
    protected Injector getInjector() {
        logger.info("Injector .......................");
        return Guice.createInjector(new TestModule("org.qiwei").add("*Dao").addImpl("Impl"), new Servlet3Module());
    }
}
