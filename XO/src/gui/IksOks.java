package gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logika.Kompjuter;

import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		setBounds(100, 100, 450, 300);
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
		// TODO Auto-generated method stub
		char[][] polja = new char[3][3];
		
		for(int i = 0; i < 3; i++){
			 for(int j = 0; j < 3; j++){
				 polja[i][j] = ' ';
			 }
		 }
		
		ModelTabele mt = new ModelTabele(polja);
		table.setModel(mt);
		table.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.gray));
		
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
					ModelTabele mt = (ModelTabele)table.getModel();
					char [][] tabela = mt.getPolja();
					komp = new Kompjuter(rdbtnIgramPrvi.isSelected(), tabela );
					komp.igraj();
					mt.fireTableDataChanged();
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
		}
		return table;
	}
}
