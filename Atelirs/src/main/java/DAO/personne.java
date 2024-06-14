package DAO;
import lombok.Getter;
import lombok.Setter;

public class personne {
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private String Nom;
	private String prenom;
	private String Email;
	private String pass;
	private String passconf;
	private String N_Telephone;
	private boolean Active;
	private String notification;
	private String Ville;
	private String region;
	private String diplomes;
	private String filieres;
	private String niveau;
	private String type;

	
	public String getNiveau() {
		return niveau;
	}
	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}
	public String getNotification() {
		return notification;
	}
	public void setNotification(String notification) {
		this.notification = notification;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getDiplomes() {
		return diplomes;
	}
	public void setDiplomes(String diplomes) {
		this.diplomes = diplomes;
	}
	public String getFilieres() {
		return filieres;
	}
	public void setFilieres(String filieres) {
		this.filieres = filieres;
	}
	public String getVille() {
		return Ville;
	}
	public void setVille(String ville) {
		this.Ville = ville;
	}
	private String ville;
	public String getN_Telephone() {
		return N_Telephone;
	}
	public void setN_Telephone(String n_Telephone) {
		N_Telephone = n_Telephone;
	}
	public boolean isActive() {
		return Active;
	}
	public void setActive(boolean active) {
		Active = active;
	}
	public String getPassconf() {
		return passconf;
	}
	public void setPassconf(String passconf) {
		this.passconf = passconf;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public personne(){}
	

}
