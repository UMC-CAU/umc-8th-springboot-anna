package umc.practice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.practice.apiPayLoad.code.status.ErrorStatus;
import umc.practice.apiPayLoad.exception.handler.StoreHandler;
import umc.practice.converter.MissionConverter;
import umc.practice.domain.Mission;
import umc.practice.domain.Store;
import umc.practice.repository.MissionRepository;
import umc.practice.repository.StoreRepository.StoreRepository;
import umc.practice.web.dto.MissionRequestDTO;
import umc.practice.web.dto.MissionResponseDTO;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService{
    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;
    private final MissionConverter missionConverter;

    @Override
    public MissionResponseDTO.DetailDTO create(Long storeId, MissionRequestDTO.CreateMissionDTO dto){
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));

        Mission mission = missionConverter.toMission(dto, store);
        Mission saved = missionRepository.save(mission);

        return missionConverter.toDto(saved);

    }
}
