package umc.practice.apiPayLoad.exception.handler;

// MemberCommandServiceImpl에서 자꾸 에러나서 임의로 생성자 추가
import umc.practice.apiPayLoad.code.BaseErrorCode;
import lombok.Getter;

@Getter
public class FoodCategoryHandler extends RuntimeException {

    private final BaseErrorCode errorCode;

    public FoodCategoryHandler(BaseErrorCode errorCode) {
        super(errorCode.getReason().getMessage()); // 예외 메시지 설정
        this.errorCode = errorCode;
    }
}

