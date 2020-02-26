/**
 * 
 */
package br.com.phsg.framework.challenge.web.dto;

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
public class LoginDTO {
	
	private String email;
	private String password;

}
