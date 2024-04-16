package com.mya.ong.backend.myaong.post.controller;

import com.mya.ong.backend.myaong.post.domain.Post;
import com.mya.ong.backend.myaong.post.repository.PostRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class PostController {
    private final PostRepository repository;

    public PostController(PostRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/posts")
    @ResponseStatus(HttpStatus.CREATED)
    public Post savePost(@RequestBody Post post) {
        try {
            Post savedPost = repository.save(post);
            return savedPost;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "게시물을 저장하는 중에 오류가 발생했습니다. 요청이 올바른지 확인 해주세요.", e);
        }
    }


    @GetMapping("/posts")
    @ResponseStatus(HttpStatus.OK)
    public Collection<Post> getAllBooks() {
        Collection<Post> collection = repository.findAll();
        return collection;
    }

    @GetMapping("/posts/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Post getPodyById(@PathVariable Long id) {
        Post receivedPost = repository.findById(id)
                .orElseGet(Post::new);
        return receivedPost;
    }

    @PutMapping("/posts/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Post refreshPost(@PathVariable("id") long id, @RequestBody Post post) {
        Post updatedPost = repository.findById(id)
                .map(entity -> {
                    entity.setTitle(post.getTitle());
                    entity.setText(post.getText());
                    entity.setHashtag(post.getHashtag());
                    return repository.save(entity);
                })
                .orElseGet(Post::new);
        return updatedPost;
    }

    @DeleteMapping("/posts/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removePostById(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
