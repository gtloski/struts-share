package com.loski.collect.share.common.util;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailUtil {
	
	// 邮件发送配置文件
	private static Properties mailConfig = null;
	
	// 邮件发送状态：已完成
	private static final String MAIL_STATUS_DONE = "done";

	// 邮件发送状态：发送中
	private static final String MAIL_STATUS_PROCESSING = "processing";
	
	private static final String MAIL_PORT = "465";
	
	static {
		mailConfig = new Properties();
		try {
			ClassLoader classLoader = MailUtil.class.getClassLoader();
			mailConfig.load(classLoader.getResourceAsStream("mail.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static Session getSession(){
		
		final Properties props = new Properties();
        // 设置服务器地址
        props.put("mail.smtp.host", mailConfig.getProperty("host"));
        // 设置协议
        props.put("mail.store.protocol", mailConfig.getProperty("protocol"));
        // 设置端口
        final String port = mailConfig.getProperty("port");
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.auth", "true");
        
        //如果是QQ邮箱，必须加上下面的代码,不然无法发送
        if (MAIL_PORT.equals(port))
        {
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); 
            props.put("mail.smtp.socketFactory.port", mailConfig.getProperty("port")); 
        }
		
		Authenticator authenticator = new Authenticator() {
			
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(
						mailConfig.getProperty("from"),
						mailConfig.getProperty("pwd"));
			}
		};
		
		Session session = Session.getInstance(props, authenticator);
		
		return session;
	}
	
	/**
	 * 发送邮件
	 * 
	 * @param toEmail
	 *            收件地址
	 * @param content
	 *            发送内容
	 * @throws MessagingException
	 */
	public static void send(String toEmail, String content) throws Exception {
		Session session = getSession();
		// 初始化邮件信息对象
		Message msg = new MimeMessage(session);

		// 设置邮件属性
		msg.setFrom(new InternetAddress(mailConfig.getProperty("from")));
		InternetAddress[] address = { new InternetAddress(toEmail) };
		msg.setRecipients(Message.RecipientType.TO, address);
		msg.setSubject(mailConfig.getProperty("msg.subject"));
		msg.setSentDate(new Date());
		msg.setContent(content, "text/html;charset=utf-8");

		// 发送信息
		Transport.send(msg);
	}
	
	public static void main(String args[]){
		try {
			System.out.println("邮件测试开始");
			send("823292619@qq.com","邮件测试");
			System.out.println("邮件测试结束");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
