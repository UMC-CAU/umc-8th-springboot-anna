package umc.practice.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.practice.service.MissionCommandService;
import umc.practice.web.dto.MissionRequestDTO;
import umc.practice.web.dto.MissionResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/stores/{storeId}/missions")
public class MissionController {

    private final MissionCommandService missionCommandService;

    @PostMapping
    public ResponseEntity<MissionResponseDTO.DetailDTO> createMission(
            @PathVariable Long storeId,
            @RequestBody @Valid MissionRequestDTO.CreateMissionDTO request) {

        MissionResponseDTO.DetailDTO response = missionCommandService.create(storeId, request);
        return ResponseEntity.ok(response);
    }
}

