package com.pantherasphere.safari_service.service.impl;

import com.pantherasphere.safari_service.dto.ChecklistItemRequestDTO;
import com.pantherasphere.safari_service.dto.ChecklistItemResponseDTO;
import com.pantherasphere.safari_service.entity.ChecklistItem;
import com.pantherasphere.safari_service.repository.ChecklistItemRepository;
import com.pantherasphere.safari_service.service.ChecklistItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChecklistItemServiceImpl implements ChecklistItemService {

    private final ChecklistItemRepository checklistItemRepository;

    @Override
    public ChecklistItemResponseDTO createChecklistItem(ChecklistItemRequestDTO requestDTO) {
        ChecklistItem checklistItem = new ChecklistItem();
        BeanUtils.copyProperties(requestDTO, checklistItem);
        checklistItem = checklistItemRepository.save(checklistItem);

        ChecklistItemResponseDTO responseDTO = new ChecklistItemResponseDTO();
        BeanUtils.copyProperties(checklistItem, responseDTO);
        return responseDTO;
    }

    @Override
    public ChecklistItemResponseDTO getChecklistItemById(UUID id) {
        ChecklistItem checklistItem = checklistItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ChecklistItem not found with ID: " + id));

        ChecklistItemResponseDTO responseDTO = new ChecklistItemResponseDTO();
        BeanUtils.copyProperties(checklistItem, responseDTO);
        return responseDTO;
    }

    @Override
    public List<ChecklistItemResponseDTO> getAllChecklistItems() {
        return checklistItemRepository.findAll()
                .stream()
                .map(item -> {
                    ChecklistItemResponseDTO dto = new ChecklistItemResponseDTO();
                    BeanUtils.copyProperties(item, dto);
                    return dto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public void deleteChecklistItem(UUID id) {
        checklistItemRepository.deleteById(id);
    }
}
