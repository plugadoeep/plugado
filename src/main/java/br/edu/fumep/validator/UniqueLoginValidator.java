package br.edu.fumep.validator;

import br.edu.fumep.constraint.UniqueLogin;
import br.edu.fumep.repository.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by arabasso on 23/04/2017.
 *
 */
public class UniqueLoginValidator implements ConstraintValidator<UniqueLogin, String> {
    @Autowired
    private UsuarioRepositorio userRepository;

    public void initialize(UniqueLogin constraint) {
    }

    public boolean isValid(String login, ConstraintValidatorContext context) {
        return login != null && !userRepository.findByLogin(login).isPresent();
    }

}
