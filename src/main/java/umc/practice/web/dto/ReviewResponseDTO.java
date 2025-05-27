package umc.practice.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

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

    // 9th 실습
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReviewPreViewListDTO {
        List<ReviewPreViewDTO> reviewList; // 리뷰 정보들의 목록
        Integer listSize;
        Integer totalPage;
        Long totalElements;
        Boolean isFirst;
        Boolean isLast;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReviewPreViewDTO {
        String ownerNickname;
        Float score;
        String body;
        LocalDate createdAt;
    }
}
