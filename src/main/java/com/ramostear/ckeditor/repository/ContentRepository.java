package com.ramostear.ckeditor.repository;

import com.ramostear.ckeditor.model.Content;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentRepository extends JpaRepository<Content,Integer> {
}
