package com.mya.ong.backend.myaong.post.controller;

import com.mya.ong.backend.myaong.post.domain.Post;
import com.mya.ong.backend.myaong.post.repository.PostRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

// 없는 리소스에 대한 예외 처리 필요
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
        Post savePost = repository.save(post);
        return savePost;
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
                .orElseThrow(() -> new EntityNotFoundException("Entity with id = Not found"));
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
                .orElseThrow(() -> new EntityNotFoundException("Post with id = Not found"));
        return updatedPost;
    }

    @DeleteMapping("/posts/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removePostById(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
