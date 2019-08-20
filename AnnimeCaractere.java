package com.ifi_gp.entitees;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class AnnimeCaractere implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private long idCharacter;
	private String characternom;
	private String categorie;
	private String puissance;
	private Byte[] characterPhoto;
	private Boolean partage;
	
	@ManyToOne
	@JoinColumn(name = "codeUser")
	private Users user;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	public long getIdCharacter() {
		return idCharacter;
	}


	public void setIdCharacter(long idCharacter) {
		this.idCharacter = idCharacter;
	}



	public String getCharacternom() {
		return characternom;
	}


	public void setCharacternom(String characternom) {
		this.characternom = characternom;
	}


	public String getCategorie() {
		return categorie;
	}


	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}


	public String getPuissance() {
		return puissance;
	}


	public void setPuissance(String puissance) {
		this.puissance = puissance;
	}


	public Byte[] getCharacterPhoto() {
		return characterPhoto;
	}


	public void setCharacterPhoto(Byte[] characterPhoto) {
		this.characterPhoto = characterPhoto;
	}


	public Boolean getPartage() {
		return partage;
	}

	public void setPartage(Boolean partage) {
		this.partage = partage;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
	

}
