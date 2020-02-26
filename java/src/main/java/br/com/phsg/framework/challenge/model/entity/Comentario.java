/**
 * 
 */
package br.com.phsg.framework.challenge.model.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author pedro.gomes - 2020/02/21
 * 
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comentario implements Serializable {

	private static final long serialVersionUID = 3791376220526053779L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	private String texto;
	private LocalDateTime criacao = LocalDateTime.now();
	
	@ManyToOne
	@JoinColumn
	private Usuario criador;
	
	@ManyToOne
	@JoinColumn
	private Post post;

}
