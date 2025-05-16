package umc.practice.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.practice.service.StoreService.StoreCommandService;
import umc.practice.web.dto.StoreRequestDTO;
import umc.practice.web.dto.StoreResponseDTO;

// 8th mission
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/regions/{regionId}/stores")
public class StoreController {

    private final StoreCommandService storeCommandService;

    @PostMapping
    public ResponseEntity<StoreResponseDTO.DetailDTO> createStore(
            @PathVariable Long regionId,
            @RequestBody @Valid StoreRequestDTO.CreateDTO requestDto) {

        StoreResponseDTO.DetailDTO responseDto = storeCommandService.create(regionId, requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }
}

