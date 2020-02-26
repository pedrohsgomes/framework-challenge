/**
 * 
 */
package br.com.phsg.framework.challenge.web.dto;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author pedro.gomes - 2020/02/26
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistroDTO {
	
	private String email;
	private String nome;
	private String password;
	private Set<String> role;

}
