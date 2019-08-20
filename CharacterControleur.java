package com.ifi_gp.controleurs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ifi_gp.entitees.AnnimeCaractere;
import com.ifi_gp.repositories.IAnimeCaractere;



@RestController
@RequestMapping("/v1/animes")
public class CharacterControleur {
	@Autowired
	private IAnimeCaractere charactereRepositiry;
	@GetMapping("/")
	public ResponseEntity findAll() {
		return ResponseEntity.ok(charactereRepositiry.findAll());
	}
	//Mecthode pour prendre un caractère par id anime caractère
	public ResponseEntity findAnimeBydId(@PathVariable(name = "idAnime") Long idCharacter) {
		if(idCharacter == null) {
			return ResponseEntity.badRequest().body("Impossible de trouver un caractère d'animation avec ce ID");
			
		}
		AnnimeCaractere character = charactereRepositiry.getOne(idCharacter);
		if (character==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(character);
	}
	// Methode pour créer un charactère 
	@PostMapping("/")
	public ResponseEntity createCaracter(@RequestBody AnnimeCaractere character) {
		if(character == null) {
			return ResponseEntity.badRequest().body("impossible de créer un charactère avec un identifiant null");
		}
		return ResponseEntity.ok(charactereRepositiry.save(character));
	}
	
	// supprimer un character par son ID
	@DeleteMapping("/{idCharacter}")
	public ResponseEntity deleteCharacter(@PathVariable(name = "idCharacter") Long idCharacter) {
		if (idCharacter == null) {
			return ResponseEntity.badRequest().body("Impossible de supprimer un caractère avec un identifiant inconnu");
			
		}
		AnnimeCaractere character = charactereRepositiry.getOne(idCharacter);
		if (character == null) {
			return ResponseEntity.notFound().build();
		}
		charactereRepositiry.delete(character);
		return ResponseEntity.ok("Le caractère à été supprimé avec succé");
		}
	// paratger un character
	@GetMapping("/share/idCharacter/(partage)")
	public ResponseEntity shareCharacter(@PathVariable(name = "idCharacter") Long idCharacter, @PathVariable(name = "partage") boolean partage) {
		if (idCharacter==null) {
			return ResponseEntity.badRequest().body("Impossible de partager un Character avec un ID inconnu");
		}
		AnnimeCaractere character = charactereRepositiry.getOne(idCharacter);
		if(character==null) {
			return ResponseEntity.notFound().build();
		}
		character.setPartage(partage);
		return ResponseEntity.ok(charactereRepositiry.save(character));
	}
}
  