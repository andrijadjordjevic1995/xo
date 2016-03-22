package gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logika.Kompjuter;
import logika.Metode;

import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Timer;
import java.util.TimerTask;

public class IksOks extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JButton btnIgraj;
	private JRadioButton rdbtnIgramPrvi;
	private JRadioButton rdbtnIgramDrugi;
	private JTable table;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private Kompjuter komp;
	private Metode metode = new Metode();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IksOks frame = new IksOks();
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
	public IksOks() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPanel(), BorderLayout.CENTER);
		contentPane.add(getPanel_1(), BorderLayout.NORTH);
		urediTabelu();
		rdbtnIgramPrvi.setSelected(true);
		
	}

	private void urediTabelu() {
		
		ModelTabele mt = new ModelTabele(metode.getPolja());
		table.setModel(mt);
		table.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.gray));
		table.setRowHeight(75);
		
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new MigLayout("", "[grow][][grow]", "[grow][][grow]"));
			panel.add(getTable(), "cell 1 1,alignx left,aligny top");
		}
		return panel;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(new MigLayout("", "[grow][73px][79px][55px][grow]", "[23px]"));
			panel_1.add(getRdbtnIgramPrvi(), "cell 1 0,alignx left,aligny top");
			panel_1.add(getRdbtnIgramDrugi(), "cell 2 0,alignx left,aligny top");
			panel_1.add(getBtnIgraj(), "cell 3 0,alignx left,aligny top");
		}
		return panel_1;
	}
	private JButton getBtnIgraj() {
		if (btnIgraj == null) {
			btnIgraj = new JButton("Igraj");
			btnIgraj.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(metode.vratiPobednika() == 'X' || metode.vratiPobednika() == 'O'){
						
						JOptionPane.showInternalMessageDialog(contentPane, "Pobedio je: " + metode.vratiPobednika(), "POBEDNIK", JOptionPane.INFORMATION_MESSAGE);
						
					}else if(metode.vratiPobednika() == 'd'){
						JOptionPane.showInternalMessageDialog(contentPane, "Nereseno je!", "POBEDNIK", JOptionPane.INFORMATION_MESSAGE);

					}else{
					
					ModelTabele mt = (ModelTabele)table.getModel();
					char [][] tabela = mt.getPolja();
					komp = new Kompjuter(rdbtnIgramPrvi.isSelected(), tabela , metode);
					table.setVisible(true);
					komp.igraj();
					mt.fireTableDataChanged();
					}
					
				}
			});
		}
		return btnIgraj;
	}
	private JRadioButton getRdbtnIgramPrvi() {
		if (rdbtnIgramPrvi == null) {
			rdbtnIgramPrvi = new JRadioButton("igram prvi");
			buttonGroup.add(rdbtnIgramPrvi);
		}
		return rdbtnIgramPrvi;
	}
	private JRadioButton getRdbtnIgramDrugi() {
		if (rdbtnIgramDrugi == null) {
			rdbtnIgramDrugi = new JRadioButton("igram drugi");
			buttonGroup.add(rdbtnIgramDrugi);
		}
		return rdbtnIgramDrugi;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
				}
				@Override
				public void mousePressed(MouseEvent e) {
					
					if(metode.vratiPobednika() == 'X' || metode.vratiPobednika() == 'O'){
						
						JOptionPane.showInternalMessageDialog(contentPane, "Pobedio je: " + metode.vratiPobednika(), "POBEDNIK", JOptionPane.INFORMATION_MESSAGE);
						
					}else if(metode.vratiPobednika() == 'd'){
						JOptionPane.showInternalMessageDialog(contentPane, "Nereseno je!", "POBEDNIK", JOptionPane.INFORMATION_MESSAGE);

					}else{
						metode.dodajUPolje(table.getSelectedRow(), table.getSelectedColumn());
					}
						
				}
			});
		}
		return table;
	}
}
