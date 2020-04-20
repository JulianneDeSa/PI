/*********************************************************************/
/**   ACH2001 - Introdução à Programação                            **/
/**   EACH-USP - Primeiro Semestre de 2020                          **/
/**   Prof. Dr. Luciano Antonio Digiampietri                        **/
/**                                                                 **/
/**   Primeiro Exercício-Programa                                   **/
/**                                                                 **/
/**   Julianne Amanda de Sá Laurindo                 11894590       **/
/**                                                                 **/
/**   15/04/2020                                                    **/
/*********************************************************************/
import java.util.Scanner; // insere o scanner para facilitar os testes
/*
	Caixa eletrônico das Ilhas Weblands, com estoque ilimitado de cédulas
	de B$50,00, B$10,00, B$5,00 e B$1,00.
*/
public class CaixaEletronico {
	static int n50;
	
	static int n10;

	static int n5;
	
	static int n1;

	static void fazRetirada(int valor) { // a função recebe como paramêtro o tanto de dinheiro que a pessoa quer retirar
        if(valor<0){ // verifica se é um valor inválido
            n50= -1;
            n10= -1;
            n5= -1;
            n1= -1;
        }
        else{ // caso seja valido, ele é divido de acordo com os tipos de notas disponiveis no caixa
            n50 = valor / 50;
            n10 = (valor % 50) / 10;
            n5 = (valor % 10) / 5;
            n1 = valor % 5;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // cria um objeto do tipo scanner
        int valor;
        valor = input.nextInt(); //pede para o usuário digitar a quantidade de dinheiro que a pessoa quer retirar para os testes
	fazRetirada(valor); //chama o método tendo como argumento o valor digitado pelo usuário
	System.out.println("Notas de 50: "+n50);
	System.out.println("Notas de 10: "+n10);
	System.out.println("Notas de 5:  "+n5);
        System.out.println("Notas de 1:  "+n1);
        input.close(); //finaliza o scanner
    }
}
