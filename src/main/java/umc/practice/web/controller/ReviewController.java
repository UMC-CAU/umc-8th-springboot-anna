package umc.practice.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.practice.apiPayLoad.ApiResponse;
import umc.practice.service.ReviewCommandService;
import umc.practice.service.StoreService.StoreQueryService;
import umc.practice.validation.annotation.ExistStore;
import umc.practice.web.dto.ReviewRequestDTO;
import umc.practice.web.dto.ReviewResponseDTO;

// 8th mission
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/stores/{storeId}/reviews")
public class ReviewController {

    private final ReviewCommandService reviewCommandService;

    @PostMapping
    public ResponseEntity<ReviewResponseDTO.DetailDTO> createReview(
            @PathVariable @ExistStore Long storeId,
            @RequestBody @Valid ReviewRequestDTO.CreateDTO request) {

        ReviewResponseDTO.DetailDTO response = reviewCommandService.create(storeId, request);
        return ResponseEntity.ok(response);
    }
}
