/**
 * 
 */
package br.com.phsg.framework.challenge.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.phsg.framework.challenge.model.entity.Usuario;
import br.com.phsg.framework.challenge.model.repository.UsuarioRepository;

/**
 * @author pedro.gomes - 2020/02/26
 * 
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Transactional
	public UserDetails loadUserByEmail(String email) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado com e-mail: " + email));

		return UserDetailsImpl.build(usuario);
	}

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return loadUserByEmail(username);
	}

}
