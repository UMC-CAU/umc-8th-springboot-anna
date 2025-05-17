package umc.practice.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// 8th mission
public class ReviewRequestDTO {
    @Getter
    @Setter
    @NoArgsConstructor

    public static class CreateDTO{
        @NotNull
        private Float score;

        @NotBlank
        private String body;

        @NotNull
        private Long member_id;
    }
}
