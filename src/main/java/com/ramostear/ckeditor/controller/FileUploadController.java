package com.ramostear.ckeditor.controller;

import com.alibaba.fastjson.JSONObject;
import com.ramostear.ckeditor.service.FileManager;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author :       ramostear/树下魅狐
 * <p>This java file was created by ramostear in 2020/7/7 0007 16:51.
 * The following is the description information about this file:</p>
 * <p>description:</p>
 */
@RestController
@RequestMapping("/upload")
public class FileUploadController {

    private final FileManager fileManager;

    FileUploadController(FileManager fileManager){
        this.fileManager = fileManager;
    }

    @PostMapping("/image")
    public JSONObject image(@RequestParam(name = "upload")CommonsMultipartFile file){
        JSONObject json = new JSONObject();
        if(file == null || file.isEmpty()){
            json.put("uploaded",false);
            json.put("url","");
            return json;
        }
        if(StringUtils.isBlank(file.getOriginalFilename()) || !isAllow(file.getOriginalFilename())){
            json.put("uploaded",false);
            json.put("url","");
            return json;
        }
        String url = fileManager.upload(file);
        if(StringUtils.isBlank(url)){
            json.put("uploaded",false);
            json.put("url","");
            return json;
        }else{
            json.put("uploaded",true);
            json.put("url",url);
            return json;
        }
    }

    private boolean isAllow(String fileName){
        String[] allowFiles = {".gif",".png",".jpg",".jpeg",".bpm",".svg"};
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        List<String> suffixList = Arrays.stream(allowFiles).collect(Collectors.toList());
        return suffixList.contains(suffix);
    }
}
