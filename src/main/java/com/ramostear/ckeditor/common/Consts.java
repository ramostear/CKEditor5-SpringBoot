package com.ramostear.ckeditor.common;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;

/**
 * @author :       ramostear/树下魅狐
 * <p>This java file was created by ramostear in 2020/7/7 0007 5:46.
 * The following is the description information about this file:</p>
 * <p>description:</p>
 */
public class Consts {

    public static String FILE_STORAGE_ROOT = getRootPath();

    private static String getRootPath(){
        try {
            Resource resource = new ClassPathResource("");
            return resource.getFile().getAbsolutePath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
