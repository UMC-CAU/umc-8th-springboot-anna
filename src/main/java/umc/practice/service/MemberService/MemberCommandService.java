package umc.practice.service.MemberService;

import umc.practice.domain.Member;
import umc.practice.web.dto.MemberRequestDTO;

public interface MemberCommandService {
    Member joinMember(MemberRequestDTO.JoinDto request);
}
