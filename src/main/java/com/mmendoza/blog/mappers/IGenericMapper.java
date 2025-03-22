package com.mmendoza.blog.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface IGenericMapper<D, E> {

    IGenericMapper INSTANCE = Mappers.getMapper(IGenericMapper.class);

    E toEntity(D d);

    D toDto(E d);

    List<E> toEntiyList(List<D> ds);

    List<D> toDtoList(List<E> es);
}
