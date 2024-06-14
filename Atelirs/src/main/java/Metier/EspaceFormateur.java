package Metier;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DAO.Formateur;

public class EspaceFormateur {
	private static ConnexionBase con;
	private static Connection Connect = null;
	public EspaceFormateur() {
		con = new ConnexionBase();
	Connect = con.getConnection();
	}
	public boolean authentify(Formateur x) {
		String query = "SELECT * FROM atelier.formateur WHERE Email = ? and Pass = ?";
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
	public boolean addUser(Formateur x) {
		String query = "insert into atelier.formateur(nom, Prenom , Email , Pass) values (?, ?,? ,?)";
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
			b=true;
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return b;
	}
	
}
