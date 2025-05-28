package umc.practice.web.dto;

import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;
import umc.practice.validation.annotation.ValidPage;

// 9th mission
@Getter
@Setter
public class PageRequestDTO {

    @ValidPage
    @Parameter(description = "1 이상의 페이지 번호", example = "1", required = true)
    private Integer page;
}

