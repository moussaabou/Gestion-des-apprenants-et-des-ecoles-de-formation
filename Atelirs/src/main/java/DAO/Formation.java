package DAO;

import java.sql.Date;

public class Formation extends personne {
	private String niveau;
	private String NomFormation;
	private int idFormation;
	private String prix;
	private String DateFin;
	private String DateDebut;
	public String getDateDebut() {
		return DateDebut;
	}
	public void setDateDebut (String dateDebut) {
		DateDebut = dateDebut;
	}
	public String getNomFormation() {
		return NomFormation;
	}
	public void setNomFormation(String nomFormation) {
		NomFormation = nomFormation;
	}
	public String getDateFin() {
		return DateFin;
	}
	public void setDateFin(String dateFin) {
		DateFin = dateFin;
	}
	
	
	private Date DateDateDebut;
	public String getNiveau() {
		return niveau;
	}
	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}
	public int getIdFormation() {
		return idFormation;
	}
	public void setIdFormation(int idFormation) {
		this.idFormation = idFormation;
	}
	public String getPrix() {
		return prix;
	}
	public void setPrix(String prix) {
		this.prix = prix;
	}
	
}
