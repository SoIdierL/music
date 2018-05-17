package com.music.vuemusic.controller;


import com.music.vuemusic.entity.ResponseA;
import com.music.vuemusic.entity.userinfo;
import com.music.vuemusic.service.UserService;
import org.omg.CORBA.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService UserService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String UserController(){

        return "aaaaaaaaaaaaaaaaaaaaaaaa";
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)

    public ResponseA<userinfo> register (@RequestBody userinfo param,
                                        HttpServletRequest request,
                                        HttpServletResponse response
    ) {
        ResponseA<userinfo> resp = new ResponseA<>();
        userinfo info = new userinfo();
        info.setUsername(param.getUsername());
        info.setPassword(param.getPassword());
        info.setSex(param.getSex());
        info.setMediaId(param.getMediaId());
        try {
            info=  UserService.insert(info);
            resp.setData(info);
        } catch (com.music.vuemusic.entity.UserException e) {
            return resp.fail(e.getMessage());
        }
        return resp;
    }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ResponseA<userinfo> login (@RequestBody userinfo param,
                                         HttpServletRequest request,
                                         HttpServletResponse response
    ) {
        ResponseA<userinfo> resp = new ResponseA<>();
        userinfo info = new userinfo();
        info.setUsername(param.getUsername());
        info.setPassword(param.getPassword());

        try {
            info=  UserService.login(info);
            resp.setData(info);
        } catch (com.music.vuemusic.entity.UserException e) {
            return resp.fail(e.getMessage());
        }
        return resp;
    }


}
