package DAO;

public class Offre_de_emploi {
	private String Nom_emploi;
	private int idOffre_de_emploi; 
	private String niveau;
	private String Abbr;
	public Offre_de_emploi () {}
	public void setAbbr(String abbr) {
		Abbr = abbr;
	}
	public int getIdOffre_de_emploi() {
		return idOffre_de_emploi;
	}
	public void setIdOffre_de_emploi(int idOffre_de_emploi) {
		this.idOffre_de_emploi = idOffre_de_emploi;
	}
	public String getNiveau() {
		return niveau;
	}
	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}
	public String getNom_emploi() {
		return Nom_emploi;
	}
	public void setNom_emploi(String nom_emploi) {
		Nom_emploi = nom_emploi;
	}
	public String getAbbr() {
		// TODO Auto-generated method stub
		return Abbr;
	}

}
