package com.xu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xu.bean.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: canjin
 * @Date: 2021/3/9
 * 说明:
 */
@Repository
public interface UserMapper extends BaseMapper<User>{

    List<User> findAllUser();
}
