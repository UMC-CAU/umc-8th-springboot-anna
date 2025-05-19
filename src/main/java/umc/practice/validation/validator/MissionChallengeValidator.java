package umc.practice.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.practice.domain.enums.MissionStatus;
import umc.practice.repository.MemberMissionRepository;
import umc.practice.repository.MissionRepository;
import umc.practice.validation.annotation.IsMissionChallenging;
import umc.practice.web.dto.MissionChallengeRequestDTO;

// 8th mission
@Component
@RequiredArgsConstructor
public class MissionChallengeValidator implements ConstraintValidator<IsMissionChallenging, MissionChallengeRequestDTO.CreateChallengeDTO> {

    private final MemberMissionRepository memberMissionRepository;

    @Override
    public boolean isValid(MissionChallengeRequestDTO.CreateChallengeDTO dto, ConstraintValidatorContext context) {
        if (dto.getMemberId() == null || dto.getMissionId() == null) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("memberId와 missionId는 null일 수 없습니다.")
                    .addConstraintViolation();
            return false;
        }

        boolean notChallenging = memberMissionRepository.findByMemberIdAndMissionIdAndStatus(
                dto.getMemberId(), dto.getMissionId(), MissionStatus.CHALLENGING
        ).isEmpty();

        if (!notChallenging) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("이미 해당 미션을 도전 중입니다.")
                    .addPropertyNode("missionId")  // 오류 위치 표시
                    .addConstraintViolation();
        }

        return notChallenging;
    }
}
