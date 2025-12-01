package ma.ensam.spring.model;

import ma.ensam.spring.entities.Module;
import ma.ensam.spring.entities.Filiere;
import java.util.ArrayList;
import java.util.List;

public class ModuleModel {

	private List<Module> modules = new ArrayList<>();
	private List<Filiere> filieres = new ArrayList<>();
	private Module module = new Module();

	private String message;

	// Getters & Setters
	public List<Module> getModules() {
		return modules;
	}

	public void setModules(List<Module> modules) {
		this.modules = modules;
	}

	public List<Filiere> getFilieres() {
		return filieres;
	}

	public void setFilieres(List<Filiere> filieres) {
		this.filieres = filieres;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
