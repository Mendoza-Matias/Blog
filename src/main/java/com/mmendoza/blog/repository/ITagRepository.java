package com.mmendoza.blog.repository;

import com.mmendoza.blog.models.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITagRepository extends JpaRepository<Tag, Integer> {
}
