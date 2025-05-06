package umc_study.study.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import jakarta.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ReviewReply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String contents;

    @ManyToOne
    @JoinColumn(name = "review_id")
    private Review review;
}

