package umc.practice.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.practice.apiPayLoad.code.status.ErrorStatus;
import umc.practice.apiPayLoad.exception.handler.MemberHandler;
import umc.practice.apiPayLoad.exception.handler.ReviewHandler;
import umc.practice.apiPayLoad.exception.handler.StoreHandler;
import umc.practice.converter.ReviewConverter;
import umc.practice.domain.Member;
import umc.practice.domain.Review;
import umc.practice.domain.Store;
import umc.practice.repository.MemberRepository;
import umc.practice.repository.ReviewRepository;
import umc.practice.repository.StoreRepository.StoreRepository;
import umc.practice.web.dto.ReviewRequestDTO;
import umc.practice.web.dto.ReviewResponseDTO;

// 8th mission
@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService {

    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;
    private final ReviewConverter reviewConverter;

    @Override
    public ReviewResponseDTO.DetailDTO create(Long storeId, ReviewRequestDTO.CreateDTO dto) {

        // storeId는 @ExistStore로 이미 검증됨
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));

        Member member = memberRepository.findById(dto.getMember_id())
                .orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));

        if (dto.getBody() == null || dto.getBody().trim().isEmpty()) {
            throw new ReviewHandler(ErrorStatus.REVIEW_BODY);
        }

        Review review = reviewConverter.toReview(dto, store, member);
        Review saved = reviewRepository.save(review);

        return reviewConverter.toDto(saved);
    }
}
