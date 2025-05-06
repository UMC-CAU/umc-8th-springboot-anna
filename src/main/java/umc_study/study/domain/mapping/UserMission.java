package umc_study.study.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import umc_study.study.domain.Mission;
import umc_study.study.domain.User;

import java.time.LocalDate;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class UserMission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean isCompleted;
    private LocalDate completedAt;
    private Integer remittanceNum;
    private LocalDate createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "mission_id")
    private Mission mission;
}

