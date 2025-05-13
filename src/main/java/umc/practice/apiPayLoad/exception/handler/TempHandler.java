package umc.practice.apiPayLoad.exception.handler;

import umc.practice.apiPayLoad.code.BaseErrorCode;
import umc.practice.apiPayLoad.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
