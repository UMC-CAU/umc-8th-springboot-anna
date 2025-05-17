package umc.practice.apiPayLoad.exception.handler;

import umc.practice.apiPayLoad.code.BaseErrorCode;
import umc.practice.apiPayLoad.exception.GeneralException;

public class StoreHandler extends GeneralException {
    public StoreHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }

}
