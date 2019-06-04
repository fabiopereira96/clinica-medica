package br.com.clinica;

import javax.swing.JFrame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

import br.com.clinica.controllers.SelecaoAgendaConsultaController;
import br.com.clinica.controllers.SelecaoAgendaExameController;
import br.com.clinica.entity.AgendaEquipamento;
import br.com.clinica.entity.AgendaMedica;

@SuppressWarnings({ "rawtypes" })
public class SelecaoTipoAgendaWindow {

	private JFrame frame;

	private static SelecaoWindow selecaoAgendaExameWindow
		= new SelecaoWindow<AgendaMedica, SelecaoAgendaExameController>(
			new SelecaoAgendaExameController()
		  );
	private static SelecaoWindow selecaoAgendaConsultaWindow
		= new SelecaoWindow<AgendaEquipamento, SelecaoAgendaConsultaController>(
			new SelecaoAgendaConsultaController()
		);

	public SelecaoTipoAgendaWindow() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 272, 174);
		frame.getContentPane().setLayout(null);

		/* Botões */
		JButton btnAgendaMedica = new JButton("Agenda de consultas");
		btnAgendaMedica.setBounds(12, 12, 232, 42);
		btnAgendaMedica.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				try {
					selecaoAgendaConsultaWindow.showFrame();
				} catch (Exception f) {
					System.exit(0);
				}
			}
		});
		frame.getContentPane().add(btnAgendaMedica);

		JButton btnAgendaEquip = new JButton("Agenda de exames");
		btnAgendaEquip.setBounds(12, 62, 232, 42);
		btnAgendaEquip.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				try {
					selecaoAgendaExameWindow.showFrame();
				} catch (Exception f) {
					System.exit(0);
				}
			}
		});
		frame.getContentPane().add(btnAgendaEquip);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(12, 112, 98, 25);
		btnVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnVoltar);
	}

	public void setVisible(boolean t) {
		frame.setVisible(t);
	}
}
