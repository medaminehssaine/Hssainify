package ma.ensam.spring.entities;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "filieres")
public class Filiere {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 80)
	private String nom;

	@OneToMany(mappedBy = "filiere", cascade = CascadeType.ALL)
	private List<Module> modules;

	@OneToMany(mappedBy = "filiere", cascade = CascadeType.ALL)
	private List<Etudiant> etudiants;

	// Getters et Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Module> getModules() {
		return modules;
	}

	public void setModules(List<Module> modules) {
		this.modules = modules;
	}

	public List<Etudiant> getEtudiants() {
		return etudiants;
	}

	public void setEtudiants(List<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}
}
