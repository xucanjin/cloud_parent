package com.xu.es.service.impl;

import com.xu.es.bean.StudentEs;
import com.xu.es.mapper.StudentSearchMapper;
import com.xu.es.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xucanjin
 * @date 2021/12/26
 * @description
 */
@Service
public class StudentServiceImpl implements StudentService {

    private Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

    @Autowired
    private StudentSearchMapper studentSearchMapper;

    /**
     * 插入student
     * @param studentEs
     */
    @Override
    public void addStudent(StudentEs studentEs){
        studentSearchMapper.save(studentEs);
        logger.info("add success");
    }


}
