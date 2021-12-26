package com.xu.controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.IterUtil;
import cn.hutool.core.util.RandomUtil;
import com.xu.es.bean.StudentEs;
import com.xu.es.bean.UserEs;
import com.xu.es.mapper.StudentSearchMapper;
import com.xu.es.service.StudentService;
import com.xu.es.service.UserEsService;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xucanjin
 * @date 2021/12/26
 * @description
 */
@RestController
@RequestMapping("/es")
public class EsController {

    @Autowired
    private UserEsService userEsService;

    @Autowired
    private StudentService studentService;
    @RequestMapping("add")
    public String add() {
        for (int i = 0; i < 10; i++) {
            UserEs es = new UserEs();
            es.setAge(RandomUtil.randomInt(100));
            es.setId(RandomUtil.randomInt(100));
            es.setName("测试" + RandomUtil.randomInt(1000));
            userEsService.add(es);
        }
        return "success";
    }

    @RequestMapping("find")
    public List<UserEs> find() {
        return userEsService.find();
    }

    @RequestMapping("findById")
    public UserEs findById(String id) {
        return userEsService.findById(id);
    }

    @RequestMapping("del")
    public String deleteAll() {
        userEsService.delAll();
        return "delete";
    }

    @RequestMapping("delById")
    public String deleteById(String id) {
        userEsService.del(id);
        return "delete";
    }


    @RequestMapping("add/student")
    public String addStudent() {
        for (int i = 0; i < 10; i++) {
            StudentEs studentEs = new StudentEs();
            studentEs.setId(RandomUtil.randomInt(200));
            studentEs.setAddress("地址" + RandomUtil.randomInt(100));
            studentEs.setName("测试" + RandomUtil.randomInt(1000));
            studentEs.setCourse("课程" + RandomUtil.randomInt(300));
            studentService.addStudent(studentEs);
        }
        return "success";
    }


    @Autowired
    private StudentSearchMapper studentSearchMapper;

    @RequestMapping("find/student")
    public List<StudentEs> findStudent() {
        Iterable<StudentEs> all = studentSearchMapper.findAll();
        List<StudentEs> list = new ArrayList<>();
        all.forEach(studentEs -> list.add(studentEs) );
        return list;
    }

    @RequestMapping("student/findPage")
    public Page<StudentEs> findPage() {
        Page<StudentEs> page = studentSearchMapper.search(QueryBuilders.matchAllQuery(), PageRequest.of(1, 5));
        return page;
    }

}
