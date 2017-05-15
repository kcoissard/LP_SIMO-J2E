package projet_JEE_MVC_Etudiants.data;

import java.io.Serializable;
import javax.persistence.*;
import java.util.*;

@Entity
public class Licence implements Serializable {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column
	private String libelle;
	
	@OneToMany(mappedBy="licence", fetch=FetchType.LAZY)
	List<Etudiant> etudiants;
	
	private static final long serialVersionUID = 1L;
	
	public Licence() {
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

	public List<Etudiant> getEtudiants() {
		return etudiants;
	}
}
