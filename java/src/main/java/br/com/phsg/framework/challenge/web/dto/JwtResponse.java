/**
 * 
 */
package br.com.phsg.framework.challenge.web.dto;

import java.util.List;

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
public class JwtResponse {

	private String token;
	private Long id;
	private String username;
	private String email;
	private List<String> roles;
}
