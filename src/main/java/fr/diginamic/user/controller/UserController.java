package fr.diginamic.user.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonProperty;

import fr.diginamic.configuration.JWTFilter;
import fr.diginamic.configuration.TokenProvider;
import fr.diginamic.user.dto.RecupLogin;
import fr.diginamic.user.model.User;
import fr.diginamic.user.model.UserDTO;
import fr.diginamic.user.service.MapperUserService;
import fr.diginamic.user.service.UserService;

@CrossOrigin
@RestController()
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userServ;

	@GetMapping
	public List<UserDTO> findAll() {
		return this.userServ.findAll();
	}

	@PostMapping
	@Transactional
	public UserDTO verification(@RequestBody UserDTO userDTO) {
		return userServ.save(userDTO);

	}
	
	@PatchMapping
    public UserDTO update( @RequestBody UserDTO user) {
        return this.userServ.save(user);
    }
	
	@PostMapping("/delete")
	public void delete( @RequestBody UserDTO user) {
         this.userServ.delete(user);
    }
}
