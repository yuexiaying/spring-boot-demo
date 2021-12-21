package com.study.controller;

import com.study.domain.Param;
import com.study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fjding
 * @date 2021/12/20
 */
@RestController
public class TestController {

    @Autowired
    private UserService userService;

    @PostMapping("/getById")
    public Object getById(@RequestBody Param param){
        userService.setError(param.getError());
        return userService.getById(param.getId());
    }

    @PostMapping("/list")
    public Object list(@RequestBody Param param){
        userService.setError(param.getError());
        return userService.list();
    }

    @PostMapping("/insert")
    public Object insert(@RequestBody Param param){
        userService.setError(param.getError());
        userService.insert(param.getUser());
        return "ok";
    }

    @PostMapping("/update")
    public Object update(@RequestBody Param param){
        userService.setError(param.getError());
        userService.update(param.getUser());
        return "ok";
    }

    @PostMapping("/delete")
    public Object delete(@RequestBody Param param){
        userService.setError(param.getError());
        userService.delete(param.getId());
        return "ok";
    }

    @PostMapping("/inner")
    public Object inner(@RequestBody Param param){
        userService.setError(param.getError());
        userService.inner(param.getId());
        return "ok";
    }
}
