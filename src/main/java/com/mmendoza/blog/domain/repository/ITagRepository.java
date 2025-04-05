package com.mmendoza.blog.domain.repository;

import com.mmendoza.blog.domain.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ITagRepository extends JpaRepository<Tag, UUID> {
}
