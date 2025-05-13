package umc.practice.apiPayLoad.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import umc.practice.apiPayLoad.code.BaseErrorCode;
import umc.practice.apiPayLoad.code.ErrorReasonDTO;

@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException {

    private BaseErrorCode code;

    public ErrorReasonDTO getErrorReason() {
        return this.code.getReason();
    }

    public ErrorReasonDTO getErrorReasonHttpStatus(){
        return this.code.getReasonHttpStatus();
    }
}
