package br.com.clinica;

import javax.swing.JFrame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import br.com.clinica.controllers.SelectionController;

import javax.swing.JList;
import javax.swing.DefaultListModel;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowEvent;

@SuppressWarnings({ "rawtypes" })
public class SelecaoWindow<TItem, TController extends SelectionController> {
	
	private JFrame frame;
	
	private TController ctl;
	private List<TItem> listData;
	private DefaultListModel listModel;
	JList myJList = new JList();
	private JButton btnSelect;

	public SelecaoWindow(TController ctll) {		
		this.ctl = ctll;
		this.listModel = new DefaultListModel();
		
		initialize();
		frame.addWindowFocusListener(new WindowFocusListener() {
			@SuppressWarnings("unchecked")
			public void windowGainedFocus(WindowEvent e) {
				// Refreshes the list so it keeps track of newly added entries
				listModel.removeAllElements();
				listData = ctl.getElements();
				
				for (TItem agenda : listData) {
					listModel.addElement(agenda);				
				}				
				
				btnSelect.setEnabled(false);
			}
			
			public void windowLostFocus(WindowEvent e) {
			}
		});
	}

	@SuppressWarnings("unchecked")
	private void initialize() {
		frame = new JFrame();
		
		frame.setResizable(false);
		frame.setTitle(ctl.getTitle());
		frame.setBounds(100, 100, 450, 300);
		frame.getContentPane().setLayout(null);

		listData = ctl.getElements();
		
		for (TItem agenda : listData) {
		    listModel.addElement(agenda);
		}
		myJList.setModel(listModel);
		myJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		/* Botões */
		JLabel lblAgendaMedica = new JLabel(ctl.getLabel());
		lblAgendaMedica.setBounds(12, 12, 416, 25);
		frame.getContentPane().add(lblAgendaMedica);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(12, 237, 98, 25);
		btnVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				frame.dispose();
			}
		});

		frame.getContentPane().add(btnVoltar);
		
		btnSelect = new JButton(ctl.getBtnText());
		btnSelect.setBounds(290, 237, 148, 25);
		btnSelect.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (!btnSelect.isEnabled()) return;
				
				try {
					int idx = myJList.getSelectedIndex();
					ctl.selectedElement(listData.get(idx));
				} catch (Exception f) {
					System.exit(0);
				}
			}
		});
		myJList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				btnSelect.setEnabled(true);
			}
		});
		frame.getContentPane().add(btnSelect);
		
		/* Scrollpane de seleção */
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 37, 416, 175);
		frame.getContentPane().add(scrollPane);
	
		scrollPane.setViewportView(myJList);
	}
	
	public void showFrame() {
		frame.setVisible(true);
	}
}
