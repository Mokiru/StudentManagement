package com.example.data.controller;

import com.example.data.domain.CustomerDetails;
import com.example.data.service.CustomerDetailsService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/customer")
public class FileUploadController { // 图像上传

    @Autowired
    CustomerDetailsService cds;

    @GetMapping("/upload-pre")
    public String uploadPage(HttpSession session, RedirectAttributes attr) {
        if (session.getAttribute("Customer") == null || session.getAttribute("CustomerDetails") == null) {
            attr.addFlashAttribute("message", "请先登录");
            return "redirect:/";
        }
        return "redirect:/customer/details/update";
    }

    @PostMapping("/upload-pre")
    public String upload(String name, MultipartFile photo, HttpSession session) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        // 如果 已经有头像 or 图片 则在修改前需要删除
        if (photo != null) {

            String classFullPath = this.getClass().getResource("").toString();
            String classpath = classFullPath.substring(6, classFullPath.indexOf("target"))
                    + "src/main/resources/static/images/User/";
            String frontfilename = classpath + session.getAttribute("headshot").toString();

            Path path = Paths.get(frontfilename);
            boolean result = Files.deleteIfExists(path);

            System.out.println(result);
            // 名字
            map.put("name-param", name);

            // 文件名
            map.put("photo-name", photo.getName());

            // 文件类型 (content-type "photo.getContentType()")
            map.put("content-type", photo.getContentType());

            // 文件大小
            map.put("photo-size", photo.getSize());

            // eg: UUID + . + png
            String fileName = UUID.randomUUID() + "."
                    + photo.getContentType().substring(
                            photo.getContentType().lastIndexOf("/") + 1
            );// 创建 文件名称

            String filePath = classpath
                    + fileName;
            map.put("photo-path", filePath);
            File saveFile = new File(filePath);
//            System.out.println(filePath);
            photo.transferTo(saveFile);
            Long id = Long.parseLong(session.getAttribute("id").toString());
            cds.updateHeadshotByCId(fileName, id);
            session.setAttribute("headshot", fileName);
        }

        return "redirect:/customer/details/update";
    }
}
