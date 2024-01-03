package com.taskflow.dto.mapper;


import com.taskflow.dto.request.TagRequestDto;
import com.taskflow.entities.Tags;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.*;
import java.util.stream.Collectors;

@Mapper
public interface TagMapper {
    Class<? extends TagMapper> INSTANCE = Mappers.getMapperClass(TagMapper.class);
    @Mapping(target ="id" ,ignore = true)
    @Mapping(target ="tagName" ,source = "tagName")
    Tags tagDtoToTag(TagRequestDto tagRequestDto);
    default List<Tags> tagDtoListToTagList(Set<TagRequestDto> tags){
        return tags.stream()
                .map(this::tagDtoToTag)
                .collect(Collectors.toList());
    }
}