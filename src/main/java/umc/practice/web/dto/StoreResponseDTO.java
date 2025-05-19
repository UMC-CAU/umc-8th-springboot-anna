package umc.practice.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

// 8th mission
public class StoreResponseDTO {

    @Getter
    @AllArgsConstructor
    public static class DetailStoreDTO {
        private Long id;
        private String name;
        private String address;
        private Long regionId;
    }
}
