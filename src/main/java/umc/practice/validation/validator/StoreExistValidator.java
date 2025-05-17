package umc.practice.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.practice.repository.StoreRepository.StoreRepository;
import umc.practice.validation.annotation.ExistCategories;
import umc.practice.validation.annotation.ExistStore;

// 8th mission
@Component
@RequiredArgsConstructor
public class StoreExistValidator implements ConstraintValidator<ExistStore, Long> {
    private final StoreRepository storeRepository;
    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        if (value == null) return false;
        return storeRepository.existsById(value);
    }
}
