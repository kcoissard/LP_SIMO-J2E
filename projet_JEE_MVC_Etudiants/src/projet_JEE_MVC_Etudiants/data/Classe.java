package projet_JEE_MVC_Etudiants.data;

import java.util.ArrayList;
import java.io.Serializable;
import javax.persistence.*;
import java.util.*;

@Entity
public class Classe implements Serializable {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column
	private String libelle;
	
	@OneToMany(mappedBy="classe", fetch=FetchType.LAZY)
	List<Etudiant> etudiants;
	
	private static final long serialVersionUID = 1L;
	
	public Classe() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public List getEtudiants() {
		return etudiants;
	}

	public void inscriptionEtudiants(ArrayList<Etudiant> etudiants) {
		for(Etudiant etudiant : etudiants){
			etudiant.setClasse(this);
		}
	}
}
