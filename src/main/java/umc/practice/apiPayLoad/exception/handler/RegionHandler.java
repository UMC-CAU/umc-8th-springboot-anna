package umc.practice.apiPayLoad.exception.handler;

import lombok.Getter;
import umc.practice.apiPayLoad.code.BaseErrorCode;
import umc.practice.apiPayLoad.exception.GeneralException;

// 8th mission
@Getter
public class RegionHandler extends GeneralException {

    public RegionHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}