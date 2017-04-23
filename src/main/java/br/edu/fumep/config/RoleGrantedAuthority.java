package br.edu.fumep.config;

import br.edu.fumep.entity.Funcao;

/**
 * Created by arabasso on 22/08/15.
 */
public class RoleGrantedAuthority implements org.springframework.security.core.GrantedAuthority {
    private Funcao role;

    public RoleGrantedAuthority(Funcao role) {
        this.role = role;
    }

    @Override
    public String getAuthority() {
        return this.role.getNome();
    }
}
