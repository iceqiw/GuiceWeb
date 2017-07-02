package org.qiwei.app.module;

import com.google.inject.Binder;
import com.google.inject.Module;
import org.qiwei.app.utils.ClassScaner;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by admin on 2017/6/29.
 */
public class TestModule implements Module {

    private static ClassScaner handler;

    private static List<String> classFilters = new ArrayList<>();

    private String packageName;

    private String implSuffix;

    public TestModule(String packageName) {
        this.packageName = packageName;
        if (handler == null) {
            handler = new ClassScaner(true, true, classFilters);
        }
    }

    public TestModule add(String filter) {
        classFilters.add(filter);
        return this;
    }

    public TestModule addImpl(String implSuffix) {
        this.implSuffix = implSuffix;
        return this;
    }

    @Override
    public void configure(Binder binder) {
        Set<Class<?>> calssList = handler.getPackageAllClasses(packageName, true);
        for (Class cla : calssList) {
            try {
                if (implSuffix != null) {
                    Class<?> icl = Class.forName(cla.getName() + implSuffix);
                    binder.bind(cla).to(icl);
                } else {
                    binder.bind(cla);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
