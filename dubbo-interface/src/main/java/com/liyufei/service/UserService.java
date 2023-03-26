package com.liyufei.service;

import com.liyufei.bean.InputParaDTO;
import com.liyufei.bean.UserDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> getUsers(InputParaDTO para);

}
