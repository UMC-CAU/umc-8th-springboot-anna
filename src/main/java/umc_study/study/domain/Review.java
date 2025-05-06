package umc_study.study.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String contents;
    private String image;
    private Float starRate;
    private LocalDate createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @OneToMany(mappedBy = "review", cascade = CascadeType.ALL)
    private List<ReviewReply> replies;
}

