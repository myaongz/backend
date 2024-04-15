package com.mya.ong.backend.myaong.post.service;

import com.mya.ong.backend.myaong.post.domain.Post;

import java.util.Optional;

public interface PostService {
    public interface ProductService {
        public Post save(Post post);
        public Optional<Post> findById(Long id);
        public Post update(Long id, Post post);
        public void delete (Long id);
    }
}
