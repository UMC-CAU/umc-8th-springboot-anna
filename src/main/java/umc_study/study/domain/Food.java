package umc_study.study.domain;

import jakarta.persistence.*;
import lombok.*;
import umc_study.study.domain.enums.FoodType;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private FoodType foodType;
}

