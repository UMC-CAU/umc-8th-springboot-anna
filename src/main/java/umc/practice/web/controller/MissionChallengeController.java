package umc.practice.web.controller;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.practice.converter.MissionChallengeConverter;
import umc.practice.repository.MemberMissionRepository;
import umc.practice.repository.MemberRepository;
import umc.practice.repository.MissionRepository;
import umc.practice.service.ChallengeCommandService;
import umc.practice.validation.annotation.IsMissionChallenging;
import umc.practice.web.dto.MissionChallengeRequestDTO;
import umc.practice.web.dto.MissionChallengeResponseDTO;

// 8th mission

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/missions")
public class MissionChallengeController {
    private final ChallengeCommandService challengeCommandService;

    @PostMapping("/{missionId}/challenge")
    public ResponseEntity<MissionChallengeResponseDTO.DetailChallengeDTO> createMemberMission(
            @PathVariable Long missionId,
            @RequestBody @Valid MissionChallengeRequestDTO.CreateChallengeDTO requestDTO)  {

        MissionChallengeResponseDTO.DetailChallengeDTO response = challengeCommandService.create(missionId, requestDTO);
        return ResponseEntity.ok(response);
    }
}
