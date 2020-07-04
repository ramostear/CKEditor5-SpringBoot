package com.ramostear.ckeditor.service.impl;

import com.ramostear.ckeditor.model.Content;
import com.ramostear.ckeditor.repository.ContentRepository;
import com.ramostear.ckeditor.service.ContentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service(value = "contentService")
@Transactional(readOnly = true)
public class ContentServiceImpl implements ContentService {

    private final ContentRepository contentRepository;

    @Autowired
    ContentServiceImpl(ContentRepository contentRepository){
        this.contentRepository = contentRepository;
    }


    @Override
    @Transactional
    public Content save(Content content) {
        return contentRepository.save(content);
    }

    @Override
    @Transactional
    public boolean update(Content content) {
        Content target = this.findById(content.getId());
        if(target != null){
            BeanUtils.copyProperties(content,target,"id","createTime");
            contentRepository.saveAndFlush(target);
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public boolean delete(Integer id) {
        Optional<Content> check = contentRepository.findById(id);
        if(check.isPresent()){
            contentRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Content findById(Integer id) {
        return contentRepository.findById(id).orElse(null);
    }

    @Override
    public List<Content> findAll() {
        return contentRepository.findAll(Sort.by(Sort.Direction.DESC,"createTime"));
    }
}
