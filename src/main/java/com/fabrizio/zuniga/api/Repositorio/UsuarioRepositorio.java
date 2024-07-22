package com.fabrizio.zuniga.api.Repositorio;
import org.springframework.data.jpa.repository.JpaRepository;
import com.fabrizio.zuniga.api.Entidad.Usuario;

public interface UsuarioRepositorio extends JpaRepository <Usuario, Long>{

}
