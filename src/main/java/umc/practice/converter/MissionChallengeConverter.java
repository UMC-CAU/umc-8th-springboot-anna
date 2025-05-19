package umc.practice.converter;

import org.springframework.stereotype.Component;
import umc.practice.domain.Member;
import umc.practice.domain.Mission;
import umc.practice.domain.enums.MissionStatus;
import umc.practice.domain.mapping.MemberMission;
import umc.practice.web.dto.MissionChallengeRequestDTO;
import umc.practice.web.dto.MissionChallengeResponseDTO;

// 8th mission
@Component
public class MissionChallengeConverter {
    public MemberMission toMemberMission(MissionChallengeRequestDTO.CreateChallengeDTO dto, Member member, Mission mission) {
        return MemberMission.builder()
                .member(member)
                .mission(mission)
                .status(MissionStatus.CHALLENGING)
                .build();
    }

    public MissionChallengeResponseDTO.DetailChallengeDTO toChallengeDto(MemberMission memberMission){
        return new MissionChallengeResponseDTO.DetailChallengeDTO(
                memberMission.getId(),
                memberMission.getMember().getId(),
                memberMission.getMission().getId(),
                memberMission.getStatus(),
                memberMission.getCreatedAt()
        );
    }
}
