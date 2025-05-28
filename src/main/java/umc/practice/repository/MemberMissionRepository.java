package umc.practice.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.practice.domain.enums.MissionStatus;
import umc.practice.domain.mapping.MemberMission;

import java.util.Optional;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
    Optional<MemberMission> findByMemberIdAndMissionIdAndStatus(Long memberId, Long missionId, MissionStatus status);

    // 9th mission
    Page<MemberMission> findByMemberIdAndStatus(Long memberId, MissionStatus missionStatus, Pageable pageable);
}
