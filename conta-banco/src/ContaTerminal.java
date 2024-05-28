import java.util.Scanner; // programa utiliza a classe Scanner para ler os dados do teclado.

public class ContaTerminal {
	public static void main(String[] args) throws Exception {
		// TODO: Conhecer e importar a classe Scanner
		// cria um Scanner para obter entrada a partir da janela de comando, usando o
		// CONSOLE da IDE

		Scanner scan = new Scanner(System.in);

		// Declarando as variáveis.
		String sAgencia = "";
		String sNomeCliente = "";
		String sSaldo = "";
		int iNumero = 0;
		double dSaldo = 0;
		boolean bEntradaValida = false;

		// Solicitar e ler o número da conta.
		System.out.println("Por favor, digite o número da Conta: ");
		while (!scan.hasNextInt()) {
			System.out.println("Entrada inválida. \nPor favor, digite um número válido para a Conta: \n\"SOMENTE NÚMEROS.\"");
			scan.next(); // Descarta a entrada inválida
		}
		
		iNumero = scan.nextInt();
		scan.nextLine(); // Consumir o caractere de nova linha deixado por nextInt()

		// Solicitar e ler o número da agência.
		System.out.print("Por favor, digite o número da Agência sem o \"-\": ");
		while (true) {
			sAgencia = scan.nextLine();
			if (sAgencia.matches("\\d+")) { // Verifica se a entrada contém apenas dígitos
				break;
			} else {
				System.out
						.println("Entrada inválida. Por favor, informe o número correto da agência (somente números):");
			}
		}

		// Solicitar e ler o nome do cliente.
		System.out.println("Por favor, digite seu nome?");
		while (true) {
			sNomeCliente = scan.nextLine();
			if (sNomeCliente.matches("[a-zA-Z\\s]+")) { // Verifica se a entrada contém apenas letras e espaços
				sNomeCliente = sNomeCliente.toUpperCase(); // Converte todos os caracteres para maiúsculo
				break;
			} else {
				System.out.println("Entrada inválida. Por favor, digite seu nome novamente.\nApenas com letras");
			}
		}

		// Loop para solicitar a entrada do usuário até que seja válida
		do {
			// Solicitar e ler o saldo inicial
			System.out.println("Por favor, digite o seu saldo?");
			sSaldo = scan.nextLine();

			// Substitui vírgulas por pontos
			sSaldo = sSaldo.replace(',', '.');

			if (sSaldo.trim().isEmpty()) {
				System.out.println("Erro de entrada: \nPor favor, insira a informação correta.");
				continue; // Reinicia o loop para solicitar a entrada novamente
			}

			try {
				dSaldo = Double.parseDouble(sSaldo);
				bEntradaValida = true; // Marca a entrada como válida para sair do loop
			} catch (NumberFormatException e) {
				System.out.println("Erro de entrada: Insira um valor numérico válido para a quantidade em Reais.");
				// Reinicia o loop para solicitar a entrada novamente

			} catch (Exception e) {
				System.out.println("Erro inesperado: " + e.getMessage());
				e.printStackTrace();
				// Reinicia o loop para solicitar a entrada novamente
			}

		} while (!bEntradaValida);

		System.out.println("Olá " + sNomeCliente + ", obrigado por criar uma conta em nosso banco,\nsua agência é "
				+ sAgencia + ", \nconta " + iNumero + "\ne seu saldo " + String.format("%.2f", dSaldo)
				+ " já está disponível para saque.");

		scan.close(); // Fechar o scanner

		System.exit(0); // Término do progama
	}// Fim do método main ()
}// Fim da class ContaTerminal