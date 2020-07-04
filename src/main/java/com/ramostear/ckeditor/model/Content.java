package com.ramostear.ckeditor.model;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

/**
 * @author :       ramostear/树下魅狐
 * <p>This java file was created by ramostear in 2020/7/4 0004 17:39.
 * The following is the description information about this file:</p>
 * <p>description:</p>
 */
@Data
@Entity
@Table(name = "content")
public class Content {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Lob
    @Type(type = "text")
    @Column(name = "text")
    private String text;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_time",columnDefinition = "timestamp default CURRENT_TIMESTAMP")
    private Date createTime;

    @PrePersist
    public void prePersist(){
        this.id = null;
        this.createTime = new Date();
        if(text == null || text.trim().equals("")){
            text = "";
        }
    }
}
