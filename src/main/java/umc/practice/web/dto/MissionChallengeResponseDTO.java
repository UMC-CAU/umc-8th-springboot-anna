package umc.practice.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import umc.practice.domain.enums.MissionStatus;

import java.time.LocalDateTime;

// 8th mission
public class MissionChallengeResponseDTO {
    @Getter
    @AllArgsConstructor
    public static class DetailChallengeDTO{
        private Long id;
        private Long memberId;
        private Long missionId;
        private MissionStatus missionStatus;
        private LocalDateTime createdAt;
    }
}
