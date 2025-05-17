package umc.practice.apiPayLoad.exception.handler;

import umc.practice.apiPayLoad.code.BaseErrorCode;
import umc.practice.apiPayLoad.exception.GeneralException;

public class MemberHandler extends GeneralException {
    public MemberHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }

}
