package com.ifi_gp.controleurs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ifi_gp.entitees.Users;
import com.ifi_gp.repositories.IUser;
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/v1/users")
public class UserControleur {
	@Autowired
	private IUser userRepositiry;
	@GetMapping("/")
	public ResponseEntity findAll() {
		return ResponseEntity.ok(userRepositiry.findAll());
	}
	//Mecthode pour récuperer un utilisateur par Code user
	@GetMapping("/{codeUser}")
	public ResponseEntity findUserBysId(@PathVariable(name = "codeUser") Long codeUser) {
		if (codeUser == null) {
			return ResponseEntity.badRequest().body("on ne peut pas trouver un utilisateur avec un ID vide");
		}
		Users user = userRepositiry.getOne(codeUser);
		if (user == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(user);
	}
	// La méthode pour créer un utilisateur pour la prtie indentification
	@PostMapping("/")
	public ResponseEntity createUser(@RequestBody Users users) {
		if (users == null) {
		return ResponseEntity.badRequest().body("On ne peut pas cr&er un utilisateur avec tous les chmps vides");
		}
		Users createUser = userRepositiry.save(users);
		return ResponseEntity.ok(createUser);
	}
	// La méthode pour l'authentification d'un utilisateur
	@PostMapping("/login")  
	public ResponseEntity login(@RequestParam(name = "mail") String mail, @RequestParam(name = "password") String password) {
		  if (StringUtils.isEmpty(mail) || StringUtils.isEmpty(password)) {
			  return ResponseEntity.badRequest().body("vous ne pouvez pas vous connecter avec un mail ou mot de passe vide");
		  }
		  Users authenticatedUser = userRepositiry.findByMailAndPassword(mail, password);
		  if (authenticatedUser == null) {
			  return ResponseEntity.notFound().build();
		  }
		  return ResponseEntity.ok(authenticatedUser);
		  
	  }
}
  