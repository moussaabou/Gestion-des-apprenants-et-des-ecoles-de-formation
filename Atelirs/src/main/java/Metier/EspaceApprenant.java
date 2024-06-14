package Metier;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DAO.Apprenant;
import DAO.personne;

public class EspaceApprenant {
	private static ConnexionBase con;
	private static Connection Connect = null;
	public EspaceApprenant() {
		con = new ConnexionBase();
	Connect = con.getConnection();
	}
	public boolean authentify( personne x) {
		String query = "SELECT * FROM atelier.apprenant WHERE Email = ? and Pass = ?";
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
	public boolean addUser(personne x) {
		String query = "insert into atelier.apprenant(nom, Prenom , Email , Pass) values (?, ?,? ,?)";
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
			r = st.executeUpdate();
			st.close();
			if(authentify(x)) {
			b=true;}
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return b;
	}
	public ArrayList<String> option(String x){
		ArrayList<String> arry = new ArrayList<String>() ;
		PreparedStatement st = null;
		ResultSet r = null;
		String query = "SELECT * FROM atelier.formation";
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
	public ArrayList<String> optionEtab(String x){
		ArrayList<String> arry = new ArrayList<String>() ;
		PreparedStatement st = null;
		ResultSet r = null;
		String query = "SELECT * FROM atelier.etablissement";
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
	public ArrayList<String> optionEtabVR(String x , String r , String v){
		ArrayList<String> arry = new ArrayList<String>() ;
		PreparedStatement st = null;
		ResultSet r1 = null;
		String query = "SELECT * FROM atelier.etablissement  where Niveaux = '"+v+"' And region = '"+r+"' ";
		try {
		st = this.Connect.prepareStatement(query);
		 r1= st.executeQuery();
		 while ( r1.next()){
			 arry.add( r1.getString(x));
		 } }
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return arry;
	}
	public ArrayList<String> optionEtabR(String x , String r ){
		ArrayList<String> arry = new ArrayList<String>() ;
		PreparedStatement st = null;
		ResultSet r1 = null;
		String query = "SELECT * FROM atelier.etablissement  where region = '"+r+"' ";
		try {
		st = this.Connect.prepareStatement(query);
		 r1= st.executeQuery();
		 while ( r1.next()){
			 arry.add( r1.getString(x));
		 } }
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return arry;
	}
	public ArrayList<String> optionEtabV(String x , String v){
		ArrayList<String> arry = new ArrayList<String>() ;
		PreparedStatement st = null;
		ResultSet r1 = null;
		String query = "SELECT * FROM atelier.etablissement  where Niveaux = '"+v+"'";
		try {
		st = this.Connect.prepareStatement(query);
		 r1= st.executeQuery();
		 while ( r1.next()){
			 arry.add( r1.getString(x));
		 } }
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return arry;
	}
	public ArrayList<String> optionEtabD(String x , String D){
		ArrayList<String> arry = new ArrayList<String>() ;
		PreparedStatement st = null;
		ResultSet r1 = null;
		String query = "SELECT * FROM atelier.etablissement  where diplomes = '"+D+"'";
		try {
		st = this.Connect.prepareStatement(query);
		 r1= st.executeQuery();
		 while ( r1.next()){
			 arry.add( r1.getString(x));
		 } }
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return arry;
	}
	public ArrayList<String> optionemploi(String x){
		ArrayList<String> arry = new ArrayList<String>() ;
		PreparedStatement st = null;
		ResultSet r = null;
		String query = "SELECT * FROM atelier.offre_de_emploi";
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
}
