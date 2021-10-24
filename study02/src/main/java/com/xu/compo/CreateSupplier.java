package com.xu.compo;

import com.xu.model.User;
import org.springframework.stereotype.Component;

/**
 * @author canjin
 * @date 2021/10/24
 * @description
 */
@Component
public class CreateSupplier {

    public static User create(){
        return new User();
    }
}
