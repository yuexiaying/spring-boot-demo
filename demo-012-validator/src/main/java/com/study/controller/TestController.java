package com.study.controller;

import com.study.domain.Address;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    /**
     * 使用绑定器注册属性器，但是并没有起作用
     *
     * @param webDataBinder
     */
  /*  @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.registerCustomEditor(Address.class, new AddressPropertyEditor());
    }*/

    @GetMapping("/test")
    public String test(Address address) {
        System.out.println(address);
        return "ok";
    }
}
