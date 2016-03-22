package logika;

import java.util.Random;

import klase.Polje;

public class Kompjuter extends Polje {
	
	private Random rand = new Random();
	private char[][] tabela;
	private int kolona;
	private int red;
	private char slovo;
	private Metode metode;
	
	public Kompjuter(boolean igraKaoPrvi, char[][] tabela, Metode metode){
		this.tabela = tabela;
		this.metode = metode;
		if(igraKaoPrvi == true){
			slovo = 'O';
		}else{
			slovo = 'X';
		}
	}
	
	public void igraj(){
		kolona = rand.nextInt(3);
		red = rand.nextInt(3);
		
		if(tabela[red][kolona] == ' '){
			tabela[red][kolona] = slovo;
			metode.setBrojPoteza((metode.getBrojPoteza())+1);
		}else{
			igraj();
		}
		
		return;
	}
}
