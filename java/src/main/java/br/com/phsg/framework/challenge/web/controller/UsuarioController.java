/**
 * 
 */
package br.com.phsg.framework.challenge.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.phsg.framework.challenge.model.entity.Usuario;
import br.com.phsg.framework.challenge.model.repository.UsuarioRepository;

/**
 * @author pedro.gomes - 2020/02/20
 * 
 */
@RestController
@RequestMapping("usuarios")
@CrossOrigin
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	 
    @GetMapping("/")
    public List<Usuario> getUsers() {
        return usuarioRepository.findAll();
    }
 
    @PostMapping("/")
    void addUser(@RequestBody Usuario user) {
    	usuarioRepository.save(user);
    }
}
