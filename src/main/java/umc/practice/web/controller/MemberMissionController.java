package umc.practice.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.practice.service.MemberMissionQueryService;
import umc.practice.web.dto.MissionResponseDTO;
import umc.practice.web.dto.PageRequestDTO;

// 9th mission
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/members/{memberId}/missions")
public class MemberMissionController {

    private final MemberMissionQueryService memberMissionQueryService;

    @GetMapping("/challenging")
    @Operation(summary = "현재 진행 중인 미션 목록 조회")
    public ResponseEntity<MissionResponseDTO.MissionListDTO> getChallengingMissions(
            @PathVariable Long memberId,
            @Valid @ModelAttribute PageRequestDTO pageRequestDTO) {

        int pageIndex = pageRequestDTO.getPage() - 1;
        MissionResponseDTO.MissionListDTO response = memberMissionQueryService.getChallengingMissions(memberId, pageIndex);
        return ResponseEntity.ok(response);
    }
}
