package umc.practice.web.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// 8th mission
public class StoreRequestDTO {
    @Getter
    @Setter
    @NoArgsConstructor

    public static class CreateStoreDTO{
        @NotBlank
        private String name;

        @NotBlank
        private String address;
    }
}
