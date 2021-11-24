package com.example.demo.controller;

import com.sun.deploy.net.URLEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @author ranran.mao
 * @date 2021/11/22 18:47
 */
@RestController
@RequestMapping("/ranmao")
public class FileDownloadController {
    private static final Logger logger = LoggerFactory.getLogger(FileDownloadController.class);
    @Value("${filepath}")
    private String filePath;

    @RequestMapping("/file.html")
    public ModelAndView File() {
        return new ModelAndView("file.html");
    }

    /**
     * 文件上传
     */
    @PostMapping("/upload")
    public String uploading(@RequestParam("file") MultipartFile file) {
        File targetFile = new File(filePath);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        try (FileOutputStream out = new FileOutputStream(filePath + file.getOriginalFilename())) {
            out.write(file.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            logger.error("上传文件失败");
            return "upload failure";
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("上传文件失败");
            return "upload failure";
        }
        return "upload success";
    }

    @RequestMapping("/download")
    public void download(HttpServletResponse response, @RequestParam("filename") String filename) throws UnsupportedEncodingException {
        String targetFilename = filename;
        String targetFilePath = filePath;
        File file = new File(targetFilePath + "/" + targetFilename);
        if (file.exists()) {
            response.setContentType("application/octet-stream");
            response.setHeader("context-type", "application/octet-stream");
            response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(filename, "utf8"));
            byte[] buffer = new byte[1024];
            OutputStream outputStream = null;
            try {
                FileInputStream inputStream = new FileInputStream(file);
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                outputStream = response.getOutputStream();
                int i = bufferedInputStream.read(buffer);
                while (i != -1) {
                    outputStream.write(buffer);
                    i = bufferedInputStream.read(buffer);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
