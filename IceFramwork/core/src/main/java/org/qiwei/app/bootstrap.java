package org.qiwei.app;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.qiwei.app.module.Servlet3Module;
import org.qiwei.app.module.TestModule;
import org.qiwei.app.service.TestService;

/**
 * Created by admin on 2017/6/29.
 */
public class bootstrap {

    public static void main(String[] args) {
        Injector injector= Guice.createInjector( new TestModule("org.qiwei").add("*Dao").addImpl("Impl"),new Servlet3Module());

        TestService ts=injector.getInstance(TestService.class);

        ts.sayHello();


    }

}
