package logika;

import java.util.Random;

import klase.Polje;

public class Kompjuter extends Polje {
	
	private Random rand = new Random();
	private char[][] tabela;
	private int kolona;
	private int red;
	private Metode metode;
	
	public Kompjuter(char[][] tabela, Metode metode){
		this.tabela = tabela;
		this.metode = metode;
	}
	
	public void igraj(){
		kolona = rand.nextInt(3);
		red = rand.nextInt(3);
		
		if(tabela[red][kolona] == ' '){
			if(metode.getBrojPoteza()%2 == 0){
				tabela[red][kolona] = 'X';
			}else{
				tabela[red][kolona] = 'O';
			}
			metode.setBrojPoteza((metode.getBrojPoteza())+1);
		}else{
			igraj();
		}
		
		return;
	}
}
