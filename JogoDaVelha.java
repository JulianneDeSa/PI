/*********************************************************************/
/**   ACH2001 - Introdução à Programação                            **/
/**   EACH-USP - Primeiro Semestre de 2020                          **/
/**   002 - Prof. Dr. Luciano Antonio Digiampietri                  **/
/**                                                                 **/
/**   Terceiro Exercício-Programa                                   **/
/**                                                                 **/
/**   Julianne Amanda de Sá Laurindo              11894590          **/
/**                                                                 **/
/**   01/06/2020                                                    **/
/*********************************************************************/

/*
	Jogo da Velha - programa para verificar o status de um jogo.
	
	Lista de Status calculado:
    0 - Jogo não iniciado: o tabuleiro está 'vazio', isto é sem peças X e O;
    1 - Jogo encerrado1: o primeiro jogador (que usa as peças X) é o ganhador;
    2 - Jogo encerrado2: o segundo jogador (que usa as peças O) é o ganhador;
    3 - Jogo encerrado3: empate - todas as casas do tabuleiro estão preenchidas com X e O, mas nenhum dos jogadores ganhou;
    4 - Jogo já iniciado e em andamento: nenhuma das alternativas anteriores.	
*/

public class JogoDaVelha {
	static final char pecaX = 'X';
	static final char pecaY = 'O';
	static final char espacoVazio = ' ';

	static int verificaStatus(char[][] tabuleiro) {
		int xCounter = 0;
		int oCounter = 0;
		int spaceCounter = 0; 
		for(int i = 0; i < 3; i++){ //calcula quantos X e O foram colocados
			for(int j = 0;j < 3;j++){
				if(tabuleiro[i][j] == pecaX){
					xCounter = xCounter+1;
				}
				else if(tabuleiro[i][j] == pecaY){
					oCounter= oCounter+1;
				}
				else{
					spaceCounter= spaceCounter+1;
				}
				
			}	
		}
	/*	if(oCounter>xCounter || xCounter>(oCounter+1)){ //verifica se o numero de peças x e o são validas
			return -1;
		}
	*/
		if(xCounter==0){ //sem x, significa que o jogo não começou
			return 0;
		}
		else if(xCounter<3){ // sem ter 3 peças de um mesmo jogador no jogo, não há como terem ganhadores, então o jogo continua
			return 4;
		}
		else{
			return (verificaGanhador(tabuleiro,spaceCounter));
		}		
	}
	
	static int verificaGanhador(char[][] tabuleiro, int spaceCounter){
		for(int i=0;i<3;i++){ //verifica se é vencedor por uma coluna ou linha 
			if(tabuleiro[0][i] == tabuleiro[1][i] && tabuleiro[1][i] == tabuleiro[2][i]){
				if(tabuleiro[0][i] == pecaX)
					return 1;
				else if(tabuleiro[0][i] == pecaY)
					return 2;
			}
			else if(tabuleiro[i][0] == tabuleiro[i][1] && tabuleiro[i][1] == tabuleiro[i][2]){
				if(tabuleiro[i][0] == pecaX)
					return 1;
				else if(tabuleiro[i][0] == pecaY)
					return 2;
			}
		}
		if((tabuleiro[0][0] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][2]) || (tabuleiro[0][2] == tabuleiro [1][1] && tabuleiro[1][1] == tabuleiro[2][0])){
			//verifica se é vencedor por uma diagonal
			if(tabuleiro[1][1] == pecaX)
				return 1;
			else if(tabuleiro[1][1] == pecaY)
				return 2;
		}
		if(spaceCounter == 0){ //verifica se acabou o jogo
			return 3;
		}
		else{ //Caso não
		return 4;
		}
	}
	
	public static void main(String[] args) {

		char[][] tab0 = {{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}};
    	char[][] tab1 = {{'X','X','X'},{'O','O',' '},{' ',' ',' '}};
    	char[][] tab2 = {{'O','X','X'},{'X','O','O'},{' ',' ','O'}};
   		char[][] tab3 = {{'O','X','X'},{'X','O','O'},{'O','X','X'}};
    	char[][] tab4 = {{' ',' ',' '},{'X','O','X'},{' ',' ',' '}};
		char[][] tab5 = {{' ',' ',' '},{'O','O',' '},{'X','X','X'}};
    	char[][] tab6 = {{' ',' ','O'},{'X','O','O'},{'O','X','X'}};
    	char[][] tab7 = {{'X','X','O'},{'O','O','X'},{'X','X','O'}};
    	char[][] tab8 = {{' ','X',' '},{' ','O',' '},{' ','X',' '}};
    	char[][] tab9 = {{' ',' ',' '},{'X','X','X'},{'O','O',' '}};
    	char[][] tab10 = {{'X','O','X'},{'O','O','X'},{'X','O',' '}};
    	char[][] tab11 = {{' ','X','O'},{' ','X',' '},{' ','X','O'}};

    	System.out.println("Status calculado: " + verificaStatus(tab0));
    	System.out.println("Status esperado para o tabuleiro0: 0\n");

    	System.out.println("Status calculado: " + verificaStatus(tab1));
    	System.out.println("Status esperado para o tabuleiro1: 1\n");

    	System.out.println("Status calculado: " + verificaStatus(tab2));
    	System.out.println("Status esperado para o tabuleiro2: 2\n");
    
    	System.out.println("Status calculado: " + verificaStatus(tab3));
    	System.out.println("Status esperado para o tabuleiro1: 3\n");
    
   		System.out.println("Status calculado: " + verificaStatus(tab4));
    	System.out.println("Status esperado para o tabuleiro4: 4\n");
    
    	System.out.println("Status calculado: " + verificaStatus(tab5));
    	System.out.println("Status esperado para o tabuleiro5: 1\n");
     
    	System.out.println("Status calculado: " + verificaStatus(tab6));
    	System.out.println("Status esperado para o tabuleiro6: 2\n");
    
    	System.out.println("Status calculado: " + verificaStatus(tab7));
    	System.out.println("Status esperado para o tabuleiro7: 3\n");
    
    	System.out.println("Status calculado: " + verificaStatus(tab8));
    	System.out.println("Status esperado para o tabuleiro8: 4\n");

    	System.out.println("Status calculado: " + verificaStatus(tab9));
    	System.out.println("Status esperado para o tabuleiro9: 1\n");
      
    	System.out.println("Status calculado: " + verificaStatus(tab10));
    	System.out.println("Status esperado para o tabuleiro10: 2\n");
      
    	System.out.println("Status calculado: " + verificaStatus(tab11));
    	System.out.println("Status esperado para o tabuleiro11: 1\n");
	}
}