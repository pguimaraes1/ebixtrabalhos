package entity;
//classe carro herdada de veiculo (carro eh um veiculo)
public class Carro extends Veiculo {
	
	//passa o tipo de veiculo
	private static String tipoVeiculo = "carro"; 
	
	public Carro(Pessoa pessoa, Marca marca) {
		super(pessoa, marca, tipoVeiculo);
	}

	public Carro() {
		this.tipoVeiculo = "carro";
	}
	
	

}
