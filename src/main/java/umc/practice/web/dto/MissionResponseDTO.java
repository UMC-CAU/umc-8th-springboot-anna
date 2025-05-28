package umc.practice.web.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

// 8th mission
public class MissionResponseDTO {

    @Getter
    @AllArgsConstructor
    public static class DetailDTO {
        private Long id;
        private Long store_id;
        private Integer reward;
        private String missionSpec;
        private LocalDate deadline;
        private LocalDateTime created_at;
    }
    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class MissionPreviewDTO {
        private String missionSpc;
        private Integer reward;
        private LocalDate deadline;
        private LocalDateTime createdAt;
    }

    // 9th mission
    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class MissionListDTO {
        private List<MissionPreviewDTO> missionList;
        private Integer listSize;
        private Integer totalPage;
        private Long totalElements;
        private Boolean isFirst;
        private Boolean isLast;
    }
}
