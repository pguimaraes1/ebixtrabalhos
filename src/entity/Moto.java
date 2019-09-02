package entity;

//classe moto herda de veiculo, moto eh um veiculo (herance, reutilizacao de codigo)
public class Moto extends Veiculo {
	private static String tipoVeiculo = "moto";

	public Moto(Pessoa pessoa, Marca marca) {
		super(pessoa, marca, tipoVeiculo);

	}

	public Moto() {
		super();
		this.tipoVeiculo = "carro";
	}

}
