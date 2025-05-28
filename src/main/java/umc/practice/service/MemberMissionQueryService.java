package umc.practice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import umc.practice.domain.Mission;
import umc.practice.domain.enums.MissionStatus;
import umc.practice.domain.mapping.MemberMission;
import umc.practice.repository.MemberMissionRepository;
import umc.practice.web.dto.MissionResponseDTO;

import java.util.List;

// 9th mission
@Service
@RequiredArgsConstructor
public class MemberMissionQueryService {

    private final MemberMissionRepository memberMissionRepository;

    public MissionResponseDTO.MissionListDTO getChallengingMissions(Long memberId, int page) {
        Pageable pageable = PageRequest.of(page, 10);

        Page<MemberMission> missionPage = memberMissionRepository.findByMemberIdAndStatus(
                memberId, MissionStatus.CHALLENGING, pageable);

        List<MissionResponseDTO.MissionPreviewDTO> missionList = missionPage.getContent().stream()
                .map(mm -> {
                    Mission mission = mm.getMission(); // 연관된 Mission 엔티티
                    return MissionResponseDTO.MissionPreviewDTO.builder()
                            .missionSpc(mission.getMissionSpec())
                            .reward(mission.getReward())
                            .deadline(mission.getDeadline())
                            .createdAt(mission.getCreatedAt())
                            .build();
                })
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
