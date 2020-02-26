/**
 * 
 */
package br.com.phsg.framework.challenge.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.phsg.framework.challenge.model.entity.Role;
import br.com.phsg.framework.challenge.model.entity.enumerator.RoleEnum;

/**
 * @author pedro.gomes - 2020/02/26
 * 
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

	Optional<Role> findByNome(RoleEnum nome);
}
