package umc.practice.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import umc.practice.domain.Mission;
import umc.practice.repository.MissionRepository;
import umc.practice.web.dto.MissionResponseDTO;

import java.util.List;

// 9th mission
@Service
@RequiredArgsConstructor
public class MissionQueryService {

    private final MissionRepository missionRepository;

    public MissionResponseDTO.MissionListDTO getMissionsByStore(Long storeId, int page) {
        Pageable pageable = PageRequest.of(page, 10);
        Page<Mission> missionPage = missionRepository.findByStoreId(storeId, pageable);

        List<MissionResponseDTO.MissionPreviewDTO> missionList = missionPage.getContent().stream()
                .map(m -> MissionResponseDTO.MissionPreviewDTO.builder()
                        .missionSpc(m.getMissionSpec())
                        .reward(m.getReward())
                        .deadline(m.getDeadline())
                        .createdAt(m.getCreatedAt())
                        .build())
                .toList();

        return MissionResponseDTO.MissionListDTO.builder()
                .missionList(missionList)
                .listSize(missionList.size())
                .totalPage(missionPage.getTotalPages())
                .totalElements(missionPage.getTotalElements())
                .isFirst(missionPage.isFirst())
                .isLast(missionPage.isLast())
                .build();
    }
}


