package ru.practicum.ewm.event_service.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.practicum.ewm.event_service.dto.EventDtoForRequestService;

@Slf4j
@Component
public class EventServiceClientFallback implements EventServiceClient {

    @Override
    public EventDtoForRequestService getEventById(Long eventId) {
        log.warn("Fallback: событие {} не найдено (event-service недоступен или ошибка)", eventId);
        return null;
    }

    @Override
    public EventDtoForRequestService incrementConfirmedRequests(Long eventId) {
        log.warn("Fallback: операция прошла некорректно для события {} (event-service недоступен или ошибка)", eventId);
        return null;
    }
}