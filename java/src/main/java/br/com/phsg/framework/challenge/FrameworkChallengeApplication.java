package br.com.phsg.framework.challenge;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ResourceUtils;

import br.com.phsg.framework.challenge.model.entity.Album;
import br.com.phsg.framework.challenge.model.entity.Comentario;
import br.com.phsg.framework.challenge.model.entity.Imagem;
import br.com.phsg.framework.challenge.model.entity.Post;
import br.com.phsg.framework.challenge.model.entity.Role;
import br.com.phsg.framework.challenge.model.entity.Usuario;
import br.com.phsg.framework.challenge.model.entity.enumerator.RoleEnum;
import br.com.phsg.framework.challenge.model.repository.AlbumRepository;
import br.com.phsg.framework.challenge.model.repository.PostRepository;
import br.com.phsg.framework.challenge.model.repository.RoleRepository;
import br.com.phsg.framework.challenge.model.repository.UsuarioRepository;

@SpringBootApplication
public class FrameworkChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(FrameworkChallengeApplication.class, args);
	}

	@Bean
	@Transactional
	CommandLineRunner init(PostRepository postRepository, UsuarioRepository usuarioRepository, AlbumRepository albumRepository, 
			RoleRepository roleRepository, PasswordEncoder encoder) {
		return args -> {
			Set<Role> roles = new HashSet<Role>();
			roles.add(new Role(null, RoleEnum.ROLE_ADMIN));
			roles.add(new Role(null, RoleEnum.ROLE_MODERATOR));
			roles.add(new Role(null, RoleEnum.ROLE_USER));
			roleRepository.saveAll(roles);
			
			Role role = roleRepository.findByNome(RoleEnum.ROLE_USER).get();
			roles.clear();
			roles.add(role);
			
			Stream.of("Pedro", "Root", "Geraldo", "Jamila", "Fulano", "Ciclano", "Deltrano").forEach(nome -> {
				Usuario usuario = new Usuario(null, nome, nome.toLowerCase() + "@frwk.com.br", encoder.encode("1234"),
						LocalDateTime.now(), roles);
				usuarioRepository.save(usuario);
			});
			usuarioRepository.findAll().forEach(System.out::println);
			
			Usuario usuario = usuarioRepository.findFirstByNome("Pedro");
			Usuario fulano = usuarioRepository.findFirstByNome("Fulano");
			Stream.of("Post 1", "Vida", "TI").forEach(titulo -> {				
				Post post = new Post();
				post.setTitulo(titulo);
				post.setSubTitulo("Sub");
				post.setTexto("Texto muito grande, heheh. /n/n/n/ Oi!/n/n/t/tTchau!");
				post.setLinks("http://www.google.com.br;http://frwk.com.br/");
				
				List<Comentario> comentarios = new ArrayList<Comentario>();
				comentarios.add(new Comentario(null, "Bora galera!!!", LocalDateTime.now(), usuario, post));
				comentarios.add(new Comentario(null, "Bacana!!!", LocalDateTime.now(), fulano, post));				
				post.setComentarios(comentarios);
				
				File asas = null;
				File mundo = null;
				try {
					asas = ResourceUtils.getFile("classpath:static/asas.jpg");
					mundo = ResourceUtils.getFile("classpath:static/mundo.jpg");
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				
				List<Imagem> imagens = new ArrayList<Imagem>();
				try {
					imagens.add(new Imagem(null, Files.readAllBytes(asas.toPath()),post, null));
					imagens.add(new Imagem(null, Files.readAllBytes(mundo.toPath()),post, null));
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				post.setImagens(imagens);
				
				post.setCriador(usuario);
				postRepository.save(post);
			});
			postRepository.findAll().forEach(System.out::println);
			
			Stream.of("Album 1").forEach(titulo -> {				
				Album album = new Album();
				album.setTitulo(titulo);
				
				File asas = null;
				File mundo = null;
				try {
					asas = ResourceUtils.getFile("classpath:static/asas.jpg");
					mundo = ResourceUtils.getFile("classpath:static/mundo.jpg");
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				
				List<Imagem> imagens = new ArrayList<Imagem>();
				try {
					imagens.add(new Imagem(null, Files.readAllBytes(asas.toPath()), null, album));
					imagens.add(new Imagem(null, Files.readAllBytes(mundo.toPath()), null, album));
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				album.setImagens(imagens);
				
				album.setCriador(usuario);
				albumRepository.save(album);
			});
			albumRepository.findAll().forEach(System.out::println);
		};
	}

}
