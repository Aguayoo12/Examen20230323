package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.Inquilino;

public class InquilinoController {

	public static Inquilino inquilinoPorVivienda(int id) {
		try {
			Connection conn = ConnectionManagerV1.getConexion();
			PreparedStatement ps = conn.prepareStatement("select * from inquilino where idVivienda = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			Inquilino i = null;
			if(rs.next()) {
				i = new Inquilino();
				i.setId(rs.getInt("id"));
				i.setDni(rs.getString("dni"));
				i.setNombreCompleto(rs.getString("nombreCompleto"));
				i.setFechaIni(rs.getDate("fechaInicioAlquiler"));
				i.setFechaFin(rs.getDate("fechaFinAlquiler"));
				i.setCuotaMensual(rs.getFloat("cuotaMensual"));
			}
			return i;
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void save(Inquilino i) {
		try {
			Connection conn = ConnectionManagerV1.getConexion();
			PreparedStatement ps = conn.prepareStatement
					("update inquilino set dni = ?, nombreCompleto = ?, fechaInicioAlquiler = ?, fechaFinAlquiler = ?, cuotaMensual = ? where id = ?");
			ps.setString(1, i.getDni());
			ps.setString(2, i.getNombreCompleto());
			ps.setDate(3, i.getFechaIni());
			if(i.getFechaFin() != null)
				ps.setDate(4, i.getFechaFin());
			else
				ps.setDate(4, null);
			ps.setFloat(5, i.getCuotaMensual());
			ps.setInt(6, i.getId());
			
			ps.executeUpdate();
			ps.close();
			conn.close();
			JOptionPane.showMessageDialog(null, "Guardado correctamente");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
