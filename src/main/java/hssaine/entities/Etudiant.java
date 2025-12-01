package ma.ensam.spring.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "etudiants")
public class Etudiant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 80)
	private String nom;

	@Column(nullable = false, length = 80)
	private String prenom;

	@ManyToOne
	@JoinColumn(name = "filiere_id")
	private Filiere filiere;

	@OneToMany(mappedBy = "etudiant")
	private List<EtudiantModule> etudiantModules;

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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Filiere getFiliere() {
		return filiere;
	}

	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}

	public List<EtudiantModule> getEtudiantModules() {
		return etudiantModules;
	}

	public void setEtudiantModules(List<EtudiantModule> etudiantModules) {
		this.etudiantModules = etudiantModules;
	}
}
