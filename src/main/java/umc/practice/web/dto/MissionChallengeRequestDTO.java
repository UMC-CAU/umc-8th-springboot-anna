package umc.practice.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import umc.practice.validation.annotation.IsMissionChallenging;

// 8th mission
public class MissionChallengeRequestDTO {
    @Getter
    @Setter
    @NoArgsConstructor
    @IsMissionChallenging
    public static class CreateChallengeDTO{
        @NotNull
        private Long memberId;
        @NotNull
        private Long missionId;
    }
}
