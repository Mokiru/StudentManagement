package com.example.data.controller;

import com.example.data.utils.GraphicHelper;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.io.ByteArrayOutputStream;

@Controller
@RequestMapping("/graphic")
public class CaptchaController {

    @GetMapping("/image/**")
    public ResponseEntity<byte[]> createImage(HttpSession session){
        // 创建一个字节数组输出流(其内部有一个数组用于缓存输出的字节)
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        // 调用工具类中的方法生成验证码图片并以字符串形式返回验证码
        String code = GraphicHelper.create(4, false, 180, 50, output, 50);
        // 将生成的验证码字符串设置到当前会话中
        session.setAttribute("CAPTCHA", code);
        // System.out.println( session.getAttribute("CAPTCHA"));
        // 从字节数组输出流中获取字节内容
        final byte[] body = output.toByteArray();
        // 创建HTTP响应对象
        final HttpHeaders headers = new HttpHeaders();
        // 设置响应头
        headers.setContentType(MediaType.IMAGE_JPEG); // headers.set("content-type", "image/jpeg");
        // 创建响应实体
        ResponseEntity<byte[]> entity = new ResponseEntity<>( body, headers, HttpStatus.OK);
        // 返回响应实体
        return entity;
    }

}
