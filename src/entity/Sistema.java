package entity;

import java.util.Random;
import java.util.Scanner;

public class Sistema {

	static Double valorHora = 10.;
	static Double tempoPermanencia = 0.;
	static Double valorPagamento = 0.;
	static Integer tipoDeEstadia = 0;
	static Integer velocidadeMaximaEstacionamento = 40;

	public static void main(String[] args) {
		try {
		Integer tipoVeiculo = 0;
		Scanner in = new Scanner(System.in);

		Pessoa prop = new Proprietario();

		System.out.println(Marca.getNrDeModelos());

		Endereco en = new Endereco();

		System.out.println("====================================================================================");
		System.out.println("                                    GARAGEM SYSEM                                   ");
		System.out.println("====================================================================================");

		Random r = new Random();
		System.out.println("                         ********************************");
		System.out.println("                                                         ");
		System.out.println("                               TEMPO DE PERMANENCIA      ");
		System.out.println("                                                         ");
		System.out.println("                         ********************************");
		System.out.println("                                                         ");
		// TIPO DE ESTADIA NO ESTACIONAMENTO
		System.out.println("Qual será o tipo de estadia?");
		System.out.println("1 - MENSAL");
		System.out.println("2 - DIÁRIA");
		System.out.println("3 - HORA");

		try {
			tipoDeEstadia = in.nextInt();
			if (tipoDeEstadia < 1 || tipoDeEstadia > 3) {
				throw new Exception("Tipo inválido");
			}

			switch (tipoDeEstadia) {
			case 1:
				valorPagamento = 400.00; // mensal
				break;
			case 2:
				valorPagamento = 20.00; // diaria
				break;
			case 3:
				// CALCULA O VALOR x HORA
				System.out.println("Digite a quantidade de horas: ");
				tempoPermanencia = in.nextDouble();

				if (tempoPermanencia <= 1) {
					valorPagamento = valorHora;
				} else if (tempoPermanencia > 1 && tempoPermanencia <= 5) {
					valorHora = 15.;
				} else if (tempoPermanencia > 5 && tempoPermanencia <= 10) {
					valorHora = 10.;
				} else if (tempoPermanencia > 10 && tempoPermanencia < 24) {
					valorHora = 7.5;
				}
				valorPagamento = tempoPermanencia * valorHora;
				break;
			default:
				break;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("O valor do pagamento será: " + "R$ " + valorPagamento); // da para formatar usando
																					// Numberformat

		// CADASTRA PROPRIETARIO
		System.out.println(" ");
		System.out.println("                        ***********************************");
		System.out.println("                                                         ");
		System.out.println("                         CADASTRO DE VEÍCULO E PROPRIETADIO      ");
		System.out.println("                                                         ");
		System.out.println("                        ***********************************");
		System.out.println("                                                         ");

		in.nextLine();
		System.out.println("Nome: ");
			prop.setNome(in.nextLine());

		System.out.println("CPF: ");
			prop.setCpf(in.nextLine());
		System.out.println("RG: ");
			prop.setRg(in.nextLine());

		// CADASTRA ENDERECO
		System.out.println("                        ***********************************");
		System.out.println("                                                         ");
		System.out.println("                         CADASTRO DE ENDEREÇO DO PROPRIETADIO      ");
		System.out.println("                                                         ");
		System.out.println("                        ***********************************");
		System.out.println("                                                         ");
		System.out.println("Cidade: ");
		System.out.println("Estado: ");
		en.setEstado(in.nextLine());
		System.out.println("CEP:");
		en.setCep(in.nextLine());
		System.out.println("Rua: ");
		en.setRua(in.nextLine());
		System.out.println("Complemento:");
		en.setComplemento(in.nextLine());
		System.out.println("Bairro:");
		en.setBairro(in.nextLine());

		en.setIdEndereco(r.nextInt());
		// proprietario recebe pessoa e pessoa o proprietario
		en.setProprietario(prop);
		prop.setEndereco(en);

		// CADASTRA MARCA
		System.out.println("                        ***********************************");
		System.out.println("                                                         ");
		System.out.println("                                 CADASTRO DO CARRO     ");
		System.out.println("                                                         ");
		System.out.println("                        ***********************************");
		System.out.println("                                                         ");

		Marca maraca = new Marca();
		maraca.setIdMarca(r.nextInt());
		System.out.println("Digite a Marca do Veículo: ");

		maraca.setNome(in.nextLine());


		System.out.println("Digite o Ano: ");

		maraca.setAnoDeLancamento(in.nextLine());


		System.out.println("Qual tipo do veiculo: " + "1) Carro \n2) Moto");
		tipoVeiculo = in.nextInt();

		try {
			if (tipoVeiculo < 1 || tipoVeiculo > 2) {
				throw new Exception("Tipo inválido");
			}

			switch (tipoVeiculo) {
			case 1:
				Veiculo carro = new Carro();
				System.out.println("Numero do chassi: ");
				carro.setChassi(in.nextInt());
				System.out.println("Numero de portas: ");
				carro.setNrDePortas(in.nextInt());
				System.out.println("Numero de marchas: ");
				carro.setNrMarchas(in.nextInt());
				System.out.println("Cambio (true/false): ");
				carro.setCambioCutomatico(in.nextBoolean());
				System.out.println("Teto solar (true/false): ");
				carro.setTetoSolar(in.nextBoolean());
				System.out.println("Velocidade Maxima: ");
				carro.setVelocidadeMaxima(in.nextInt());
				System.out.println("Volume de combustivel: ");
				carro.setVolumeDeCombustivel(in.nextDouble());
				carro.setMarca(maraca);
				carro.setProprietario(prop);
				System.out.println("Dados do proprietario\n");
				System.out.println(prop);
				System.out.println(carro + "\n");
				try {
					carro.entrar();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 2:
				Veiculo moto = new Moto();

				System.out.println("Numero do chassi: ");
				moto.setChassi(in.nextInt());
				System.out.println("Ano da Moto: ");
				moto.setAno(in.nextLine());
				System.out.println("Numero de portas: ");
				moto.setNrDePortas(in.nextInt());
				System.out.println("Numero de marchas: ");
				moto.setNrMarchas(in.nextInt());
				System.out.println("Cambio (true/false): ");
				moto.setCambioCutomatico(in.nextBoolean());
				System.out.println("Teto solar (true/false): ");
				moto.setTetoSolar(in.nextBoolean());
				System.out.println("Velocidade Maxima: ");
				moto.setVelocidadeMaxima(in.nextInt());
				System.out.println("Volume de combustivel: ");
				moto.setVolumeDeCombustivel(in.nextDouble());
				moto.setMarca(maraca);
				moto.setProprietario(prop);
				System.out.println("Dados do proprietario\n");
				System.out.println(prop);
				System.out.println(moto + "\n");
				try {
					moto.entrar();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

				break;
			default:
				break;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		

	} catch (Exception e) {
		e.getMessage();
	}
}
	
}
