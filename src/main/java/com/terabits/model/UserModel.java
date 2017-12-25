package com.terabits.model;

import com.terabits.utils.AESUtil;

/** 
* @author 作者Vladimir E-mail: gyang.shines@gmail.com
* @version 创建时间：2017年12月22日 下午6:59:00 
* 类说明 
*/
public class UserModel{
    private String userName;
    private String email;
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void encrypt(String key){
        this.userName=AESUtil.byte2hex( AESUtil.AESJDKEncode(userName, key) );
        this.email=AESUtil.byte2hex( AESUtil.AESJDKEncode(email, key) );
    }
}

