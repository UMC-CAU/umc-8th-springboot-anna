package umc.practice.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.practice.validation.validator.StoreExistValidator;

import java.lang.annotation.*;

// 8th mission
@Documented
@Constraint(validatedBy = StoreExistValidator.class)
@Target( { ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistStore {
    String message() default "해당하는 음식점이 존재하지 않습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
