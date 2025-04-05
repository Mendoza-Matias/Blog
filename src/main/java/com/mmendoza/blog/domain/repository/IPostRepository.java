package com.mmendoza.blog.domain.repository;

import com.mmendoza.blog.domain.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IPostRepository extends JpaRepository<Post, UUID> {
}
