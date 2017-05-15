package projet_JEE_MVC_Etudiants.data;

import java.io.Serializable;
import javax.persistence.*;

public class Etudiant implements Serializable {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column
	private String prenom;
	
	@Column
	private String nom;
	
	@Column
	private float moyenne;
	
	@ManyToOne
	private Classe classe;
	
	private static final long serialVersionUID = 1L;
	
	public Etudiant() {
		super();
	}
	
	public Etudiant(Integer id, String prenom, String nom, Classe classe) {
		super();
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
		this.classe = classe;
		
		float higher = 20;
		float lower = 0;
		float choix = (float)(java.lang.Math.random() * (higher-lower)) + lower;
		this.moyenne=choix;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}
	
	public float getMoyenne() {
		return moyenne;
	}

	public void setMoyenne(float moyenne) {
		this.moyenne = moyenne;
	}
}
