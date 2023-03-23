package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Localidad;

public class LocalidadController {

	public static List<Localidad> findAll(){
		List<Localidad> ld = new ArrayList<Localidad>();
		try {
			Connection conn = ConnectionManagerV1.getConexion();
			PreparedStatement ps = conn.prepareStatement("select * from localidad");
			ResultSet rs = ps.executeQuery();
			Localidad l = null;
			while(rs.next()) {
				l = new Localidad(rs.getInt("id"), rs.getString("descripcion"));
				ld.add(l);
			}
			rs.close();
			ps.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ld;
	}
	
}
