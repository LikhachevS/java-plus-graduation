package ru.practicum.ewm.collector.stats.service;

import ru.practicum.ewm.stats.proto.UserActionProto;

public interface UserActionService {

    void collectUserAction(UserActionProto userActionProto);

}