package com.terabits.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.terabits.model.UserModel;
import com.terabits.service.UserService;

/** 
* @author 作者Vladimir E-mail: gyang.shines@gmail.com
* @version 创建时间：2017年12月22日 下午6:57:02 
* 类说明 
*/
@Controller
@RequestMapping(value = "/user")
public class UserController {
    
    @Autowired
    @Qualifier("userService")
    private UserService userService;
    
    
    @RequestMapping(value="/message",method=RequestMethod.GET)
    public @ResponseBody UserModel message(@RequestParam("id") String id,@RequestParam("token") String token){
        return userService.message(id,token);
    }
}

