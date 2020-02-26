/**
 * 
 */
package br.com.phsg.framework.challenge.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
public class Imagem implements Serializable {

	private static final long serialVersionUID = -5528258972887142592L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@Lob
	private byte[] imagem;
	
	@ManyToOne(optional = true)
	@JoinColumn
	private Post post;
	
	@ManyToOne(optional = true)
	@JoinColumn
	private Album album;
}
