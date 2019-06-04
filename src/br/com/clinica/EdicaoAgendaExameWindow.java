package br.com.clinica;

import java.util.Date;
import java.util.List;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import br.com.clinica.dao.AgendaEquipamentoDAO;
import br.com.clinica.dao.AgendaMedicaDAO;
import br.com.clinica.dao.ConvenioDAO;
import br.com.clinica.dao.MedicoDAO;
import br.com.clinica.dao.PacienteDAO;
import br.com.clinica.entity.AgendaEquipamento;
import br.com.clinica.entity.AgendaMedica;
import br.com.clinica.entity.Convenio;
import br.com.clinica.entity.DiaAtendimento;
import br.com.clinica.entity.Medico;
import br.com.clinica.entity.Paciente;
import com.toedter.calendar.JCalendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class EdicaoAgendaExameWindow {

	private JFrame frame;

	private AgendaEquipamento agenda;
	
	public EdicaoAgendaExameWindow(AgendaEquipamento agenda) {
		this.agenda = agenda;
		initialize();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {			
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 535, 420);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Atualização de agenda (exame)");
		
//		JScrollPane scrollPane_1 = new JScrollPane();
//		scrollPane_1.setBounds(12, 30, 249, 55);
//		convenioPanel.add(scrollPane_1);
//		
//		JList conveniosList = new JList();
//		scrollPane_1.setColumnHeaderView(conveniosList);
		
		List<Convenio> convenios = ConvenioDAO.getInstance().findAll();
				
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 184, 223, 155);
		frame.getContentPane().add(scrollPane);
		
		JList horariosList = new JList();
		scrollPane.setViewportView(horariosList);

		JCalendar calendar = new JCalendar();
		
		List<Medico> medicos = MedicoDAO.getInstance().findAll();
		
		JComboBox comboBoxMedicos = new JComboBox(medicos.toArray());
		comboBoxMedicos.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				boolean printHorarios = false;
				int selectedDiaId = Utils.getDayId(calendar.getDate().toString());
				int selectedMedicoCrm = Integer.parseInt(comboBoxMedicos.getSelectedItem().toString().split("-")[0].trim());
				Medico selectedMedico = MedicoDAO.getInstance().getById(selectedMedicoCrm);
				List<DiaAtendimento> diasAtendimentoList = selectedMedico.getDiaAtendimento();
				int intervaloAtendimento = Integer.parseInt(selectedMedico.getIntervaloAtendimento().substring(3, 5));
				int horarioAtendimentoHora   = Integer.parseInt(selectedMedico.getHorarioAtendimento().substring(0, 2));
				int horarioAtendimentoMinuto = Integer.parseInt(selectedMedico.getHorarioAtendimento().substring(3, 5));

				List<AgendaMedica> selectedMedicoAgenda = AgendaMedicaDAO.getInstance().getByMedico(agenda.getMedico().getCodigo());
				
				for (DiaAtendimento d : diasAtendimentoList) {
					if (d.getCodigo() == selectedDiaId) {
						printHorarios = true;
						break;
					}
				}
				
				if (printHorarios) {
					Date compareDate = calendar.getDate();
									
					int currentHora = horarioAtendimentoHora;
					int currentMin  = horarioAtendimentoMinuto;
					
					DefaultListModel listModel = new DefaultListModel();
														
					for (int i = 0; (i*intervaloAtendimento) <= 360; i++) {
						currentHora += (currentMin + intervaloAtendimento) / 60;
						currentMin = (horarioAtendimentoMinuto + i*intervaloAtendimento) % 60;
						
						compareDate.setHours(currentHora);
						compareDate.setMinutes(currentMin);
						compareDate.setSeconds(0);
						
						if (Utils.thisHorarioIsFree(selectedMedicoAgenda, compareDate))
							listModel.addElement(String.format("%02d", currentHora) + ":" + String.format("%02d", currentMin));
					}
					
					horariosList.setModel(listModel);
				}
				else {
					DefaultListModel listModel = new DefaultListModel();
					horariosList.setModel(listModel);
				}				
			}
		});
		comboBoxMedicos.setEditable(true);
		comboBoxMedicos.setBounds(247, 75, 273, 19);
		frame.getContentPane().add(comboBoxMedicos);
		
		calendar.getDayChooser().addPropertyChangeListener(new PropertyChangeListener() {
			@SuppressWarnings({ "deprecation" })
			public void propertyChange(PropertyChangeEvent evt) {
				boolean printHorarios = false;
				int selectedDiaId = Utils.getDayId(calendar.getDate().toString());
				int selectedMedicoCrm = Integer.parseInt(comboBoxMedicos.getSelectedItem().toString().split("-")[0].trim());
				Medico selectedMedico = MedicoDAO.getInstance().getById(selectedMedicoCrm);
				List<DiaAtendimento> diasAtendimentoList = selectedMedico.getDiaAtendimento();
				int intervaloAtendimento = Integer.parseInt(selectedMedico.getIntervaloAtendimento().substring(3, 5));
				int horarioAtendimentoHora   = Integer.parseInt(selectedMedico.getHorarioAtendimento().substring(0, 2));
				int horarioAtendimentoMinuto = Integer.parseInt(selectedMedico.getHorarioAtendimento().substring(3, 5));

				List<AgendaMedica> selectedMedicoAgenda = AgendaMedicaDAO.getInstance().getByMedico(agenda.getMedico().getCodigo());
				
				for (DiaAtendimento d : diasAtendimentoList) {
					if (d.getCodigo() == selectedDiaId) {
						printHorarios = true;
						break;
					}
				}
				
				if (printHorarios) {
					Date compareDate = calendar.getDate();
									
					int currentHora = horarioAtendimentoHora;
					int currentMin  = horarioAtendimentoMinuto;
					
					DefaultListModel listModel = new DefaultListModel();
														
					for (int i = 0; (i*intervaloAtendimento) <= 360; i++) {
						currentHora += (currentMin + intervaloAtendimento) / 60;
						currentMin = (horarioAtendimentoMinuto + i*intervaloAtendimento) % 60;
						
						compareDate.setHours(currentHora);
						compareDate.setMinutes(currentMin);
						compareDate.setSeconds(0);
						
						if (Utils.thisHorarioIsFree(selectedMedicoAgenda, compareDate))
							listModel.addElement(String.format("%02d", currentHora) + ":" + String.format("%02d", currentMin));
					}
					
					horariosList.setModel(listModel);
				}
				else {
					DefaultListModel listModel = new DefaultListModel();
					horariosList.setModel(listModel);
				}
			}
		});
		calendar.setBounds(12, 34, 223, 138);
		frame.getContentPane().add(calendar);
		
		JLabel lblNewLabel = new JLabel("Selecione uma data e um horário");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 11));
		lblNewLabel.setBounds(12, 12, 223, 25);
		frame.getContentPane().add(lblNewLabel);
		
		List<Paciente> pacientes = PacienteDAO.getInstance().findAll();
		
		JComboBox comboBoxPacientes = new JComboBox(pacientes.toArray());
		comboBoxPacientes.setEditable(true);
		comboBoxPacientes.setBounds(247, 34, 273, 19);
		
		frame.getContentPane().add(comboBoxPacientes);
		
		JLabel lblNewLabel_5 = new JLabel("Matricula do Paciente");
		lblNewLabel_5.setFont(new Font("Dialog", Font.BOLD, 11));
		lblNewLabel_5.setBounds(247, 16, 187, 15);
		frame.getContentPane().add(lblNewLabel_5);
		
		JButton voltarButton = new JButton("Voltar");
		voltarButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				frame.dispose();
			}
		});
		voltarButton.setBounds(12, 354, 117, 25);
		frame.getContentPane().add(voltarButton);
		
		JButton atualizarButton = new JButton("Atualizar");
		atualizarButton.setEnabled(false);
		atualizarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(  horariosList.isSelectionEmpty()
					      || comboBoxPacientes.getSelectedItem().toString() == ""
						) {
							JOptionPane.showMessageDialog(null, "Selecione todos os campos!");
							return;
						}

						AgendaEquipamento novaAgenda = new AgendaEquipamento();
						
						int horaAgendamento   = Integer.parseInt(horariosList.getSelectedValue().toString().substring(0,2));
						int minutoAgendamento = Integer.parseInt(horariosList.getSelectedValue().toString().substring(3,5));
						
						Date diaAgendamento = calendar.getDate();
						diaAgendamento.setHours(horaAgendamento);
						diaAgendamento.setMinutes(minutoAgendamento);
						diaAgendamento.setSeconds(0);

						int selectedMedicoCrm = Integer.parseInt(comboBoxMedicos.getSelectedItem().toString().split("-")[0].trim());
						Medico selectedMedico = MedicoDAO.getInstance().getById(selectedMedicoCrm);
						
						novaAgenda.setDataAgendamento(diaAgendamento);
						novaAgenda.setMedico(selectedMedico);
							
						novaAgenda.setPaciente(PacienteDAO.getInstance().getById(Integer.parseInt(comboBoxPacientes.getSelectedItem().toString().split(" ")[0])));
						
						AgendaEquipamentoDAO.getInstance().persist(novaAgenda);
						AgendaEquipamentoDAO.getInstance().remove(agenda);
						
						JOptionPane.showMessageDialog(null, "Atualizado!");
						frame.dispose();
			}
		});
		atualizarButton.setBounds(403, 354, 117, 25);
		frame.getContentPane().add(atualizarButton);
		
		horariosList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				atualizarButton.setEnabled(true);
			}
		});
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				AgendaEquipamentoDAO.getInstance().remove(agenda);
				JOptionPane.showMessageDialog(null, "Removido!");
				frame.dispose();
			}
		});
		btnDeletar.setBounds(215, 351, 98, 25);
		frame.getContentPane().add(btnDeletar);
		
		JLabel lblMedicoResponsavel = new JLabel("Medico Responsavel");
		lblMedicoResponsavel.setFont(new Font("Dialog", Font.BOLD, 11));
		lblMedicoResponsavel.setBounds(247, 61, 273, 15);
		frame.getContentPane().add(lblMedicoResponsavel);
		
		calendar.setDate(this.agenda.getDataAgendamento());
		comboBoxPacientes.setSelectedItem(this.agenda.getPaciente());
		comboBoxMedicos.setSelectedItem(this.agenda.getMedico());
	}

	public void showFrame() {
		frame.setVisible(true);
	}
}