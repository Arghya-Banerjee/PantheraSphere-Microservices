package com.pantherasphere.safari_service.service;

import com.pantherasphere.safari_service.entity.GuideMaster;

import java.util.List;
import java.util.UUID;

public interface GuideService {
    GuideMaster addGuide(GuideMaster guide);
    GuideMaster getGuide(UUID guideId);
    List<GuideMaster> getAllGuides();
}