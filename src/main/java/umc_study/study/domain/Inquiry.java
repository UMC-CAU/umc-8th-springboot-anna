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
public class Inquiry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String subject;
    private String inquiryType;
    private String contents;
    private String image;
    private LocalDate createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "inquiry", cascade = CascadeType.ALL)
    private List<InquiryReply> replies;
}
