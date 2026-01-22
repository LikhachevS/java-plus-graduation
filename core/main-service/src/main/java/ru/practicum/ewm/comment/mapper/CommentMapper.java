package ru.practicum.ewm.comment.mapper;

import org.mapstruct.*;
import ru.practicum.ewm.category.mapper.CategoryMapper;
import ru.practicum.ewm.comment.dto.CommentFullDto;
import ru.practicum.ewm.comment.dto.CommentPublicDto;
import ru.practicum.ewm.comment.dto.NewCommentDto;
import ru.practicum.ewm.comment.dto.UpdCommentDto;
import ru.practicum.ewm.comment.model.Comment;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface CommentMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "authorId", ignore = true)
    @Mapping(target = "event", ignore = true)
    @Mapping(target = "publishedOn", ignore = true)
    @Mapping(target = "state", ignore = true)
    Comment toEntity(NewCommentDto newDto);

    @Mapping(target = "authorId", source = "authorId")
    @Mapping(target = "eventId", source = "event.id")
    @Mapping(target = "publishedOn", expression = "java(toLocalDateTime(comment.getPublishedOn()))")
    CommentFullDto toFullDto(Comment comment);

    @Mapping(target = "authorName", ignore = true)
    @Mapping(target = "eventTitle", source = "event.title")
    @Mapping(target = "publishedOn", expression = "java(toLocalDateTime(comment.getPublishedOn()))")
    CommentPublicDto toPublicDto(Comment comment);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "authorId", ignore = true)
    @Mapping(target = "event", ignore = true)
    @Mapping(target = "publishedOn", ignore = true)
    @Mapping(target = "state", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateFromDto(UpdCommentDto updDto, @MappingTarget Comment comment);

    default LocalDateTime toLocalDateTime(Instant instant) {
        return instant != null ? LocalDateTime.ofInstant(instant, ZoneOffset.UTC) : null;
    }
}