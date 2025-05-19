package umc.practice.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

// 8th mission
public class MissionRequestDTO {
    @Getter
    @Setter
    @NoArgsConstructor

    public static class CreateDTO {
        @NotNull
        private Integer reward;

        @NotBlank
        private String missionSpec;

        @NotNull
        private LocalDate deadline;
    }
}
