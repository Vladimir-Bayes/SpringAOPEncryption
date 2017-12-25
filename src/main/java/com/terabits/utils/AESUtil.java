package com.terabits.utils;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/** 
* @author ����Vladimir E-mail: gyang.shines@gmail.com
* @version ����ʱ�䣺2017��12��12�� ����4:43:27 
* ��˵��
* byte2hex��hex2byteҪ���׵��ã���Ȼ���ǳ����� 
*/
public class AESUtil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String content = "{\"sites\":{\"site\":[{\"id\":\"1\",\"name\":\"����̳�\",\"url\":\"www.runoob.com\"}]}}";
//		String content = "[{\"key\":\"id\",\"value\":\"-1\",\"equals\":true,\"description\":\"\",\"enabled\":true},{\"key\":\"name\",\"value\":\"A\",\"equals\":true,\"description\":\"\",\"enabled\":true},{\"key\":\"tel\",\"value\":\"\",\"equals\":true,\"description\":\"\",\"enabled\":true},{\"key\":\"balance\",\"value\":\"-1\",\"equals\":true,\"description\":\"\",\"enabled\":true},{\"key\":\"timestamp\",\"value\":\"\",\"equals\":true,\"description\":\"\",\"enabled\":true},{\"key\":\"tablename\",\"value\":\"test1\",\"equals\":true,\"description\":\"\",\"enabled\":true},{\"key\":\"offset\",\"value\":\"0\",\"equals\":true,\"description\":\"\",\"enabled\":true},{\"key\":\"limit\",\"value\":\"10\",\"equals\":true,\"description\":\"\",\"enabled\":true}]";
//		String content = "{\"info\":[{\"Tel\":\"34567890123\",\"ID\":\"4\",\"Balance\":\"44.0\",\"Name\":\"Catd\",\"timestamp\":{\"date\":18,\"day\":1,\"hours\":14,\"minutes\":31,\"month\":11,\"nanos\":0,\"seconds\":52,\"time\":1513578712000,\"timezoneOffset\":-480,\"year\":117}},{\"Tel\":\"12345678901\",\"ID\":\"1\",\"Balance\":\"14\",\"Name\":\"Ana\",\"timestamp\":{\"date\":5,\"day\":2,\"hours\":9,\"minutes\":55,\"month\":11,\"nanos\":0,\"seconds\":0,\"time\":1512438900000,\"timezoneOffset\":-480,\"year\":117}}]}";
		String content = "Vladimir";
		String password = "545253234";
		byte[] encodeMessage = AESJDKEncode(content, password);
		String string = byte2hex(encodeMessage);
		
		System.out.println("AES ���ܺ�Ϊ��"+string);
//		ʵ���в�̫�����õ�encodeMessage���byte���飬��������£����ܶ��õ��Ķ��Ǿ�������֮����ַ�������˽��ܶ�Ҫ�Ƚ����ٽ���
		
		
		String string22 = "656F9659CAFCC0ED6A9E67345EC9EE6D4BBA016802848423EC528BD738C025DD";
		byte[] Message = AESUtil.hex2byte(string22);	
		byte[] decodeMessage = AESJDKDecode(Message, password);			
		System.out.println("AES ���ܺ�Ϊ��"+ new String(decodeMessage));

		// byte2hex��hex2byteҪ���׵��ã���Ȼ���ǳ����� 
		
		String string2 = CHexConver.byte2HexStr(encodeMessage, encodeMessage.length);
		System.out.println("AES ���ܺ�Ϊ��"+string2);
		byte[] Message2 = CHexConver.hexStr2Bytes(string2);
		byte[] decodeMessage2 = AESJDKDecode(Message2, password);
		System.out.println("AES ���ܺ�Ϊ��"+ new String(decodeMessage2));
			
	}
	
	public static byte[] AESJDKEncode(String message, String password) {
		try {
			KeyGenerator kgen = KeyGenerator.getInstance("AES");
			kgen.init(128, new SecureRandom(password.getBytes()));
			SecretKey secretKey = kgen.generateKey();
			byte[] enCodeFormat = secretKey.getEncoded();
			SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
			Cipher cipher = Cipher.getInstance("AES");//����������
			cipher.init(Cipher.ENCRYPT_MODE, key);//  ��ʼ��
			byte[] result = cipher.doFinal(message.getBytes()); //����
			return result;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public static byte[] AESJDKDecode(byte[] message, String password) {
		try {
			KeyGenerator kgen = KeyGenerator.getInstance("AES");
			kgen.init(128, new SecureRandom(password.getBytes()));
			SecretKey secretKey = kgen.generateKey();
			byte[] enCodeFormat = secretKey.getEncoded();
			SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
			Cipher cipher = Cipher.getInstance("AES");//����������
			cipher.init(Cipher.DECRYPT_MODE, key);//  ��ʼ��
			byte[] result = cipher.doFinal(message);  //����
			return result;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	 
    public static byte[] hex2byte(String strhex) {  
        if (strhex == null) {  
            return null;  
        }  
        int l = strhex.length();  
        if (l % 2 == 1) {  
            return null;  
        }  
        byte[] b = new byte[l / 2];  
        for (int i = 0; i != l / 2; i++) {  
            b[i] = (byte) Integer.parseInt(strhex.substring(i * 2, i * 2 + 2),  
                    16);  
        }  
        return b;  
    }  
  
    public static String byte2hex(byte[] b) {  
        String hs = "";  
        String stmp = "";  
        for (int n = 0; n < b.length; n++) {  
            stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));  
            if (stmp.length() == 1) {  
                hs = hs + "0" + stmp;  
            } else {  
                hs = hs + stmp;  
            }  
        }  
        return hs.toUpperCase();  
    }  
}
