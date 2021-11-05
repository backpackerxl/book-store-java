package cn.backpackerxl.book.util;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * @author: backpackerxl
 * @create: 2021/10/29
 * @filename: SendEmail
 **/
public class SendEmail {
    /**
     * 邮件发送工具类
     * @param sendAddress
     * @param title
     * @param content
     * @param copysendAddress
     * @throws MessagingException
     */
    public static void SendEmailInfoUser(String sendAddress, String title, String content, String copysendAddress) throws MessagingException {
        Properties properties = new Properties();
        //设置服务器名称
        properties.setProperty("mail.host", "smtp.163.com");
        //设置邮件传输协议
        properties.setProperty("mail.transport.protocol", "smtp");
        //设置是否要验证服务器用户名和密码
        properties.setProperty("mail.smtp.auth", "true");
        //1.创建客户端与邮箱服务器的session对象
        Session session = Session.getInstance(properties);
        //2.开启session的debug模式，方便查看发送Email的运行状态
        session.getDebug();
        //3.通过session获得transport传输对象
        Transport transport = session.getTransport();
        //4.使用用户名和密码连接上邮箱服务器，密码是邮箱开启服务设置得到的授权码
        transport.connect("smtp.163.com", "backpackerxh@163.com", "YBDVDNCSBXMMWYRA");
        //5.创建邮件
        Message message = createSimpleMail(session, sendAddress, title, content, copysendAddress);
        //6.发送邮件
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }

    private static Message createSimpleMail(Session session, String sendAddress, String title, String content, String copysendAddress) throws MessagingException {
        //创建邮件对象
        MimeMessage message = new MimeMessage(session);
        //指明邮件发件人
        message.setFrom(new InternetAddress("backpackerxh@163.com"));
        //指明邮件的收件人
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(sendAddress));
        //邮件标题
        message.setSubject(title, "utf8");
        //邮件内容
        message.setContent(content, "text/html;charset=UTF-8");
        //设置抄送人
        message.setRecipients(Message.RecipientType.CC, copysendAddress);
        return message;
    }
}
