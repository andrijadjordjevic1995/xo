package logika;

import java.util.Random;

import klase.Polje;

public class Kompjuter extends Polje {
	
	private Random rand = new Random();
	private char[][] tabela;
	private int kolona;
	private int red;
	private char slovo;
	
	public Kompjuter(boolean igraKaoPrvi, char[][] tabela){
		this.tabela = tabela;
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
		}else{
			igraj();
		}
		
		return;
	}
}
