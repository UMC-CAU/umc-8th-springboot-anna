package umc_study.study.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import umc_study.study.domain.common.BaseEntity;
import jakarta.persistence.*;
import umc_study.study.domain.enums.Gender;
import umc_study.study.domain.mapping.UserMission;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Gender gender;
    private LocalDate birthDate;
    private String address;

    private LocalDate inactiveDate;

    @OneToMany(mappedBy = "user")
    private List<Review> reviews;

    @OneToMany(mappedBy = "user")
    private List<UserMission> userMissions;

    @OneToMany(mappedBy = "user")
    private List<Inquiry> inquiries;
}
