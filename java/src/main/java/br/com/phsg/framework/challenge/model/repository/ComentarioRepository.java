/**
 * 
 */
package br.com.phsg.framework.challenge.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.phsg.framework.challenge.model.entity.Comentario;

/**
 * @author pedro.gomes - 2020/02/21
 * 
 */
@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long> {

}
