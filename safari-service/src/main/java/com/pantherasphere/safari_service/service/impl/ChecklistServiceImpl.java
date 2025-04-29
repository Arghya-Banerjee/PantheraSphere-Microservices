package com.pantherasphere.safari_service.service.impl;

import com.pantherasphere.safari_service.dto.ChecklistResponse;
import com.pantherasphere.safari_service.dto.CreateChecklistRequest;
import com.pantherasphere.safari_service.entity.ChecklistHeader;
import com.pantherasphere.safari_service.repository.ChecklistHeaderRepository;
import com.pantherasphere.safari_service.service.ChecklistService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChecklistServiceImpl implements ChecklistService {

    private final ChecklistHeaderRepository repo;

    @Override
    public ChecklistResponse createChecklist(CreateChecklistRequest req) {
        ChecklistHeader entity = new ChecklistHeader();
        entity.setForestId(req.getForestId());
        entity.setCreatedBy(req.getCreatedBy());
        entity.setSafariDate(req.getSafariDate());
        entity.setStartTime(req.getStartTime());
        entity.setGuideId(req.getGuideId());
        entity.setDriverId(req.getDriverId());
        ChecklistHeader saved = repo.save(entity);
        return map(saved);
    }

    @Override
    public ChecklistResponse getChecklistById(UUID id) {
        return repo.findById(id).map(this::map)
                .orElseThrow(() -> new RuntimeException("Checklist not found"));
    }

    @Override
    public List<ChecklistResponse> getAllChecklists() {
        return repo.findAll().stream().map(this::map).collect(Collectors.toList());
    }

    @Override
    public ChecklistResponse verifyChecklist(UUID id) {
        ChecklistHeader ch = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Checklist not found"));
        ch.setVerified(true);
        ch.setModifiedAt(java.time.LocalDateTime.now());
        return map(repo.save(ch));
    }

    private ChecklistResponse map(ChecklistHeader e) {
        ChecklistResponse r = new ChecklistResponse();
        r.setChecklistId(e.getChecklistId());
        r.setForestId(e.getForestId());
        r.setCreatedBy(e.getCreatedBy());
        r.setSafariDate(e.getSafariDate());
        r.setStartTime(e.getStartTime());
        r.setGuideId(e.getGuideId());
        r.setDriverId(e.getDriverId());
        r.setVerified(e.getVerified());
        r.setModifiedAt(e.getModifiedAt());
        return r;
    }
}
