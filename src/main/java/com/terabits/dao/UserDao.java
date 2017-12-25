package com.terabits.dao;

import org.springframework.stereotype.Repository;

import com.terabits.model.UserModel;

/** 
* @author 作者Vladimir E-mail: gyang.shines@gmail.com
* @version 创建时间：2017年12月22日 下午6:58:30 
* 类说明 
*/
@Repository("userDao")
public class UserDao {

    public UserModel getUserById(String id){
        UserModel user=new UserModel();
        user.setUserName("Vladimir");
        user.setEmail("gyang.shines@gmail.com");
        return user;
    }
    
    public String getAESKeyByUserId(String id) {
    	return "545253234";
    }
}

