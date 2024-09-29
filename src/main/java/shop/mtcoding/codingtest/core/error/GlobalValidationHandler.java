package shop.mtcoding.codingtest.core.error;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import shop.mtcoding.codingtest.core.error.ex.Exception400;

@Component
@Aspect // AOP 등록
public class GlobalValidationHandler {
    @Before("@annotation(org.springframework.web.bind.annotation.GetMapping) || @annotation(org.springframework.web.bind.annotation.PostMapping)")
    public void validCheck(JoinPoint jp) {
        Object[] args = jp.getArgs();
        for (Object arg : args) {
            if (arg instanceof Errors) {
                Errors errors = (Errors) arg;

                if (errors.hasErrors()) {
                    for (FieldError error : errors.getFieldErrors()) {
                        throw new Exception400(error.getDefaultMessage() + " : " + error.getField());
                    }
                }
            }
        }
    }
}
