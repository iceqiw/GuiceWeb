package org.qiwei.app.service;

import org.qiwei.app.dao.TestDao;

import javax.inject.Inject;

/**
 * Created by admin on 2017/6/29.
 */
public class TestService {

    @Inject
    TestDao testDao;

    public void sayHello() {
        testDao.sayHello();
        System.out.println("service");
    }


}
