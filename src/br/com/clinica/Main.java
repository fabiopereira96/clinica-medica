package br.com.clinica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.plaf.metal.MetalLookAndFeel;

public class Main { 
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(new MetalLookAndFeel());
			JFrame.setDefaultLookAndFeelDecorated(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

		MainWindow mainWindow = new MainWindow();

		EventQueue.invokeLater(() -> {
			try {
				mainWindow.showFrame();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
}