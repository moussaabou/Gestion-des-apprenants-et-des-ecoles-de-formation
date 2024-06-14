package Metier;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DAO.Administrateur;
import DAO.Etablissement;
import DAO.Formation;
import DAO.Offre_de_emploi;
import DAO.personne;

public class EspaceEtablissement {
	private static ConnexionBase con;
	private static Connection Connect = null;
	public EspaceEtablissement() {
		con = new ConnexionBase();
	Connect = con.getConnection();
	}
	public boolean authentify(Etablissement x) {
		String query = "SELECT * FROM atelier.etablissement WHERE Email = ? and Pass = ?";
		PreparedStatement st = null;
		ResultSet r = null;
		boolean b=false;
		try {
			st = this.Connect.prepareStatement(query);
			st.setString(1, x.getEmail());
			st.setString(2, x.getPass());

			r = st.executeQuery();
			if (r.next())
				b = true;
			st.close();
			r.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}
	public boolean addUser(Etablissement x) {
		String query = "insert into atelier.etablissement(nom, Prenom , Email , Pass ,diplomes ,Niveaux ,filieres ,ville ,region) values (?, ?,? ,? ,?, ?,? ,? ,?)";
		PreparedStatement st = null;
		int r = 0;
		boolean b= false;
		try {
			if(!authentify(x)) {
			st = this.Connect.prepareStatement(query);
			st.setString(1, x.getNom());
			st.setString(2, x.getPrenom());
			st.setString(3, x.getEmail());
			st.setString(4, x.getPass());
			st.setString(5, x.getDiplomes());
			st.setString(6, x.getNiveau());
			st.setString(7, x.getFilieres());
			st.setString(8, x.getVille());
			st.setString(9, x.getRegion());
			r = st.executeUpdate();
			st.close();
			b=true;
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return b;
	}
	public boolean addEmploie(Offre_de_emploi x , Etablissement e) {
		String query = "insert into atelier.offre_de_emploi(Nom_emploi, Niveaux, abbr ,idEtablissement) VALUES (? ,? , ?, ?)";
		PreparedStatement st = null;
		int r = 0;
		boolean b= false;
		try {
			
			st = this.Connect.prepareStatement(query);
			st = this.Connect.prepareStatement(query);
			st.setString(1, x.getNom_emploi());
			st.setString(2, x.getNiveau());
			st.setString(3, x.getAbbr());
			st.setLong(4, e.getIdEtablissement());
	         r = st.executeUpdate();
				st.close();
			b=true;
		
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			return b;}
	 public boolean suppFormation (int c) {
	    	{
	        	String query = "DELETE FROM `atelier`.`formation` WHERE (idFormation = '"+c+"' )";
	        	PreparedStatement st = null;
	    		int r = 0;
	    		boolean b= false;
	    		try {
	    			st = this.Connect.prepareStatement(query);
	    			r = st.executeUpdate();
	    			st.close();
	    			b=true;
	    		}
	    		catch (SQLException e) {
	    	// TODO Auto-generated catch block
	    	e.printStackTrace();
	    }
	    		return b;
	        }
	    }
	public boolean addFormation(Formation x , String a) {
		String query = "insert into atelier.formation(NomFormatio, date_debut , date_fin,niveaux,Prix ,idFormateur ,idEtablissement ) values (?, ?,? ,? ,? , ? , ?)";
		PreparedStatement st = null;
		int r = 0;
		boolean b= false;
		try {
			
			st = this.Connect.prepareStatement(query);
			st.setString(1, x.getNomFormation());
			st.setString(4, x.getNiveau());
			st.setString(5, x.getPrix());
			st.setString(2, x.getDateDebut());
			st.setString(3, x.getDateFin());
			st.setLong(6, x.getIdFormation());
			st.setString(7, a);
			r = st.executeUpdate();
			st.close();
			b=true;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return b;}

    
    public ArrayList<String> formationEtablissement(Etablissement x){
    	String query = "SELECT * FROM atelier.etablissement WHERE Email ='"+x.getEmail()+"'  AND pass ='"+x.getPass()+"'";
		ArrayList<String> cars = new ArrayList<String>() ;
		PreparedStatement st = null;
		ResultSet r = null;
		try {
			st = this.Connect.prepareStatement(query);
			r = st.executeQuery();
			while (r.next()) {
				for (int i=1 ; i<16 ; i++) {
					 cars.add( r.getString(i));
			} }
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
		return cars;
    	
    	
    }
    public boolean ModifEtab(Etablissement x) {
    	PreparedStatement st = null;
		ResultSet r = null;
		boolean b = false;
		if(authentify(x)) {
			String query = "UPDATE `atelier`.`etablissement` SET `Nom` = '"+x.getNom()+"', `prenom` = '"+x.getPrenom()+"', `Email` = '"+x.getEmail()+"', `pass` = '"+x.getPass()+"', `ville` = '"+x.getVille()+"', `filieres` = '"+x.getFilieres()+"', `region` = '"+x.getRegion()+"', `Niveaux` = '"+x.getNiveau()+"' WHERE (`idEtablissement` = '"+x.getId()+"')";
		try {
			st = this.Connect.prepareStatement(query);
			st.executeUpdate();
			if(authentify(x))
				 b=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} }
		return b;
    }
    public boolean Addform (Formation x) {
    	String query = "INSERT INTO `atelier`.`formation` (`NomFormatio`, `date_debut`, `date_fin`, `niveaux`, `Prix`, `idFormateur`) VALUES (? ,? , ?, ? , ? ,?)";
		PreparedStatement st = null;
		int r = 0;
		boolean b= false;
		try {
			
			st = this.Connect.prepareStatement(query);
			st = this.Connect.prepareStatement(query);
			st.setString(1, x.getNomFormation());
			st.setString(2, x.getDateDebut());
			st.setString(3, x.getDateFin());
			st.setString(4, x.getNiveau());
			st.setString(5, x.getPrix());
	         r = st.executeUpdate();
				st.close();
			b=true;
		
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			return b;
    	
    }
    public ArrayList<String> option(String x , String c){
		ArrayList<String> arry = new ArrayList<String>() ;
		PreparedStatement st = null;
		ResultSet r = null;
		String query = "SELECT * FROM atelier.formation WHERE (`idEtablissement` = '"+c+"')";
		try {
		st = this.Connect.prepareStatement(query);
		 r= st.executeQuery();
		 while ( r.next()){
			 arry.add( r.getString(x));
		 } }
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return arry;
	}
    public boolean ModifEtabForm(Formation x) {
    	PreparedStatement st = null;
		ResultSet r = null;
		boolean b = false;
		
			String query = "UPDATE `atelier`.`formation` SET `NomFormatio` = '"+x.getNomFormation()+"', `date_debut` = '"+x.getDateDebut()+"', `date_fin` = '"+x.getDateFin()+"', `niveaux` = '"+x.getNiveau()+"', `Prix` = '"+x.getPass()+"', `idFormateur` = '"+x.getIdFormation()+"' WHERE (`idFormation` = '"+x.getId()+"')";
		try {
			st = this.Connect.prepareStatement(query);
			st.executeUpdate();
			
				 b=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return b;
    }

}
