package br.com.phsg.framework.challenge.model.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author pedro.gomes - 2020/02/20
 * 
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 5481990822302994529L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private LocalDateTime criacao = LocalDateTime.now();
    
    @ManyToMany(fetch = FetchType.LAZY)
	@JoinTable
	private Set<Role> roles = new HashSet<>();

	public Usuario(String nome, String email, String senha) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}
}
