package com.ramostear.ckeditor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author :       ramostear/树下魅狐
 * <p>This java file was created by ramostear in 2020/7/8 0008 0:38.
 * The following is the description information about this file:</p>
 * <p>description:</p>
 */
@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(Model model){
        model.addAttribute("message","Hello CKEditor5");
        return "hello";
    }
}
