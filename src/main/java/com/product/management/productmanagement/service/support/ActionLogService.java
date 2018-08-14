package com.product.management.productmanagement.service.support;

import com.product.management.productmanagement.dto.ActionLogDto;
import com.product.management.productmanagement.entity.support.ActionLog;
import com.product.management.productmanagement.repository.IActionLogRepository;
import com.product.management.productmanagement.service.ILogService;
import com.product.management.productmanagement.util.ServiceUtils;
import com.product.management.productmanagement.util.SortConstants;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ActionLogService implements ILogService<ActionLogDto, String, ActionLog> {

    private IActionLogRepository actionLogRepository;
    private final ModelMapper mapper;

    public ActionLogService(IActionLogRepository actionLogRepository) {
        this.actionLogRepository = actionLogRepository;
        mapper = new ModelMapper();
    }

    @Override
    public Collection<ActionLogDto> loadAll() {
        List<ActionLog> actionLogs = actionLogRepository.findAll(ServiceUtils.sortBy(SortConstants.SORT_ACTION_LOG_DEFAULT_FIELD, SortConstants.ASC));
        return actionLogs.parallelStream().map(w -> mapper.map(w, ActionLogDto.class)).collect(Collectors.toList());
    }

    @Override
    public void addLog(ActionLogDto object) {

    }

    @Override
    public Collection<ActionLogDto> fetchByTime(Timestamp startTime, Timestamp endTime) {
        return null;
    }
}
