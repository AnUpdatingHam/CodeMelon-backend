package org.rhythm.controller;

import org.rhythm.entity.User;
import org.rhythm.vo.UserLoginVO;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

//只是一个用于测试是否连通的controller
@RequestMapping("/admin/hello")
@Api(tags = "测试接口")
@RestController
@Slf4j
public class HelloController {

    @RequestMapping
    public String hello(){
        System.out.println("hello");
        return "hello";
    }

    @GetMapping("/user")
    public UserLoginVO helloUser(){
        UserLoginVO userLoginVO = UserLoginVO.builder()
                .id(66L)
                .username("我是响应VO的用户名")
                .name("我是响应VO的姓名")
                .token("我是token : %!@$ADERQ!@#FAF(^_^)")
                .build();
        System.out.println("收到前端Get请求，返回VO对象");
        return userLoginVO;
    }

    @PostMapping("/post")
    public UserLoginVO postHelloUser(@RequestBody User user){
        System.out.println("前端发送的user:" + user);
        UserLoginVO userLoginVO = UserLoginVO.builder()
                .id(66L)
                .username("我是响应VO的用户名")
                .name("我是响应VO的姓名")
                .token("我是token : %!@$ADERQ!@#FAF(^_^)")
                .build();
        System.out.println("收到前端Get请求，返回VO对象");
        return userLoginVO;
    }

    @PutMapping("/put")
    public UserLoginVO putHelloUser(@RequestBody User user){
        System.out.println("前端发送的user:" + user);
        

        UserLoginVO userLoginVO = UserLoginVO.builder()
                .id(66L)
                .username("我是响应VO的用户名")
                .name("我是响应VO的姓名")
                .token("我是token : %!@$ADERQ!@#FAF(^_^)")
                .build();
        System.out.println("收到前端Get请求，返回VO对象");
        return userLoginVO;
    }

    @RequestMapping("/abc")
    public String abc(){
        System.out.println("efg");
        return "efg";
    }

}
