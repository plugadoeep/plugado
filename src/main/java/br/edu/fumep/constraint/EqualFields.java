package br.edu.fumep.constraint;

import br.edu.fumep.validator.EqualFieldsValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by arabasso on 23/04/2017.
 *
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {EqualFieldsValidator.class})
public @interface EqualFields {

    String message() default "{com.dolszewski.blog.EqualFields.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String baseField();
    String matchField();
}
