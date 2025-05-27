package umc.practice.converter;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import umc.practice.domain.Region;
import umc.practice.domain.Review;
import umc.practice.domain.Store;
import umc.practice.web.dto.ReviewResponseDTO;
import umc.practice.web.dto.StoreRequestDTO;
import umc.practice.web.dto.StoreResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

// 8th mission
@Component
public class StoreConverter {

    public Store toStore(StoreRequestDTO.CreateStoreDTO dto, Region region) {
        return Store.builder()
                .name(dto.getName())
                .address(dto.getAddress())
                .region(region)
                .score(0.0f)
                .build();
    }

    public StoreResponseDTO.DetailStoreDTO toDto(Store store) {
        return new StoreResponseDTO.DetailStoreDTO(
                store.getId(),
                store.getName(),
                store.getAddress(),
                store.getRegion().getId()
        );
    }

    // 9th 실습
    public static ReviewResponseDTO.ReviewPreViewDTO reviewPreViewDTO(Review review){
        return ReviewResponseDTO.ReviewPreViewDTO.builder()
                .ownerNickname(review.getMember().getName()) // review에 @ManyToOne으로 지정해둔 Member을 통해 데이터 편하게 갖고옴
                .score(review.getScore())
                .createdAt(review.getCreatedAt().toLocalDate())
                .body(review.getBody())
                .build();    }
    public static ReviewResponseDTO.ReviewPreViewListDTO reviewPreViewListDTO(Page<Review> reviewList){
        List<ReviewResponseDTO.ReviewPreViewDTO> reviewPreViewDTOList = reviewList.stream()
                .map(StoreConverter::reviewPreViewDTO).collect(Collectors.toList());

        return ReviewResponseDTO.ReviewPreViewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }
}