package com.terabits.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.terabits.dao.UserDao;
import com.terabits.model.UserModel;
import com.terabits.utils.AESUtil;

/** 
* @author 作者Vladimir E-mail: gyang.shines@gmail.com
* @version 创建时间：2017年12月25日 下午1:43:05 
* 类说明 
*/
@Component("AESAspect")
@Aspect
public class AESAspect {

    @Autowired
    @Qualifier("userDao")
    private UserDao userDao;

    @Pointcut("execution(* com.terabits.service.UserService.message(..))")
    public void messagePointcut() {}

    @Around("messagePointcut()")
    public UserModel messagePointcut(ProceedingJoinPoint point) throws Throwable {
    	System.out.println("进入AOP***************************");
    	Object[] args = point.getArgs();
        String id = (String) args[0];
        String key = userDao.getAESKeyByUserId(id);
        
        System.out.println("对参数进行解密***************************");
        for (int i = 0; i < args.length; i++) {
        	byte[] Message = AESUtil.hex2byte((String) args[i]);
        	byte[] decodeMessage = AESUtil.AESJDKDecode(Message, key);
        	args[i] =  new String(decodeMessage);//AES解密
        	System.out.println(args[i]+"*******************");
        }
        
//      byte[] Message = AESUtil.hex2byte((String) args[1]);
//		byte[] decodeMessage = AESUtil.AESJDKDecode(Message, key);
//		new String(decodeMessage);//AES解密
//        
//        AESCodec.decrypt((String) args[1], key);
        // 执行
        System.out.println("方法执行之前***********************");
        UserModel result = (UserModel) point.proceed(args);
        // 返回值加密
        System.out.println("方法执行之后***********************");
        result.encrypt(key);
        // 返回结果
        return result;
    }
}


