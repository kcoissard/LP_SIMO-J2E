package projet_JEE_MVC_Etudiants.data;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Etudiant implements Serializable {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column
	private String prenom;
	
	@Column
	private String nom;
	
	@Column(nullable = false)
	private Integer nbAbsences;
	
	@Column
	private float moyenne;
	
	@ManyToOne
	private Licence licence;
	
	private static final long serialVersionUID = 1L;
	
	public Etudiant() {
		super();
	}
	
	public Etudiant(Integer id, String prenom, String nom, Integer nbAbsences, Licence licence) {
		super();
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
		this.nbAbsences = nbAbsences;
		this.licence = licence;
		
		//moyenne générée aléatoirement à l'initialisation de l'étudiant
		float higher = 20;
		float lower = 0;
		float choix = (float)(java.lang.Math.random()*(higher-lower))+lower;
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
	
	public Licence getLicence() {
		return licence;
	}

	public void setLicence(Licence licence) {
		this.licence = licence;
	}
	
	public Integer getNbAbsences() {
		return nbAbsences;
	}
	
	public void setNbAbsences(Integer nouveauNbAbsences) {
		if(nouveauNbAbsences >= 0){
			this.nbAbsences = nouveauNbAbsences;
		}
	}
	
	public void ajouterAbsence(){
		this.setNbAbsences(this.getNbAbsences()+1);
	}
	
	public void supprimerAbsence(){
		if(this.getNbAbsences()>0){
			this.setNbAbsences(this.getNbAbsences()-1);
		}
	}
	
	public float getMoyenne(){
		return moyenne;
	}

	public void setMoyenne(float moyenne) {
		this.moyenne = moyenne;
	}
}
