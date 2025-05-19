package umc.practice.converter;

import org.springframework.stereotype.Component;
import umc.practice.domain.Region;
import umc.practice.domain.Store;
import umc.practice.web.dto.StoreRequestDTO;
import umc.practice.web.dto.StoreResponseDTO;

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
}