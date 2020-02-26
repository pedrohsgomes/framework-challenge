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
import javax.persistence.Lob;
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
@ToString(exclude = {"comentarios", "imagens"})
public class Post implements Serializable {

	private static final long serialVersionUID = -3705402430085536070L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	private String titulo;
	private String subTitulo;
	private String descricao;
	@Lob
	private String texto;
	private LocalDateTime criacao = LocalDateTime.now();
	
	@ManyToOne
	@JoinColumn
	private Usuario criador;
	
	@OneToMany(orphanRemoval = true)
	@Cascade(CascadeType.ALL)
	@JoinColumn
	private List<Comentario> comentarios;
	
	@OneToMany(orphanRemoval = true, mappedBy = "post")
	@Cascade(CascadeType.ALL)
	private List<Imagem> imagens;
	
	@Lob
	private String links;
}
