package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Vivienda;

public class ViviendaController {
	public static List<Vivienda> findAllByIdLocalidad(int id){
		List<Vivienda> ld = new ArrayList<Vivienda>();
		try {
			Connection conn = ConnectionManagerV1.getConexion();
			PreparedStatement ps = conn.prepareStatement("select * from vivienda where idLocalidad = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			Vivienda l = null;
			while(rs.next()) {
				l = new Vivienda(rs.getInt("id"), rs.getString("descripcion"), rs.getInt("idLocalidad"));
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
