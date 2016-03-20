package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import logika.Metode;

import javax.swing.JTable;
import java.awt.Color;

public class GUI extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JTable jtablePolja;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
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
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPanel(), BorderLayout.CENTER);
		popuniTabelu();
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.add(getJtablePolja());
		}
		return panel;
	}
	private JTable getJtablePolja() {
		
		if (jtablePolja == null) {
			jtablePolja = new JTable();
			jtablePolja.setBackground(Color.WHITE);
			jtablePolja.setBorder(null);
			jtablePolja.setTableHeader(null);
		}
		return jtablePolja;
	}
	
	private void popuniTabelu(){
		//to do
		
	}
}
