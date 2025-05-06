package umc_study.study.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Float starRate;
    private Boolean openInfo;

    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;

    @ManyToOne
    @JoinColumn(name = "food_id")
    private Food food;
}

