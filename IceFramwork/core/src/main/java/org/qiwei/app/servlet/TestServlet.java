package org.qiwei.app.servlet;

import com.google.inject.Injector;
import org.apache.log4j.Logger;
import org.qiwei.app.service.TestService;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by admin on 2017/6/30.
 */
@Singleton
@WebServlet(name="test", urlPatterns="/act")
public class TestServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(TestServlet.class);

    @Inject
    private Injector inj;


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println(inj);
        resp.setContentType("application/json;charset=utf-8");
        resp.setHeader("Access-Control-Allow-Credentials", "true");
        resp.addHeader("P3P", "CP=CAO PSA OUR");
        resp.addHeader("Access-Control-Allow-Methods", "GET,HEAD,PUT,PATCH,POST,DELETE,OPTION");
        resp.addHeader("Access-Control-Allow-Origin", req.getHeader("Origin"));

        inj.getInstance(TestService.class).sayHello();

    }

}