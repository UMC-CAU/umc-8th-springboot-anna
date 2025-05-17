package umc.practice.apiPayLoad.exception.handler;

import lombok.Getter;
import umc.practice.apiPayLoad.code.BaseErrorCode;
import umc.practice.apiPayLoad.exception.GeneralException;

@Getter
public class ReviewHandler extends GeneralException {
    public ReviewHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }

}
