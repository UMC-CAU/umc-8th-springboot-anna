package umc.practice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.practice.apiPayLoad.code.status.ErrorStatus;
import umc.practice.apiPayLoad.exception.handler.MemberHandler;
import umc.practice.apiPayLoad.exception.handler.MissionHandler;
import umc.practice.converter.MissionChallengeConverter;
import umc.practice.domain.Member;
import umc.practice.domain.Mission;
import umc.practice.domain.mapping.MemberMission;
import umc.practice.repository.MemberMissionRepository;
import umc.practice.repository.MemberRepository;
import umc.practice.repository.MissionRepository;
import umc.practice.web.dto.MissionChallengeRequestDTO;
import umc.practice.web.dto.MissionChallengeResponseDTO;

// 8th mission
@Service
@RequiredArgsConstructor
public class ChallengeCommandServiceImpl implements ChallengeCommandService{
    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;
    private final MemberMissionRepository memberMissionRepository;
    private final MissionChallengeConverter missionChallengeConverter;

    @Override
    public MissionChallengeResponseDTO.DetailChallengeDTO create(Long missionId, MissionChallengeRequestDTO.CreateChallengeDTO dto){
        Member member = memberRepository.findById(dto.getMemberId())
                .orElseThrow(()->new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));
        Mission mission = missionRepository.findById(dto.getMissionId())
                .orElseThrow(()->new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));
        MemberMission memberMission = missionChallengeConverter.toMemberMission(dto, member, mission);
        MemberMission saved = memberMissionRepository.save(memberMission);

        return missionChallengeConverter.toChallengeDto(saved);
    }
}
