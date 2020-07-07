package com.ramostear.ckeditor.service;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.util.Collection;

/**
 * @author :     ramostear/树下魅狐
 * <p>This java file was created by ramostear in 2020/7/7 0007 5:50.
 * The following is the description information about this file:</p>
 * <p>description:</p>
 */
public interface FileManager {

    String upload(CommonsMultipartFile multipartFile);

    boolean remove(String url);

    void remove(Collection<String> urls);
}
