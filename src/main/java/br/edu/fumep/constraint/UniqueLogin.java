package br.edu.fumep.constraint;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import br.edu.fumep.validator.UniqueLoginValidator;

/**
 * Created by arabasso on 23/04/2017.
 *
 */
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueLoginValidator.class)
public @interface UniqueLogin {
    String message() default "{com.dolszewski.blog.UniqueLogin.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
