package com.xu.factory;

import com.xu.fanshe.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author canjin
 * @date 2021/10/21
 * @description
 */
public class MyFactoryBean implements FactoryBean {

    @Override
    public Object getObject() throws Exception {
        return new User();
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
}
