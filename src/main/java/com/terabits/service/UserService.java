package com.terabits.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.terabits.dao.UserDao;
import com.terabits.model.UserModel;

/** 
* @author 作者Vladimir E-mail: gyang.shines@gmail.com
* @version 创建时间：2017年12月22日 下午6:57:52 
* 类说明 
*/
@Service("userService")
public class UserService {
    @Autowired
    @Qualifier("userDao")
    private UserDao userDao;
    
    public UserModel message(String id,String token){
        
        /*验证token......*/
        return userDao.getUserById(id);
    }
}

