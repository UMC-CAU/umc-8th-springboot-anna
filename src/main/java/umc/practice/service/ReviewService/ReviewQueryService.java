package umc.practice.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import umc.practice.domain.Review;
import umc.practice.repository.ReviewRepository;
import umc.practice.web.dto.ReviewResponseDTO;
import java.util.List;

// 9th mission
@Service
@RequiredArgsConstructor
public class ReviewQueryService {

    private final ReviewRepository reviewRepository;

    public ReviewResponseDTO.ReviewPreViewListDTO getMyReviews(Long memberId, int page) {
        Pageable pageable = PageRequest.of(page, 10);
        Page<Review> reviewPage = reviewRepository.findByMemberId(memberId, pageable);

        List<ReviewResponseDTO.ReviewPreViewDTO> reviewList = reviewPage.getContent().stream()
                .map(review -> ReviewResponseDTO.ReviewPreViewDTO.builder()
                        .ownerNickname(review.getMember().getName()) // 본인이어도 닉네임 보여줄 수 있음
                        .score(review.getScore())
                        .body(review.getBody())
                        .createdAt(review.getCreatedAt().toLocalDate())
                        .build())
                .toList();

        return ReviewResponseDTO.ReviewPreViewListDTO.builder()
                .reviewList(reviewList)
                .listSize(reviewList.size())
                .totalPage(reviewPage.getTotalPages())
                .totalElements(reviewPage.getTotalElements())
                .isFirst(reviewPage.isFirst())
                .isLast(reviewPage.isLast())
                .build();
    }

}




