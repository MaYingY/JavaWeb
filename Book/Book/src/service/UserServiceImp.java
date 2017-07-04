package service;

import cn.itcast.mail.Mail;
import cn.itcast.mail.MailUtils;
import dao.UserDao;
import domain.User;
import exception.RegistException;

import javax.mail.MessagingException;
import javax.mail.Session;
import java.io.IOException;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.Properties;

/**
 * Created by zzp on 2017/4/10.
 */
public class UserServiceImp implements UserService {
    private UserDao dao = new UserDao();

    public void regist(User user) throws IOException, RegistException {
        try {
            dao.addUser(user);
        } catch (SQLException e) {
            throw new RegistException("注册失败");
        }

        //发送邮件
        Properties props = new Properties();
        props.load(this.getClass().getClassLoader()
                .getResourceAsStream("email-config.properties"));
        String host = props.getProperty("host");//获取服务器主机
        String uname = props.getProperty("uname");//获取用户名
        String pwd = props.getProperty("pwd");//获取密码
        String from = props.getProperty("from");//获取发件人
        String to = user.getEmail();//获取收件人
        String subject = props.getProperty("subject");//获取主题
        String content = props.getProperty("content");//获取邮件内容
        content = MessageFormat.format(content, user.getActivecode(), user.getActivecode());//替换

        Session session = MailUtils.createSession(host, uname, pwd);//得到session
        Mail mail = new Mail(from, to, subject, content);//创建邮件对象
        try {
            MailUtils.send(session, mail);//发邮件！
        } catch (MessagingException e) {
            throw new RegistException("发送邮件失败");
        }
    }

    public void activeUser(String activeCode) {
    }
}
