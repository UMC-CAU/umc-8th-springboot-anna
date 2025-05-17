package umc.practice.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

// 8th mission
public class ReviewResponseDTO {
    @Getter
    @AllArgsConstructor
    public static class DetailDTO {
        private Long id;
        private Long store_id;
        private Long member_id;
        private Float score;
        private String body;
    }
}
