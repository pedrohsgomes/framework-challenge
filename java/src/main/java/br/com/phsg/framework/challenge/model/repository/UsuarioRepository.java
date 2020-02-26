/**
 * 
 */
package br.com.phsg.framework.challenge.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.phsg.framework.challenge.model.entity.Usuario;

/**
 * @author pedro.gomes - 2020/02/20
 * 
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	@Query
	Usuario findFirstByNome(String nome);
	
	@Query
	Optional<Usuario> findByEmail(String nome);

	Boolean existsByEmail(String email);
}
