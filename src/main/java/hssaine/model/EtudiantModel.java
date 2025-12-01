package ma.ensam.spring.model;

import ma.ensam.spring.entities.Etudiant;
import ma.ensam.spring.entities.Filiere;
import java.util.ArrayList;
import java.util.List;

public class EtudiantModel {

	private List<Etudiant> etudiants = new ArrayList<>();
	private List<Filiere> filieres = new ArrayList<>();
	private Etudiant etudiant = new Etudiant();

	private String message;

	// Getters & Setters
	public List<Etudiant> getEtudiants() {
		return etudiants;
	}

	public void setEtudiants(List<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}

	public List<Filiere> getFilieres() {
		return filieres;
	}

	public void setFilieres(List<Filiere> filieres) {
		this.filieres = filieres;
	}

	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
