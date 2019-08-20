package com.ifi_gp.entitees;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Users implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long codeUser;
	
	private String nom;
	
	private String prenom;
	
	private String mail;
	
	private String password;
	
	@Lob
	private Byte[] photo;
	@OneToMany
	@JoinColumn(name = "idAnime")
	private List<AnnimeCaractere> caracteres;
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public Long getCodeUser() {
		return codeUser;
	}
	public void setCodeUser(Long codeUser) {
		this.codeUser = codeUser;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(Byte[] photo) {
		this.photo = photo;
	}
	public List<AnnimeCaractere> getCaracteres() {
		return caracteres;
	}
	public void setCaracteres(List<AnnimeCaractere> caracteres) {
		this.caracteres = caracteres;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
