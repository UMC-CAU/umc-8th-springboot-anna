package umc.practice.service.StoreService;
import umc.practice.web.dto.StoreRequestDTO;
import umc.practice.web.dto.StoreResponseDTO;

// 8th mission
public interface StoreCommandService {
    StoreResponseDTO.DetailDTO create(Long regionId, StoreRequestDTO.CreateDTO dto);
}