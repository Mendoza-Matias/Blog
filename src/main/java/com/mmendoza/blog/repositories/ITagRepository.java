package com.mmendoza.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mmendoza.blog.models.entities.Tag;

@Repository
public interface ITagRepository extends JpaRepository<Tag, Integer> {

    @Modifying
    @Query(value = "UPDATE tags t SET t.name = :name WHERE t.id = :id", nativeQuery = true)
    Integer updateTagName(@Param(value = "id") Integer id, @Param(value = "name") String name);

    Boolean existsByName(String name);
}
