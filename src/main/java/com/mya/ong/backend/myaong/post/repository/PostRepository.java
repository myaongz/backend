package com.mya.ong.backend.myaong.post.repository;

import com.mya.ong.backend.myaong.post.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {       // <객체, 아이디 타입>
}