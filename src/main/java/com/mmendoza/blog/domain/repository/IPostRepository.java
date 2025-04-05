package com.mmendoza.blog.domain.repository;

import com.mmendoza.blog.domain.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IPostRepository extends JpaRepository<Post, Integer> {

    @Query(value = "SELECT * FROM posts p WHERE p.title LIKE %:text% ", nativeQuery = true)
    List<Post> getPostContaining(@Param("text") String text);

    @Query(value = "SELECT * FROM posts p ORDER BY p.date_published DESC", nativeQuery = true)
    List<Post> findAllPostsOrderedDesc();

    @Query(value = "SELECT * FROM posts p ORDER BY p.date_published ASC", nativeQuery = true)
    List<Post> findAllPostsOrderedAsc();

    @Query(value = "SELECT DISTINCT * FROM  posts p JOIN  post_tags pt ON p.id = pt.post_id WHERE pt.tag_id IN = tag_ids", nativeQuery = true)
    List<Post> getPostsByTagIds(@Param("tag_ids") List<Integer> tagIds);
}
