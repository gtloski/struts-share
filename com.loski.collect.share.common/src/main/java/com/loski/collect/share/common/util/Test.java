package com.loski.collect.share.common.util;

public class Test {
	public static void main(String[] args){
		
	}
	
	public void sendMail(){
		try {
			System.out.println("邮件测试开始");
			MailUtil.send("1365996129@qq.com","邮件测试");
			System.out.println("邮件测试结束");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void qrcode(){
		try {
			String feedInImage = "http://f.hiphotos.baidu.com/baike/w%3D268/sign=f515a2ad367adab43dd01c45b3d5b36b/908fa0ec08fa513d2b9b7d5b3d6d55fbb2fbd905.jpg";
			QRcodeUtils.encode("我我我我我我http://coolshell.cn/articles/10590.html",
					300, 300, feedInImage, "E:\\2015-01.jpg");
			QRcodeUtils.encode("我我我我我我http://coolshell.cn/articles/10590.html",
					300, 300, null, "E:\\2015-02.jpg");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
