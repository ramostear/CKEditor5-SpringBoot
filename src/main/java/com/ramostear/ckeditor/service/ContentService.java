package com.ramostear.ckeditor.service;

import com.ramostear.ckeditor.model.Content;

import java.util.List;

public interface ContentService {

    /**
     * 保存内容
     * @param content
     * @return
     */
    Content save(Content content);

    /**
     * 修改内容
     * @param content
     * @return
     */
    boolean update(Content content);

    /**
     * 根据ID删除内容
     * @param id
     * @return
     */
    boolean delete(Integer id);

    /**
     * 根据ID查询内容
     * @param id
     * @return
     */
    Content findById(Integer id);

    /**
     * 获取所有的内容
     * @return
     */
    List<Content> findAll();
}
