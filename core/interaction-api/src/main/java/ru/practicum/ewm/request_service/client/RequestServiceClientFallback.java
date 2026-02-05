package ru.practicum.ewm.request_service.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.practicum.ewm.request_service.dto.EventRequestStatusUpdateRequest;
import ru.practicum.ewm.request_service.dto.ParticipationRequestDto;

import java.util.List;

@Slf4j
@Component
public class RequestServiceClientFallback implements RequestServiceClient {

    @Override
    public List<ParticipationRequestDto> getEventRequests(Long userId, Long eventId) {
        log.error("Вызов getEventRequests({}, {}) упал в fallback. Возврат пустого списка.", userId, eventId);
        return List.of();
    }

    @Override
    public List<ParticipationRequestDto> getRequestsByIds(List<Long> requestIds) {
        log.error("Вызов getRequestsByIds({}) упал в fallback. Возврат пустого списка.", requestIds);
        return List.of();
    }

    @Override
    public List<ParticipationRequestDto> updateRequestStatuses(EventRequestStatusUpdateRequest request) {
        log.error("Вызов updateRequestStatuses({}) упал в fallback. Возврат пустого списка.", request);
        return List.of();
    }

    @Override
    public boolean isParticipant(Long userId, Long eventId) {
        log.error("Вызов isParticipant({}, {}) упал в fallback. Возврат пустого списка.", userId, eventId);
        return false;
    }
}