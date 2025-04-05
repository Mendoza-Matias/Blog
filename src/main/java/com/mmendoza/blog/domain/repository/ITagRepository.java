package com.mmendoza.blog.domain.repository;

import com.mmendoza.blog.domain.entity.Tag;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface ITagRepository extends JpaRepository<Tag, UUID> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE tags t SET t.name = :name WHERE t.id = :id", nativeQuery = true)
    void updateTagName(@Param(value = "id") UUID id, @Param(value = "name") String name);

    Boolean existsByName(String name);
}
