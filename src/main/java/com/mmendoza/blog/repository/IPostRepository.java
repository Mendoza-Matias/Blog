package com.mmendoza.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mmendoza.blog.models.entities.Post;

@Repository
public interface IPostRepository extends JpaRepository<Post, Integer> {
}
