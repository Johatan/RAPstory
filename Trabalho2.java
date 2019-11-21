import javax.swing.*;

import java.util.*;


public class Trabalho2 {

	static final int TAMANHO = 9;

	static public class Pessoa {

		String usuario;
		int conta;
		Double saldo;

	}

	static String correntista;
	static int i, j, conta;
	static Double extrato, extrato_atual;
	static Pessoa pessoas[][] = new Pessoa[3][3];
	static {
		
		pessoas[0][0] = new Pessoa();
		pessoas[0][0].usuario = "Tibúrcio";
		pessoas[0][0].conta = 111;
		pessoas[0][0].saldo = 0.0;

		pessoas[0][1] = new Pessoa();
		pessoas[0][1].usuario = "Ricardo";
		pessoas[0][1].conta = 222;
		pessoas[0][1].saldo = 0.0;

		pessoas[0][2] = new Pessoa();
		pessoas[0][2].usuario = "João";
		pessoas[0][2].conta = 333; 
		pessoas[0][2].saldo = 0.0;

		pessoas[1][0] = new Pessoa();
		pessoas[1][0].usuario = "Felisbino";
		pessoas[1][0].conta = 444;
		pessoas[1][0].saldo = 0.0;

		pessoas[1][1] = new Pessoa();
		pessoas[1][1].usuario = "Seu Zé";
		pessoas[1][1].conta = 555;
		pessoas[1][1].saldo = 0.0;

		pessoas[1][2] = new Pessoa();
		pessoas[1][2].usuario = "Dona Maria";
		pessoas[1][2].conta = 666;
		pessoas[1][2].saldo = 0.0;

		pessoas[2][0] = new Pessoa();
		pessoas[2][0].usuario = "Gedonstrôncio";
		pessoas[2][0].conta = 777;
		pessoas[2][0].saldo = 0.0;

		pessoas[2][1] = new Pessoa();
		pessoas[2][1].usuario = "Batman";
		pessoas[2][1].conta = 888;
		pessoas[2][1].saldo = 0.0;

		pessoas[2][2] = new Pessoa();
		pessoas[2][2].usuario = "Homem de Ferro";
		pessoas[2][2].conta = 999;
		pessoas[2][2].saldo = 0.0;

	}

	public static void main(String args[]){
		menu();
	}

	public static void menu() {
		int menu = Integer.parseInt(JOptionPane.showInputDialog("Escolha qual das seguintes ações deverá ser executada:\n" +

			"1 - Efetuar Depósito.\n" +
			"2 - Efetuar Pagamento.\n" +
			"3 - Mostrar Números de Conta, Usuários e Saldos.\n" +
			"4 - Mostrar Usuário mais rico.\n" +
			"5 - Mostrar todos os saldos ordenados do menor para o maior\n" +
			"6 - Sair"));

		switch(menu){
			
			case 1:
			conta = Integer.parseInt(JOptionPane.showInputDialog("Insira o número da conta em que deseja depositar: "));
			extrato = Double.parseDouble(JOptionPane.showInputDialog("Insira o valor do deposito: "));

			JOptionPane.showMessageDialog(null, correntista + " seu saldo é de: " + DepositoEfetuado(conta, extrato));
			menu();
			break;

			case 2:
			conta = Integer.parseInt(JOptionPane.showInputDialog("Insira o número da conta em que deseja executar um pagamento: "));
			extrato = Double.parseDouble(JOptionPane.showInputDialog("Insira o valor do pagamento: "));

			JOptionPane.showMessageDialog(null, correntista + " seu saldo é de: "+ PagamentoEfetuado(conta, extrato));
			menu();
			break;

			case 3:

			JOptionPane.showMessageDialog(null, MostrarTodosOsDados());
			menu();
			break;
			
			case 4:

			MostrarUsuarioMaisRico();
			JOptionPane.showMessageDialog(null, "O usuario mais rico é: \n" + conta + " / " + correntista + " / " + extrato);
			menu();
			break;

			case 5:

			JOptionPane.showMessageDialog(null, DadosOrganizadosCrescente());
			menu();
			break;

			case 6:	

			break;
			
			default:
			JOptionPane.showMessageDialog(null, "Numero invalido");
			menu();
			break;				
		}
	}



	/* 1 - Inserir Recebimento (+): Solicite ao usuário o número da contae depois o valor. 
	Some o recebimento ao saldo da conta deste usuário e depois mostre o saldo desta pessoa 
	usando o seguinte formato:“(usuario)seu saldo atual é de: ”+ SALDO */


	public static Double DepositoEfetuado(int conta, Double extrato) {

		for(i=0; i<3; i++){
			for(j=0; j<3; j++){
				if(pessoas[i][j].conta == conta){
					pessoas[i][j].saldo = pessoas[i][j].saldo + extrato;
					extrato = pessoas[i][j].saldo;
					correntista = pessoas[i][j].usuario;
				}

			}

		}

		return extrato;
		

	}

	/* 2 - Inserir Pagamento(-): Solicite ao usuário o número da contae depois o valor. Subtraia 
	o pagamento do salto atual e depois mostre o novo saldo desta pessoa usando o seguinte formato:“(usuario)seu saldo atual é de: ”+ SALDO. */
	
	public static Double PagamentoEfetuado(int conta, Double extrato) {

		for(i=0; i<3; i++){
			for(j=0; j<3; j++){
				if(pessoas[i][j].conta == conta){
					pessoas[i][j].saldo = pessoas[i][j].saldo - extrato;
					extrato = pessoas[i][j].saldo;
					correntista  = pessoas[i][j].usuario;

				}

			}

		}

		return extrato;
		

	}

	/* 3- Mostre em apenas uma mensagem todos os Números de Conta, usuarios e Saldos respectivos. */
	
	public static String MostrarTodosOsDados() {

		String contas = "", lista = "";

		for(i=0; i<3; i++){
			for(j=0; j<3; j++){
				contas = pessoas[i][j].usuario + " / " + pessoas[i][j].conta + " / " + pessoas[i][j].saldo + "\n";
				lista = lista + contas;

			}
		}

		return lista;
		

	}

	/* 4 - Mostre em apenas uma mensagem o Número da Conta, o Nome do usuario e o saldo do usuario mais RICO. */
	
	public static void MostrarUsuarioMaisRico(){

		Double maior_saldo = -9999999999999999.9;
		int linha_maior = 0;
		int coluna_maior = 0;
		for(i=0; i<3; i++){
			for(j=0; j<3; j++){
				if (pessoas[i][j].saldo > maior_saldo){
					maior_saldo = pessoas[i][j].saldo;
					linha_maior = i;
					coluna_maior = j;
					correntista   = pessoas[i][j].usuario;
					conta = pessoas[i][j].conta;
					extrato = pessoas[i][j].saldo;

				}
			}
		}
		

	}

	/* 5 - Mostre em apenas uma mensagem todos os saldos ordenados do menor para o maior. Para isso coloque 
	todos os saldos dentro de um vetor e ordene usando BubbleSort */

	public static String DadosOrganizadosCrescente(){

		Double vetorSaldos[] = new Double[TAMANHO];
		Double  aux;
		int x, troca;	
		
		x=0;
		for(i=0; i<3; i++){
			for(j=0; j<3; j++){
				vetorSaldos[x] = pessoas[i][j].saldo;
				x++;

			}
		}
		troca = 1;
		while(troca == 1){
			troca = 0;
			for(i = 0; i < 8; i++){
				if(vetorSaldos[i] > vetorSaldos[i + 1]){
					aux = vetorSaldos[i];
					vetorSaldos[i] = vetorSaldos[i + 1];
					vetorSaldos[i + 1] = aux;
					troca = 1;
				}
				
			}
		}

		String ordenados = Arrays.toString(vetorSaldos);

		return ordenados;
		

	}

}
