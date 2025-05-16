package umc.practice.service.MemberService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.practice.apiPayLoad.code.status.ErrorStatus;
import umc.practice.apiPayLoad.exception.handler.FoodCategoryHandler;
import umc.practice.converter.MemberConverter;
import umc.practice.converter.MemberPreferConverter;
import umc.practice.domain.FoodCategory;
import umc.practice.domain.Member;
import umc.practice.domain.mapping.MemberPrefer;
import umc.practice.repository.FoodCategoryRepository;
import umc.practice.repository.MemberRepository;
import umc.practice.web.dto.MemberRequestDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService{

    private final MemberRepository memberRepository;

    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDto request) {

        Member newMember = MemberConverter.toMember(request);
        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(foodCategoryList);

        memberPreferList.forEach(memberPrefer -> {memberPrefer.setMember(newMember);});

        return memberRepository.save(newMember);
    }
}
