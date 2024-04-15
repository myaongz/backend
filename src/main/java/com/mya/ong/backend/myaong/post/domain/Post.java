package com.mya.ong.backend.myaong.post.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
@Table(name = "post")
public class Post {
    @Id
    @Column(name="id", length = 45, nullable = false)
    public Long id;
    @Column(name="title", length = 45, nullable = false)
    public String title;
    @Column(name="text", nullable = false)
    public String text;
    @Column(name="userid", length = 45, nullable = false)
    public String userid;

}
