package org.email;


import java.util.Date; 
import java.util.Properties; 
import javax.mail.Address; 
import javax.mail.Authenticator; 
import javax.mail.Message; 
import javax.mail.PasswordAuthentication; 
import javax.mail.Session; 
import javax.mail.Transport; 
import javax.mail.internet.InternetAddress; 
import javax.mail.internet.MimeMessage; 

import com.sun.mail.util.MailSSLSocketFactory;
 
 
public class Email 
{ 
    //mail server 
    private String host = "smtp.qq.com"; 
    //mail account  
    private String username = "1805984583@qq.com"; 
    //password 
    private String password = "ttzzlll638386"; 
     
    public String getHost() {
		return host;
	}


	public void setHost(String host) {
		this.host = host;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getMail_head_name() {
		return mail_head_name;
	}


	public void setMail_head_name(String mailHeadName) {
		mail_head_name = mailHeadName;
	}


	public String getMail_head_value() {
		return mail_head_value;
	}


	public void setMail_head_value(String mailHeadValue) {
		mail_head_value = mailHeadValue;
	}


	public String getMail_to() {
		return mail_to;
	}


	public void setMail_to(String mailTo) {
		mail_to = mailTo;
	}


	public String getMail_from() {
		return mail_from;
	}


	public void setMail_from(String mailFrom) {
		mail_from = mailFrom;
	}


	public String getMail_subject() {
		return mail_subject;
	}


	public void setMail_subject(String mailSubject) {
		mail_subject = mailSubject;
	}


	public String getMail_body() {
		return mail_body;
	}


	public void setMail_body(String mailBody) {
		mail_body = mailBody;
	}


	public String getPersonalName() {
		return personalName;
	}


	public void setPersonalName(String personalName) {
		this.personalName = personalName;
	}

	private String mail_head_name = "Head of test mail"; 
 
    private String mail_head_value = "Head of test mail"; 
 
    private String mail_to = "1805984583@qq.com"; 
 
    private String mail_from = "1805984583@qq.com"; 
 
    private String mail_subject = "Seed Borrow Information"; 
 
    private String mail_body = "content of of test mail"; 
 
    private String personalName = "Seed Borrow System"; 
 
    public Email() 
    { 
    } 
 
    
    /**
     * @throws Exception
     */
    /**
     * @throws Exception
     */
    /**
     * @throws Exception
     */
    public void send() throws Exception 
    { 
        try 
        { 
            Properties props = new Properties(); // 获取系统环境 
            Authenticator auth = new Email_Autherticator(); // 认证 
            props.put("mail.smtp.host", host); 
            props.put("mail.smtp.auth", "true"); 
       	    props.setProperty("mail.transport.protocol", "smtp");   //选择协议
       	    
       	    
       	    //设置SSL
       	    MailSSLSocketFactory sf = new MailSSLSocketFactory();    
       	    sf.setTrustAllHosts(true);  
       	    props.put("mail.smtp.ssl.enable", "true");  
       	    props.put("mail.smtp.ssl.socketFactory", sf); 
            Session session = Session.getDefaultInstance(props, auth); 
            //设置session,和邮件服务器进行通讯。 
            MimeMessage message = new MimeMessage(session); 
           
            message.setSubject(mail_subject);  
            message.setText(mail_body); // 设置邮件正文 
            message.setHeader(mail_head_name, mail_head_value); // 设置邮件标题 
            message.setSentDate(new Date()); // 设置邮件发送日期 
            Address address = new InternetAddress(mail_from, personalName); 
            message.setFrom(address); // 设置邮件发送者的地址 
            Address toAddress = new InternetAddress(mail_to); // 设置邮件接收方的地址 
            message.addRecipient(Message.RecipientType.TO, toAddress); 
            Transport.send(message); // 发送邮件 
            System.out.println("send over!"); 
        } catch (Exception ex) 
        { 
            ex.printStackTrace(); 
            throw new Exception(ex.getMessage()); 
        } 
    } 
 
    /*
     * 用来进行服务器对用户的认证
     */ 
    public class Email_Autherticator extends Authenticator 
    { 
        public Email_Autherticator() 
        { 
            super(); 
        } 
 
        public Email_Autherticator(String user, String pwd) 
        { 
            super(); 
            username = user; 
            password = pwd; 
        } 
 
        public PasswordAuthentication getPasswordAuthentication() 
        { 
            return new PasswordAuthentication(username, password); 
        } 
    } 
 
 
} 