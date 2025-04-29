package com.pantherasphere.safari_service.service.impl;

import com.pantherasphere.safari_service.entity.GuideMaster;
import com.pantherasphere.safari_service.repository.GuideMasterRepository;
import com.pantherasphere.safari_service.service.GuideService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GuideServiceImpl implements GuideService {

    private final GuideMasterRepository repo;

    @Override
    public GuideMaster addGuide(GuideMaster guide) {
        return repo.save(guide);
    }

    @Override
    public GuideMaster getGuide(UUID guideId) {
        return repo.findById(guideId)
                .orElseThrow(() -> new RuntimeException("Guide not found"));
    }

    @Override
    public List<GuideMaster> getAllGuides() {
        return repo.findAll();
    }
}
