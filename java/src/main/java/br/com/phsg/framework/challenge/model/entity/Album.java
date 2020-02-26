/**
 * 
 */
package br.com.phsg.framework.challenge.model.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import lombok.Data;
import lombok.ToString;

/**
 * @author pedro.gomes - 2020/02/21
 * 
 */
@Entity
@Data
@ToString(exclude = {"imagens"})
public class Album implements Serializable {

	private static final long serialVersionUID = -5541740126193154749L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	private String titulo;
	private LocalDateTime criacao;
	
	@OneToMany(orphanRemoval = true, mappedBy = "album")
	@Cascade(CascadeType.ALL)
	private List<Imagem> imagens;
	
	@ManyToOne
	@JoinColumn
	private Usuario criador;	
}
