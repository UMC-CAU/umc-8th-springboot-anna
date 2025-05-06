package umc_study.study.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class InquiryReply {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String contents;
    private LocalDate createdAt;

    @ManyToOne
    @JoinColumn(name = "inquiry_id")
    private Inquiry inquiry;
}

