package umc.practice.service.StoreService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.practice.apiPayLoad.code.status.ErrorStatus;
import umc.practice.apiPayLoad.exception.handler.RegionHandler;
import umc.practice.converter.StoreConverter;
import umc.practice.domain.Region;
import umc.practice.domain.Store;
import umc.practice.repository.RegionRepository;
import umc.practice.repository.StoreRepository.StoreRepository;
import umc.practice.web.dto.StoreRequestDTO;
import umc.practice.web.dto.StoreResponseDTO;

// 8th mission
@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService {

    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;
    private final StoreConverter storeConverter;

    @Override
    @Transactional
    public StoreResponseDTO.DetailStoreDTO create(Long regionId, StoreRequestDTO.CreateStoreDTO dto) {
        // 1. 지역 존재 여부 확인
        Region region = regionRepository.findById(regionId)
                .orElseThrow(() -> new RegionHandler(ErrorStatus.REGION_NOT_FOUND));

        // 2. DTO → Store Entity 변환
        Store store = storeConverter.toStore(dto, region);

        // 3. 저장
        Store saved = storeRepository.save(store);

        // 4. Store → 응답 DTO 변환 후 반환
        return storeConverter.toDto(saved);
    }
}
