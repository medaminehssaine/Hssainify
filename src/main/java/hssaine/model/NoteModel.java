package ma.ensam.spring.model;

import ma.ensam.spring.entities.Etudiant;
import ma.ensam.spring.entities.Module;
import ma.ensam.spring.entities.EtudiantModule;

import java.util.ArrayList;
import java.util.List;

public class NoteModel {

    private List<Etudiant> etudiants = new ArrayList<>();
    private List<Module> modules = new ArrayList<>();
    private List<EtudiantModule> notes = new ArrayList<>();

    private String message;

    public List<Etudiant> getEtudiants() {
        return etudiants;
    }

    public void setEtudiants(List<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }

    public List<Module> getModules() {
        return modules;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }

    public List<EtudiantModule> getNotes() {
        return notes;
    }

    public void setNotes(List<EtudiantModule> notes) {
        this.notes = notes;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
