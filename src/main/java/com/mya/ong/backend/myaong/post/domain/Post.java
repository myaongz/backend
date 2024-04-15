package com.mya.ong.backend.myaong.post.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Column(name="title", length = 45, nullable = false)
    public String title;
    @Column(name="text", nullable = false)
    public String text;
    @Column(name="hashtag", length = 45, nullable = false)
    public String hashtag;

}
