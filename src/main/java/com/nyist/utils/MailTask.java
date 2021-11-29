package com.nyist.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.Random;

public class MailTask {
    @Autowired
    private JavaMailSender mailSender;

    public String getMailCode(String mail){
        Random random = new Random();
        String code="";
        for (int i=0;i<6;i++)
        {
            code+=random.nextInt(10);
        }
        //邮件设置1：一个简单的邮件
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("来自【阿里云盘】的验证码消息");
        message.setText("您的验证码为 : 【 "+code+" 】,请勿泄露，祝您生活愉快！");

        message.setTo(mail);
        message.setFrom("2758907017@qq.com");
        this.mailSender.send(message);
        return code;
    }
}
