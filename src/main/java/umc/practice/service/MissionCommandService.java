package umc.practice.service;

import jakarta.validation.Valid;
import umc.practice.web.dto.MissionRequestDTO;
import umc.practice.web.dto.MissionResponseDTO;

public interface MissionCommandService {
    MissionResponseDTO.DetailDTO create(Long storeId, MissionRequestDTO.@Valid CreateMissionDTO dto);

}
