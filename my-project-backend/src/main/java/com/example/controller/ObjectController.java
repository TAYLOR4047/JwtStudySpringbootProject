package com.example.controller;


import com.example.entity.RestBean;
import com.example.service.ImageService;
import io.minio.errors.ErrorResponseException;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
public class ObjectController {

    @Resource
    ImageService service;

    @GetMapping("/images/avatar/**")
    public void imageFetch(HttpServletRequest request, HttpServletResponse response) throws Exception {
        this.fetchImage(request, response);
    }

    private void fetchImage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //为了获取头像对应的URL,去掉前七个字符/images/avatar/**（留下**部分）
        String imagePath=request.getServletPath().substring(7);
        ServletOutputStream stream=response.getOutputStream();
        if(imagePath.length()<=13){
            log.info("Avatar的URL过短，无法找到");
            stream.println(RestBean.failure(404,"Not Found").toString());
        }else{
            try {
                service.fetchImageFromMinio(stream,imagePath);
                response.setHeader("Cache-Control","max-age=2592000");
            } catch (ErrorResponseException e) {
                if(e.response().code()==404){
                    response.setStatus(404);
                    stream.println(RestBean.failure(404,"Not Found").toString());
                }else{
                    log.error("从minio获取图片出现异常： "+e.getMessage(),e);
                }
            }
        }
    }
}