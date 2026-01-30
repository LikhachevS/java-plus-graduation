package ru.practicum.ewm.service;

import ru.practicum.ewm.dto.CommentFullDto;
import ru.practicum.ewm.dto.CommentPublicDto;
import ru.practicum.ewm.dto.NewCommentDto;
import ru.practicum.ewm.dto.UpdCommentDto;

import java.util.List;

public interface CommentService {

    List<CommentPublicDto> getAllBy(Long eventId);

    List<CommentFullDto> getAllBy(Long userId, Long eventId);

    CommentFullDto add(NewCommentDto dto, Long eventId, Long userId);

    CommentFullDto hide(Long eventId, Long commentId, boolean published);

    void delete(Long userId, Long commentId);

    CommentFullDto update(Long userId, Long commentId, UpdCommentDto updDto);
}