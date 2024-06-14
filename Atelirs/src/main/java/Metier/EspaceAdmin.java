package Metier;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

import DAO.Administrateur;
import DAO.Apprenant;
import DAO.personne;

public class EspaceAdmin {
	private static ConnexionBase con;
	private static Connection Connect = null;
	public EspaceAdmin() {
		con = new ConnexionBase();
	Connect = con.getConnection();
	}
	public boolean authentify(Administrateur x) {
		String query = "SELECT * FROM atelier.admin WHERE Email ='"+x.getEmail()+"'  AND pass ='"+x.getPass()+"'";
		PreparedStatement st = null;
		ResultSet r = null;
		boolean b = false;
		try {
			st = this.Connect.prepareStatement(query);
			r = st.executeQuery();
			while (r.next())
				b=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}
	public int option(String x) {
		String query = "SELECT * FROM atelier."+x;
		PreparedStatement st = null;
		ResultSet r = null;
		int b = 0;
		try {
			st = this.Connect.prepareStatement(query);
			r = st.executeQuery();
			while (r.next())
				b++;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}
	public boolean modifer(Administrateur x) {
		PreparedStatement st = null;
		ResultSet r = null;
		boolean b = false;
		if(authentify(x)) {
			String query = "UPDATE `atelier`.`admin` SET `Nom` = '"+x.getNom()+"', `prenom` = '"+x.getPrenom()+"', `Email` = '"+x.getEmail()+"', `pass` = '"+x.getPass()+"', `N_Telephone` = '"+x.getN_Telephone()+"'  WHERE (`idAdmin` = '"+x.getIdAdmin()+"')";
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
    public ArrayList<String> formationadmin(Administrateur x){
    	String query = "SELECT * FROM atelier.admin WHERE Email ='"+x.getEmail()+"'  AND pass ='"+x.getPass()+"'";
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
    public void admin(Administrateur x ) {
    }
    public ArrayList<String> GereApp(String x , String a)
    {
    	ArrayList<String> arry = new ArrayList<String>() ;
    	String query = "SELECT * FROM atelier."+x+" WhERE Active='NO'";
		PreparedStatement st = null;
		ResultSet r = null;
		try {
			st = this.Connect.prepareStatement(query);
			 r= st.executeQuery();
			 while ( r.next()){
				 arry.add( r.getString(a));
			 } } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arry;
    }
    public boolean AjoutApp (personne c)
    {
    	String query = "UPDATE atelier.apprenant SET Active = 'yes' WHERE (idApprenant = '"+c.getId()+"' )";
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
    public boolean suppApp (personne c) {
    	{
        	String query = "DELETE FROM `atelier`.`apprenant` WHERE (idApprenant = '"+c.getId()+"' )";
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
    public boolean AjoutEtab (personne c)
    {
    	String query = "UPDATE atelier.etablissement SET Active = 'yes' WHERE (idEtablissement = '"+c.getId()+"' )";
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
    public boolean suppEtab (personne c) 
    	{
    	String query = "DELETE FROM `atelier`.`etablissement` WHERE (idEtablissement = '"+c.getId()+"' )";

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
        
    
    public boolean AjoutFrom (personne c)
    {
    	String query = "UPDATE atelier.formateur SET Active = 'yes' WHERE (idFormateur = '"+c.getId()+"' )";
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
    public boolean suppFrom (personne c) {
    	{
        	String query = "DELETE FROM `atelier`.`formateur` WHERE (idFormateur = '"+c.getId()+"' )";
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
    public int StatEtab() {
    	return 0;
    }
}
