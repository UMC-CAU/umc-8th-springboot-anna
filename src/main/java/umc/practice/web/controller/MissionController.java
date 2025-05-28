package umc.practice.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.practice.service.MissionService.MissionCommandService;
import umc.practice.service.MissionService.MissionQueryService;
import umc.practice.validation.annotation.ExistStore;
import umc.practice.web.dto.MissionRequestDTO;
import umc.practice.web.dto.MissionResponseDTO;
import umc.practice.web.dto.PageRequestDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/stores/{storeId}/missions")
public class MissionController {

    private final MissionCommandService missionCommandService;
    private final MissionQueryService missionQueryService;

    @PostMapping
    public ResponseEntity<MissionResponseDTO.DetailDTO> createMission(
            @PathVariable Long storeId,
            @RequestBody @Valid MissionRequestDTO.CreateMissionDTO request) {

        MissionResponseDTO.DetailDTO response = missionCommandService.create(storeId, request);
        return ResponseEntity.ok(response);
    }

    // 9th mission
    @GetMapping
    @Operation(summary = "특정 가게의 미션 목록 조회", description = "가게 ID에 연결된 미션을 페이지 단위로 조회합니다.")
    public ResponseEntity<MissionResponseDTO.MissionListDTO> getMissionsByStore(
            @PathVariable @ExistStore Long storeId,
            @Valid @ModelAttribute PageRequestDTO pageRequestDTO) {

        int pageIndex = pageRequestDTO.getPage() - 1;
        MissionResponseDTO.MissionListDTO response = missionQueryService.getMissionsByStore(storeId, pageIndex);
        return ResponseEntity.ok(response);
    }
}

