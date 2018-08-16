package com.product.management.productmanagement.service.support;

import com.product.management.productmanagement.entity.support.ActionLog;
import com.product.management.productmanagement.repository.IActionLogRepository;
import com.product.management.productmanagement.service.ILogService;
import com.product.management.productmanagement.util.ServiceUtils;
import com.product.management.productmanagement.util.SortConstants;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ActionLogService implements ILogService<ActionLog, String> {

    private IActionLogRepository actionLogRepository;
    private final ModelMapper mapper;

    public ActionLogService(IActionLogRepository actionLogRepository) {
        this.actionLogRepository = actionLogRepository;
        mapper = new ModelMapper();
    }

    @Override
    public Collection<ActionLog> loadAll() {
        List<ActionLog> actionLogs = actionLogRepository.findAll(ServiceUtils.sortBy(SortConstants.SORT_ACTION_LOG_DEFAULT_FIELD, SortConstants.ASC));
        return actionLogs.parallelStream().map(w -> mapper.map(w, ActionLog.class)).collect(Collectors.toList());
    }

    @Override
    public void addLog(ActionLog object) {
        actionLogRepository.insert(mapper.map(object, ActionLog.class));
    }

    @Override
    public void addLog(String username, String message, String type) {
        ActionLog actionLogDto = ActionLog.builder().principal(username)
                .message(message)
                .type(type)
                .time(new Timestamp(System.currentTimeMillis()))
                .build();
        addLog(actionLogDto);
    }

    @Override
    public Collection<ActionLog> fetchByTime(Timestamp startTime, Timestamp endTime) {
        List<ActionLog> actionLogs = actionLogRepository.findByTimeBetween(startTime, endTime);
        return actionLogs.parallelStream().map(w -> mapper.map(w, ActionLog.class)).collect(Collectors.toList());
    }
}
