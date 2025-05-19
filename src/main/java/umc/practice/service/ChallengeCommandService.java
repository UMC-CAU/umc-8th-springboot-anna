package umc.practice.service;

import umc.practice.web.dto.MissionChallengeRequestDTO;
import umc.practice.web.dto.MissionChallengeResponseDTO;

// 8th mission
public interface ChallengeCommandService {
    MissionChallengeResponseDTO.DetailChallengeDTO create(Long missionId, MissionChallengeRequestDTO.CreateChallengeDTO dto);
}
