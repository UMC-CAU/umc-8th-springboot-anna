package umc.practice.converter;

import org.springframework.stereotype.Component;
import umc.practice.domain.Member;
import umc.practice.domain.Region;
import umc.practice.domain.Review;
import umc.practice.domain.Store;
import umc.practice.web.dto.ReviewRequestDTO;
import umc.practice.web.dto.ReviewResponseDTO;
import umc.practice.web.dto.StoreRequestDTO;
import umc.practice.web.dto.StoreResponseDTO;

// 8th mission
@Component
public class ReviewConverter {
    public Review toReview(ReviewRequestDTO.CreateDTO dto, Store store, Member member) {
        return Review.builder()
                .store(store)
                .member(member)
                .score(dto.getScore())
                .body(dto.getBody())
                .build();
    }

    public ReviewResponseDTO.DetailDTO toDto(Review review) {
        return new ReviewResponseDTO.DetailDTO(
                review.getId(),
                review.getStore().getId(),
                review.getMember().getId(),
                review.getScore(),
                review.getBody()
        );
    }
}
