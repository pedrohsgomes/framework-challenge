/**
 * 
 */
package br.com.phsg.framework.challenge.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.phsg.framework.challenge.model.entity.Comentario;
import br.com.phsg.framework.challenge.model.entity.Post;
import br.com.phsg.framework.challenge.model.repository.PostRepository;

/**
 * @author pedro.gomes - 2020/02/21
 * 
 */
@RestController
@RequestMapping("posts")
@CrossOrigin
public class PostController {

	@Autowired
	private PostRepository postRepository;
	 
    @GetMapping("/")
    public List<Post> getPosts() {
        return postRepository.findAll();
    }
    
    @DeleteMapping("/{postId}")
    public List<Post> excluirPost(Post post, Model model) {
//    	Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//    	if (principal instanceof UserDetails) {
//    	  String username = ((UserDetails)principal).getUsername();
//    	} else {
//    	  String username = principal.toString();
//    	}
    	
        return postRepository.findAll();
    }
    
    @PostMapping("/")
    public List<Post> postar(Post post, Model model) {
        return postRepository.findAll();
    }
    
    @PostMapping("/{postId}/comentar")
    public List<Post> comentar(@PathVariable Long postId, Comentario commentario, Model model) {
        return postRepository.findAll();
    }
}
