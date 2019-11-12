import javax.swing.*;

public class Trabalho {

	public static void main(String[] args){

		int i, j, mudar, conta;
		int k = 0;
		Double saldo = 0.0, aux;
		String correntista = "";

		String[][] A = new String[3][3];

		A[0][0]= "Tibúrcio";
		A[0][1]= "Ricardo";
		A[0][2]= "João";
		A[1][0]= "Felisbino";
		A[1][1]= "Seu Zé";
		A[1][2]= "Dona Maria";
		A[2][0]= "Gedonstrôncio";
		A[2][1]= "Batman";
		A[2][2]= "Homemde Ferro";

		int[][] B = new int[3][3];

		B[0][0]= 111;
		B[0][1]= 222;
		B[0][2]= 333;
		B[1][0]= 444;
		B[1][1]= 555;
		B[1][2]= 666;
		B[2][0]= 777;
		B[2][1]= 888;
		B[2][2]= 999;

		Double[][] C = new Double[3][3];
		for (i=0;i>3;i++) {
			for (j=0;j>3;j++) {
				C[i][j] = 0.0;
				
			}
			
		}

		while (k<6){

			k = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da opção desejada:\n" + 

			"1 - Depósito. \n" +
			"2 - Pagamento. \n" +
			"3 - Informações sobre os correntistas. \n" +
			"4 - Correntista mais rico. \n" +
			"5 - Mostrar todos \n" +
			"6 - Sair."));

			switch (k) {

				case 1: 

/* 1 – Inserir Recebimento (+): Solicite ao usuário o número da contae depois o valor. Some o recebimento ao saldo da conta deste usuário e depois mostre o saldo desta pessoa usando o seguinte formato:“(CORRENTISTA)seu saldo atual é de: ”+ SALDO. */

				conta = Integer.parseInt(JOptionPane.showInputDialog("Insira o número da conta efetuar o depósito:"));
				for(i=0; i<3; i++){
					for (j=0; j<3 ;j++) {

						if(B[i][j] == conta){
							correntista = A[i][j]; 
							saldo = Double.parseDouble(JOptionPane.showInputDialog("Insira o valor do depósito a ser efetuado:"));
							C[i][j] = C[i][j] + saldo;
							saldo = C[i][j];

						}
						
					}
				}

				JOptionPane.showMessageDialog(null, correntista + "seu saldo é de" + saldo);

				break;

				case 2:	


/* 2 – Inserir Pagamento(-): Solicite ao usuário o número da contae depois o valor. Subtraia o pagamento do salto atual e depois mostre o novo saldo desta pessoa usando o seguinte formato:“(CORRENTISTA)seu saldo atual é de: ”+ SALDO. */

				conta = Integer.parseInt(JOptionPane.showInputDialog("Insira o número da conta para efetuar o pagamento:"));
				for(i=0; i<3; i++){
					for (j=0; j<3 ;j++) {

						if(B[i][j] == conta){
							correntista = A[i][j]; 
							saldo = Double.parseDouble(JOptionPane.showInputDialog("Insira o valor do pagamento a ser efetuado:"));
							C[i][j] = C[i][j] - saldo;
							saldo = C[i][j];

						}
						
					}
				}

				JOptionPane.showMessageDialog(null, correntista + "seu saldo é de" + saldo);

				break;

				case 3:



				break;

				case 4: 

				case 5: 

/* 5 - Mostre em apenas uma mensagem todos os saldos ordenados do menor para o maior. Para isso coloque todos os saldos dentro de um vetor e ordene usando BubbleSort */			

				Double vetorSaldos[] = new Double[9];
					k=0;
					for(i=0; i<3; i++){
						for(j=0; j<3; j++){
							vetorSaldos[k] = C[i][j];
							k++;

						}
					}
					mudar = 1;
					while(mudar == 1){
						mudar = 0;
						for(i = 0; i < 8; i++){
							if(vetorSaldos[i] > vetorSaldos[i + 1]){
								aux = vetorSaldos[i];
								vetorSaldos[i] = vetorSaldos[i + 1];
								vetorSaldos[i + 1] = aux;
								mudar = 1;
							}
							
						}
					}
					JOptionPane.showMessageDialog(null, vetorSaldos);
					k = 1;
					break;
			}

				

		}

	}
}