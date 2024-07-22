package com.fabrizio.zuniga.api.Controlador;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fabrizio.zuniga.api.Entidad.Usuario;
import com.fabrizio.zuniga.api.Repositorio.UsuarioRepositorio;

@RestController
@RequestMapping("/usuarios")
public class UsuarioControlador {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @GetMapping
    public List<Usuario> getAllUsuarios(){
        return usuarioRepositorio.findAll();
    }

    @GetMapping("/{id}")
    public Usuario getUsuarioId(@PathVariable Long id){
        return usuarioRepositorio.findById(id)
        .orElseThrow(()->new RuntimeException("No se encontro el ID" + id));
    }

    @PostMapping
    public String createUsario(@RequestBody Usuario usuario){
        usuarioRepositorio.save(usuario);
        return "Se creo Usuario correctamente";
    }

    @PutMapping("/{id}")
    public String updateUsuario(@PathVariable Long id,@RequestBody Usuario detalleusuario){
        Usuario usuario = usuarioRepositorio.findById(id)
        .orElseThrow(()->new RuntimeException("No se encontro el ID" + id));

        usuario.setNombre(detalleusuario.getNombre());
        usuario.setApellido(detalleusuario.getApellido());
        usuario.setCorreo(detalleusuario.getCorreo());
        usuario.setPassword(detalleusuario.getPassword());

        usuarioRepositorio.save(usuario);
        return "Se actualizo correctamente";
    }

    @DeleteMapping("/{id}")
    public String deleteUsuario(@PathVariable Long id){
        Usuario usuario = usuarioRepositorio.findById(id)
        .orElseThrow(()->new RuntimeException("No se encontro el ID" + id));

        usuarioRepositorio.delete(usuario);
        return "Se elminino usuario de ID:" + id;
    }

}
