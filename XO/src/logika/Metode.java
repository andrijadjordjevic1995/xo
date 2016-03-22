package logika;

public class Metode {
	private int brojPoteza;
	private char[][] polja;
	
	public Metode(){
		 polja = new char[3][3];
		 brojPoteza = 0;
		 for(int i = 0; i < 3; i++){
			 for(int j = 0; j < 3; j++){
				 polja[i][j] = ' ';
			 }
		 }
	}
	
	public void dodajUPolje(int i, int j){
		if(polja[i][j] != ' ')
			return;
		brojPoteza++;
		if(brojPoteza % 2 == 0)
			polja[i][j] = 'O';
		else
			polja[i][j] = 'X';
	}
	
	public int getBrojPoteza() {
		return brojPoteza;
	}



	public void setBrojPoteza(int brojPoteza) {
		this.brojPoteza = brojPoteza;
	}



	public char[][] getPolja() {
		return polja;
	}

	public char vratiPobednika(){
		char pobednik;
		if((pobednik = porediRed()) != ' '){
			return pobednik;
		}else if((pobednik = porediKolonu()) != ' '){
			return pobednik;
		}else if((pobednik = porediDij1()) != ' '){
			return pobednik;
		}else if((pobednik = porediDij2()) != ' '){
			return pobednik;
		}
		if(brojPoteza == 9){
			return 'd';
			//draw
		}
		return 'n';
		//nastavlja se
		
	}
	private char porediRed(){
		for(int i = 0; i < 3; i++){
			if(polja[i][0] != ' ' &&
					polja[i][0] == polja[i][1] &&
						polja[i][0] == polja[i][2])
				return polja[i][0];
		}
		return ' ';
	}
	private char porediKolonu(){
		for(int i = 0; i < 3; i++){
			if(polja[i][0] != ' ' &&
					polja[0][i] == polja[1][i] &&
						polja[0][i] == polja[2][i])
				return polja[0][i];
		}
		return ' ';
	}
	private char porediDij1(){
		//moze i pomocu for petlje ali je neefikasno
		if(polja[0][0] != ' ' 
				&& polja[0][0] == polja[1][1] 
						&& polja [0][0] == polja[2][2])
			return polja[0][0];
		return ' ';
	}
	
	private char porediDij2(){
		if(polja[0][2] != ' '
				&& polja[0][2] == polja[1][1] 
						&& polja [0][2] == polja[2][0])
			return polja[0][0];
		return ' ';
	}
}
