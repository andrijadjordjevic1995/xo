package gui;

import javax.swing.table.AbstractTableModel;

public class ModelTabele extends AbstractTableModel {
	private char[][] polja;
	
	public ModelTabele(char[][] polja) {
		this.polja = polja;
	}
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public Object getValueAt(int red, int kolona) {
		// TODO Auto-generated method stub
		return polja[red][kolona];
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {

		return true;
	}
	
	public char[][] getPolja() {
		return polja;
	}
	public void setPolja(char[][] polja) {
		this.polja = polja;
	}
	
	
}
