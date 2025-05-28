package umc.practice.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.practice.service.ReviewService.ReviewCommandService;
import umc.practice.service.ReviewService.ReviewQueryService;
import umc.practice.validation.annotation.ExistStore;
import umc.practice.web.dto.PageRequestDTO;
import umc.practice.web.dto.ReviewRequestDTO;
import umc.practice.web.dto.ReviewResponseDTO;


// 8th mission
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/stores/{storeId}/reviews")
public class ReviewController {

    private final ReviewCommandService reviewCommandService;
    private final ReviewQueryService reviewQueryService;
    @PostMapping
    public ResponseEntity<ReviewResponseDTO.DetailDTO> createReview(
            @PathVariable @ExistStore Long storeId,
            @RequestBody @Valid ReviewRequestDTO.CreateDTO request) {

        ReviewResponseDTO.DetailDTO response = reviewCommandService.create(storeId, request);
        return ResponseEntity.ok(response);
    }

    // 9th misison
    @GetMapping("/members/{memberId}")
    @Operation(summary = "사용자가 작성한 리뷰 조회")
    public ResponseEntity<ReviewResponseDTO.ReviewPreViewListDTO> getUserReviews(
            @PathVariable Long memberId,
            @Valid @ModelAttribute PageRequestDTO pageRequestDTO) {

        int pageIndex = pageRequestDTO.getPage() - 1;
        ReviewResponseDTO.ReviewPreViewListDTO response = reviewQueryService.getMyReviews(memberId, pageIndex);
        return ResponseEntity.ok(response);
    }

}
