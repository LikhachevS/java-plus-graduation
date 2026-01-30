package ru.practicum.ewm.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.practicum.ewm.request_service.dto.EventRequestStatusUpdateRequest;
import ru.practicum.ewm.request_service.dto.ParticipationRequestDto;
import ru.practicum.ewm.service.RequestService;

import java.util.List;

@RestController
@RequestMapping("/internal/requests")
@RequiredArgsConstructor
@Slf4j
public class InternalRequestController {

    private final RequestService requestService;

    @GetMapping("/events/{eventId}")
    public ResponseEntity<List<ParticipationRequestDto>> getEventRequests(
            @RequestParam("userId") Long userId,
            @PathVariable("eventId") Long eventId) {

        log.debug("Внутренний контроллер: получение заявок для userId={}, eventId={}", userId, eventId);

        List<ParticipationRequestDto> requests = requestService.getEventRequests(userId, eventId);

        return ResponseEntity.ok(requests);
    }

    @GetMapping("/by-ids")
    public ResponseEntity<List<ParticipationRequestDto>> getRequestsByIds(
            @RequestParam List<Long> requestIds) {

        List<ParticipationRequestDto> dtos = requestService.getRequestsByIds(requestIds);
        return ResponseEntity.ok(dtos);
    }

    @PutMapping("/status")
    public ResponseEntity<List<ParticipationRequestDto>> updateRequestStatuses(
            @RequestBody EventRequestStatusUpdateRequest request) {

        List<ParticipationRequestDto> updatedDtos = requestService.updateRequestStatuses(
                request.getRequestIds(),
                request.getStatus()
        );
        return ResponseEntity.ok(updatedDtos);
    }
}
