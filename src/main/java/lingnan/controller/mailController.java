package lingnan.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sun.mail.util.MailSSLSocketFactory;

@Controller
@RequestMapping("/mail")
public class mailController {

	//此处的参数，是接受前台传过来的值，参数名必须与传过来的参数名称一致，否则接收不到
	@RequestMapping(value="/sendMail",produces="text/html;charset=UTF-8",method=RequestMethod.GET)
    public String sendMail(String meet_title, String user_name,String meet_time,
            String mails) throws Exception{
        
        String content = "会议名称：" + meet_title + 
               "；开始时间："+  meet_time+"；我的姓名：" + user_name + 
                "；邮箱：" + mails ;
        
        System.out.println(content);
        //去掉第一个字符和最后一个字符
//        mails = mails.substring(1, mails.length()-1);
        sendMail(mails, meet_title, content);
        
       
      
       return  "forward:../mailTest.jsp";
    }
	
	
	public static void sendMail(String mails, String title, String content) throws Exception{
        
        Properties props = new Properties();  
       // 发送服务器需要身份验证  
       props.setProperty("mail.smtp.auth", "true");  
       // 设置邮件服务器主机名  
       props.setProperty("mail.host", "smtp.qq.com");  
       // 发送邮件协议名称  
       props.setProperty("mail.transport.protocol", "smtp"); 
       // 开启SSL加密，否则会失败
       MailSSLSocketFactory sf = new MailSSLSocketFactory();
       sf.setTrustAllHosts(true);
       props.put("mail.smtp.ssl.enable", "true");
       props.put("mail.smtp.ssl.socketFactory", sf);
       // 设置环境信息  
       Session session = Session.getInstance(props);  
       // 创建邮件对象  
       Message msg = new MimeMessage(session);  
       msg.setSubject(title);  
       // 设置邮件内容  
       msg.setText(content);  
       // 设置发件人 的名字 
       msg.setFrom(new InternetAddress("214177702@qq.com")); 
       Transport transport = session.getTransport();  
       // 连接邮件服务器  
       transport.connect("214177702@qq.com", "doeqxknymuarbjjb");  
       // 发送邮件  。设置收件人
       transport.sendMessage(msg, Address(mails));  
       // 关闭连接  
       transport.close();
}

	public static  InternetAddress[]  Address(String str){
		 
        //多个接收账号
      InternetAddress[] address=null;
      try {
          List list = new ArrayList();//不能使用string类型的类型，这样只能发送一个收件人
          if(str != null || "".equals(str)){
              String []median=str.split(",");//对输入的多个邮件进行逗号分割
              for(int i=0;i<median.length;i++){
            	  //单个添加
                  list.add(new InternetAddress(median[i]));
              }
          }else{
                //设置默认收件人的邮箱
              list.add(new InternetAddress("默认收件人的邮箱"));
          }
          //集合转数组
          address =(InternetAddress[])list.toArray(new InternetAddress[list.size()]);

         
     } catch (AddressException e) {
         e.printStackTrace();
     }
      return address;
  }


}
