/**
 * 
 */
package br.com.phsg.framework.challenge.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.phsg.framework.challenge.model.entity.Album;
import br.com.phsg.framework.challenge.model.repository.AlbumRepository;

/**
 * @author pedro.gomes - 2020/02/21
 * 
 */
@RestController
@RequestMapping("albums")
@CrossOrigin
public class AlbumController {
	
	@Autowired
	private AlbumRepository albumRepository;
	 
    @GetMapping("/")
    public List<Album> getUsers() {
        return albumRepository.findAll();
    }

}
