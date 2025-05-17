package umc.practice.service;

import umc.practice.web.dto.ReviewRequestDTO;
import umc.practice.web.dto.ReviewResponseDTO;

// 8th mission
public interface ReviewCommandService {
    ReviewResponseDTO.DetailDTO create(Long storeId, ReviewRequestDTO.CreateDTO dto);

}
