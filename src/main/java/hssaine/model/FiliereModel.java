package ma.ensam.spring.model;

import ma.ensam.spring.entities.Filiere;
import java.util.ArrayList;
import java.util.List;

public class FiliereModel {

    private List<Filiere> filieres = new ArrayList<>();
    private Filiere filiere = new Filiere();

    private String message;

    // Getters & Setters
    public List<Filiere> getFilieres() { return filieres; }
    public void setFilieres(List<Filiere> filieres) { this.filieres = filieres; }

    public Filiere getFiliere() { return filiere; }
    public void setFiliere(Filiere filiere) { this.filiere = filiere; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}
