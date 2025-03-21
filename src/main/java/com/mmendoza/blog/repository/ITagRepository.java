package com.mmendoza.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mmendoza.blog.models.entities.Tag;

@Repository
public interface ITagRepository extends JpaRepository<Tag, Integer> {
    @Query("UPDATE tags t SET t.name = :name WHERE t.id = :id")
    Integer updateTagName(@Param(value = "id") Integer id, @Param(value = "name") String name); // consulta para
                                                                                                // modificar el nombre
                                                                                                // por id

    Boolean existsByName(String name);
}
