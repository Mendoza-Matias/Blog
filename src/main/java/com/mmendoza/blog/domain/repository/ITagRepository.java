package com.mmendoza.blog.domain.repository;

import com.mmendoza.blog.domain.entity.Tag;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ITagRepository extends JpaRepository<Tag, Integer> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE tags t SET t.name = :name WHERE t.id = :tag_id", nativeQuery = true)
    void updateTagName(@Param(value = "tag_id") Integer id, @Param(value = "name") String name);

    Boolean existsByName(String name);
}
