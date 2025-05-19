package umc.practice.converter;

import org.springframework.stereotype.Component;
import umc.practice.domain.Mission;
import umc.practice.domain.Store;
import umc.practice.web.dto.MissionRequestDTO;
import umc.practice.web.dto.MissionResponseDTO;

// 8th mission
@Component
public class MissionConverter {
    public Mission toMission(MissionRequestDTO.CreateDTO dto, Store store){
        return Mission.builder()
                .store(store)
                .reward(dto.getReward())
                .missionSpec(dto.getMissionSpec())
                .deadline(dto.getDeadline())
                .build();
    }

    public MissionResponseDTO.DetailDTO toDto(Mission mission){
        return new MissionResponseDTO.DetailDTO(
                mission.getId(),
                mission.getStore().getId(),
                mission.getReward(),
                mission.getMissionSpec(),
                mission.getDeadline(),
                mission.getCreatedAt()
        );
    }
}
