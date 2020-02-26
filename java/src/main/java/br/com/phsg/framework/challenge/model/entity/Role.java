/**
 * 
 */
package br.com.phsg.framework.challenge.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.phsg.framework.challenge.model.entity.enumerator.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author pedro.gomes - 2020/02/26
 * 
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role implements Serializable {

	private static final long serialVersionUID = 901499928649634406L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private RoleEnum nome;
}
