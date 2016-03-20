package logika;

import java.util.Random;

import klase.Polje;

public class Kompjuter extends Polje {
	
	private Random rand = new Random();
	private int kolona;
	private int red;
	private char slovo;
	
	public Kompjuter(boolean igraKaoPrvi){
		if(igraKaoPrvi == true){
			slovo = 'x';
		}else{
			slovo = 'o';
		}
	}
	
	private void igraj(char[][] tabela){
		kolona = rand.nextInt(3);
		red = rand.nextInt(3);
		
		if(tabela[red][kolona] == ' '){
			tabela[red][kolona] = slovo;
		}else{
			igraj(tabela);
		}
		
		return;
	}
}
