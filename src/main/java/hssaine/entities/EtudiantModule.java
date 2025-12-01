package ma.ensam.spring.entities;

import javax.persistence.*;

@Entity
@Table(name = "etudiant_modules")
public class EtudiantModule {

    @EmbeddedId
    private EtudiantModuleKey id;

    @ManyToOne
    @MapsId("etudiantId")
    @JoinColumn(name = "etudiant_id")
    private Etudiant etudiant;

    @ManyToOne
    @MapsId("moduleId")
    @JoinColumn(name = "module_id")
    private Module module;

    @Column(nullable = false)
    private double note;

    // Getters & Setters
    public EtudiantModuleKey getId() { return id; }
    public void setId(EtudiantModuleKey id) { this.id = id; }

    public Etudiant getEtudiant() { return etudiant; }
    public void setEtudiant(Etudiant etudiant) { this.etudiant = etudiant; }

    public Module getModule() { return module; }
    public void setModule(Module module) { this.module = module; }

    public double getNote() { return note; }
    public void setNote(double note) { this.note = note; }
}
