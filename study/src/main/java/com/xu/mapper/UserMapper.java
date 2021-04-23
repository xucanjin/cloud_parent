package com.xu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: canjin
 * @Date: 2021/3/9
 * 说明:
 */
@Repository
public interface UserMapper<User> extends BaseMapper<User>{

    List<User> findAllUser();
}
