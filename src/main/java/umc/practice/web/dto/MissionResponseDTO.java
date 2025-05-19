package umc.practice.web.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
}
