package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import controller.InquilinoController;
import controller.LocalidadController;
import controller.ViviendaController;
import model.Inquilino;
import model.Localidad;
import model.Vivienda;
import utils.CacheImagenes;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import java.util.Date;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class PrincipalView extends JFrame {

	private JPanel contentPane;
	private JTextField jtfId;
	private JTextField jtfDni;
	private JTextField jtfNombre;
	private JTextField jtfFechaIni;
	private JTextField jtfFechaFin;
	private JTextField jtfCuota;
	private JComboBox<Vivienda> jcbVivienda;
	private JComboBox<Localidad> jcbLocalidad;
	private JLabel jlbTotal;
	private JCheckBox alquiler;
	private SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
	
	private CacheImagenes cacheImagenes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalView frame = new PrincipalView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PrincipalView() {
		
		cacheImagenes = new CacheImagenes();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 683, 574);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
//		gbl_contentPane.columnWeights = new double[]{0.0, 1.0};
//		gbl_contentPane.columnWeights = new double[]{0.0, 1.0};
//		gbl_contentPane.columnWidths = new int[]{0, 0};
//		gbl_contentPane.rowHeights = new int[]{0, 0};
//		gbl_contentPane.columnWeights = new double[]{0.0, Double.MIN_VALUE};
//		gbl_contentPane.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Modificación de alquileres");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Localidad: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jcbLocalidad = new JComboBox<Localidad>();
		jcbLocalidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				llenarJcbVivienda();
			}
		});
		jcbLocalidad.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_jcbLocalidad = new GridBagConstraints();
		gbc_jcbLocalidad.weightx = 1.0;
		gbc_jcbLocalidad.insets = new Insets(0, 0, 5, 0);
		gbc_jcbLocalidad.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbLocalidad.gridx = 1;
		gbc_jcbLocalidad.gridy = 1;
		contentPane.add(jcbLocalidad, gbc_jcbLocalidad);
		
		JLabel lblNewLabel_1_1 = new JLabel("Vivienda: ");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1.gridx = 0;
		gbc_lblNewLabel_1_1.gridy = 2;
		contentPane.add(lblNewLabel_1_1, gbc_lblNewLabel_1_1);
		
		jcbVivienda = new JComboBox<Vivienda>();
		jcbVivienda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarInquilinos();
			}
		});
		jcbVivienda.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_jcbVivienda = new GridBagConstraints();
		gbc_jcbVivienda.insets = new Insets(0, 0, 5, 0);
		gbc_jcbVivienda.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbVivienda.gridx = 1;
		gbc_jcbVivienda.gridy = 2;
		contentPane.add(jcbVivienda, gbc_jcbVivienda);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Datos del inquilino");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		GridBagConstraints gbc_lblNewLabel_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1_1_1.gridwidth = 2;
		gbc_lblNewLabel_1_1_1.gridx = 0;
		gbc_lblNewLabel_1_1_1.gridy = 3;
		contentPane.add(lblNewLabel_1_1_1, gbc_lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Id: ");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_1_1_2 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_2.gridx = 0;
		gbc_lblNewLabel_1_1_2.gridy = 4;
		contentPane.add(lblNewLabel_1_1_2, gbc_lblNewLabel_1_1_2);
		
		jtfId = new JTextField();
		jtfId.setEditable(false);
		jtfId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.insets = new Insets(0, 0, 5, 0);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 4;
		contentPane.add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("DNI: ");
		lblNewLabel_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_1_1_2_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_2_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1_2_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_2_1.gridx = 0;
		gbc_lblNewLabel_1_1_2_1.gridy = 5;
		contentPane.add(lblNewLabel_1_1_2_1, gbc_lblNewLabel_1_1_2_1);
		
		jtfDni = new JTextField();
		jtfDni.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jtfDni.setColumns(10);
		GridBagConstraints gbc_jtfDni = new GridBagConstraints();
		gbc_jtfDni.insets = new Insets(0, 0, 5, 0);
		gbc_jtfDni.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDni.gridx = 1;
		gbc_jtfDni.gridy = 5;
		contentPane.add(jtfDni, gbc_jtfDni);
		
		JLabel lblNewLabel_1_1_2_1_1 = new JLabel("Nombre completo: ");
		lblNewLabel_1_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_1_1_2_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_2_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1_2_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_2_1_1.gridx = 0;
		gbc_lblNewLabel_1_1_2_1_1.gridy = 6;
		contentPane.add(lblNewLabel_1_1_2_1_1, gbc_lblNewLabel_1_1_2_1_1);
		
		jtfNombre = new JTextField();
		jtfNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jtfNombre.setColumns(10);
		GridBagConstraints gbc_jtfNombre = new GridBagConstraints();
		gbc_jtfNombre.insets = new Insets(0, 0, 5, 0);
		gbc_jtfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNombre.gridx = 1;
		gbc_jtfNombre.gridy = 6;
		contentPane.add(jtfNombre, gbc_jtfNombre);
		
		JLabel lblNewLabel_1_1_2_1_1_1 = new JLabel("Fecha inicio: ");
		lblNewLabel_1_1_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_1_1_2_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_2_1_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1_2_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_2_1_1_1.gridx = 0;
		gbc_lblNewLabel_1_1_2_1_1_1.gridy = 7;
		contentPane.add(lblNewLabel_1_1_2_1_1_1, gbc_lblNewLabel_1_1_2_1_1_1);
		
		jtfFechaIni = new JTextField();
		jtfFechaIni.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jtfFechaIni.setColumns(10);
		GridBagConstraints gbc_jtfFechaIni = new GridBagConstraints();
		gbc_jtfFechaIni.insets = new Insets(0, 0, 5, 0);
		gbc_jtfFechaIni.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfFechaIni.gridx = 1;
		gbc_jtfFechaIni.gridy = 7;
		contentPane.add(jtfFechaIni, gbc_jtfFechaIni);
		
		alquiler = new JCheckBox("");
		alquiler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(alquiler.isSelected()) {
					jtfFechaFin.setEditable(false);
					jtfFechaFin.setText("");
				}
				else {
					jtfFechaFin.setEditable(true);
				}
					
			}
		});
		GridBagConstraints gbc_chckbxNewCheckBox = new GridBagConstraints();
		gbc_chckbxNewCheckBox.anchor = GridBagConstraints.EAST;
		gbc_chckbxNewCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox.gridx = 0;
		gbc_chckbxNewCheckBox.gridy = 8;
		contentPane.add(alquiler, gbc_chckbxNewCheckBox);
		
		JLabel lblNewLabel_2 = new JLabel("Alquiler en activo");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 8;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JLabel lblNewLabel_1_1_2_1_1_1_1 = new JLabel("Fecha de fin: ");
		lblNewLabel_1_1_2_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_1_1_2_1_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_2_1_1_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1_2_1_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_2_1_1_1_1.gridx = 0;
		gbc_lblNewLabel_1_1_2_1_1_1_1.gridy = 9;
		contentPane.add(lblNewLabel_1_1_2_1_1_1_1, gbc_lblNewLabel_1_1_2_1_1_1_1);
		
		jtfFechaFin = new JTextField();
		jtfFechaFin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jtfFechaFin.setColumns(10);
		GridBagConstraints gbc_jtfFechaFin = new GridBagConstraints();
		gbc_jtfFechaFin.insets = new Insets(0, 0, 5, 0);
		gbc_jtfFechaFin.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfFechaFin.gridx = 1;
		gbc_jtfFechaFin.gridy = 9;
		contentPane.add(jtfFechaFin, gbc_jtfFechaFin);
		
		JLabel lblNewLabel_1_1_2_1_1_1_1_1 = new JLabel("Cuota mensual (€): ");
		lblNewLabel_1_1_2_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_1_1_2_1_1_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_2_1_1_1_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1_2_1_1_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_2_1_1_1_1_1.gridx = 0;
		gbc_lblNewLabel_1_1_2_1_1_1_1_1.gridy = 10;
		contentPane.add(lblNewLabel_1_1_2_1_1_1_1_1, gbc_lblNewLabel_1_1_2_1_1_1_1_1);
		
		jtfCuota = new JTextField();
		 jtfCuota.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				actualizarJlabel();
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				actualizarJlabel();
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				actualizarJlabel();
			}
		});

		jtfCuota.setFont(new Font("Tahoma", Font.PLAIN, 16));
		jtfCuota.setColumns(10);
		GridBagConstraints gbc_jtfCuota = new GridBagConstraints();
		gbc_jtfCuota.insets = new Insets(0, 0, 5, 0);
		gbc_jtfCuota.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfCuota.gridx = 1;
		gbc_jtfCuota.gridy = 10;
		contentPane.add(jtfCuota, gbc_jtfCuota);
		
		JLabel lblNewLabel_1_1_2_1_1_1_1_1_1 = new JLabel("Total mensual (IVA incluido) (€): ");
		lblNewLabel_1_1_2_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_1_1_2_1_1_1_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_2_1_1_1_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_2_1_1_1_1_1_1.gridx = 0;
		gbc_lblNewLabel_1_1_2_1_1_1_1_1_1.gridy = 11;
		contentPane.add(lblNewLabel_1_1_2_1_1_1_1_1_1, gbc_lblNewLabel_1_1_2_1_1_1_1_1_1);
		
		jlbTotal = new JLabel("New label");
		jlbTotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_jlbTotal = new GridBagConstraints();
		gbc_jlbTotal.insets = new Insets(0, 0, 5, 0);
		gbc_jlbTotal.gridx = 1;
		gbc_jlbTotal.gridy = 11;
		contentPane.add(jlbTotal, gbc_jlbTotal);
		
		JButton jbtModificar = new JButton("Modificar");
		jbtModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				save();
			}
		});
		jbtModificar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_jbtModificar = new GridBagConstraints();
		gbc_jbtModificar.insets = new Insets(10, 0, 10, 0);
		gbc_jbtModificar.gridwidth = 2;
		gbc_jbtModificar.gridx = 0;
		gbc_jbtModificar.gridy = 12;
		contentPane.add(jbtModificar, gbc_jbtModificar);
		jbtModificar.setIcon(cacheImagenes.getIcono("guardar.png"));
		
		llenarJcbLocalidad();
		alquiler.setSelected(true);
		jtfFechaFin.setEditable(false);
	}
	
	private void llenarJcbLocalidad() {
		List<Localidad> ld = LocalidadController.findAll();
		for (Localidad localidad : ld) {
			jcbLocalidad.addItem(localidad);
		}
	}
	
	private void llenarJcbVivienda() {
		jcbVivienda.removeAllItems();
		Localidad l = (Localidad)jcbLocalidad.getSelectedItem();
		if(l != null) {
			List<Vivienda> lv = ViviendaController.findAllByIdLocalidad(l.getId());
			for (Vivienda vivienda : lv) {
				jcbVivienda.addItem(vivienda);
			}
		}
	}
	
	private void mostrarInquilinos() {
		Vivienda v = (Vivienda)jcbVivienda.getSelectedItem();
		if(v != null) {
			Inquilino i = InquilinoController.inquilinoPorVivienda(v.getId());
			jtfId.setText(""+i.getId());
			jtfDni.setText(i.getDni());
			jtfNombre.setText(i.getNombreCompleto());
			jtfFechaIni.setText(fecha.format(i.getFechaIni()));
			if(i.getFechaFin() != null)
				jtfFechaFin.setText(fecha.format(i.getFechaFin()));
			else
				jtfFechaFin.setText("");
			jtfCuota.setText(""+i.getCuotaMensual());
			jlbTotal.setText(""+(i.getCuotaMensual() * 1.21));
			String cadenaEnBlanco = "";
			if(jtfFechaFin.getText().equals(cadenaEnBlanco)) { 
				alquiler.setSelected(true);
				jtfFechaFin.setEditable(false);
			}
			else {
				alquiler.setSelected(false);
				jtfFechaFin.setEditable(true);
			}
		}
	}
	
	
	private void save() {
		
		Inquilino i = new Inquilino();
		
		if(!esDni(jtfDni.getText())) {
			JOptionPane.showMessageDialog(null, "El DNI introducido no es correcto.");
			return;
		}
		
		if(jtfNombre.getText().trim().isBlank()) {
			JOptionPane.showMessageDialog(null, "El nombre no se puede quedar vacío. ");
			return;
		}
		
		Date fechaIni = null;
		try {
			fechaIni = fecha.parse(jtfFechaIni.getText());
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "La fecha introducida no esta en formato correcto.");
			return;
		}
		if(fechaIni != null) {
			java.sql.Date fechaIniSql = new java.sql.Date(fechaIni.getTime());
			i.setFechaIni(fechaIniSql);
		}
		
		
		if(!jtfFechaFin.getText().equals("")) {
			Date fechaFin = null;
			try {
				fechaFin = fecha.parse(jtfFechaFin.getText());
			} catch (ParseException e) {
				JOptionPane.showMessageDialog(null, "La fecha introducida no esta en formato correcto. ");
				return;
			}
			if(fechaFin != null) {
				java.sql.Date fechaFinSql = new java.sql.Date(fechaFin.getTime());
				i.setFechaFin(fechaFinSql);
			}
		}
		else {
			i.setFechaFin(null);
		}
		
		i.setDni(jtfDni.getText());
		i.setNombreCompleto(jtfNombre.getText());
		i.setCuotaMensual(Float.parseFloat(jtfCuota.getText()));
		i.setId(Integer.parseInt(jtfId.getText()));
		
		InquilinoController.save(i);
		
	}
	
	private boolean esDni(String dni) {
		if (dni.length() != 9) {
	        return false;
	    }
	    if (!dni.matches("[0-9]{8}[A-Z]{1}")) {
	        return false;
	    }
	    return true;
	}
	
	private void actualizarJlabel() {
		if(!jtfCuota.getText().equals("")) {
			jlbTotal.setText(""+(Float.parseFloat(jtfCuota.getText()) * 1.21));
		}
		else
			jlbTotal.setText("0");
	}
	

}
