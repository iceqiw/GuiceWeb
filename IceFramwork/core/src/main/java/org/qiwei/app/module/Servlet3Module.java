package org.qiwei.app.module;

import com.google.inject.servlet.ServletModule;
import org.qiwei.app.servlet.TestServlet;

/**
 * Created by admin on 2017/6/30.
 */
public class Servlet3Module extends ServletModule {


    @Override
    protected void configureServlets() {
        //配置你访问的servlet
        //serve("/UserServlet").with(UserServlet.class);

        //如果你一个servlet拥有多个访问地址，这样配置就可以了
        serve("/act").with(TestServlet.class);

        //如果你想你的url支持正则匹配，可以像下面这样写
        //serveRegex("^user").with(UserServlet.class);

        //同理filter配置如下
        //filter("/encodeFilter").through(EncodeFilter.class);

        //多个地址
        //filter("/encodeFilter","/haha").through(EncodeFilter.class);

        //支持正则
        //filterRegex("^aaa").through(EncodeFilter.class);

    }

}
