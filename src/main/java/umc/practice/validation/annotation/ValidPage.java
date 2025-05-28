package umc.practice.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.practice.validation.validator.PageValidator;

import java.lang.annotation.*;

// 9th mission
@Documented
@Constraint(validatedBy = PageValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPage {
    String message() default "Page number must be greater than 0.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
