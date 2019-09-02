package entity;

//classe abstrata veiculo
public abstract class Veiculo {

	public String tipoVeiculo;
	private String ano;
	private Integer chassi;
	private Integer velocidadeMaxima;
	private Integer velocidadeAtual = 0;
	private Integer nrDePortas;
	private boolean tetoSolar;
	private boolean cambioCutomatico;
	private Integer nrMarchas;
	private Double volumeDeCombustivel;
	private Pessoa pessoa;
	private Marca marca;
	private Integer marchaAtual = 0;

	// veiculo eh obrigatoriamente tem proprietario, marca e um tipo
	public Veiculo(Pessoa pessoa, Marca marca, String tipoVeiculo) {
		this.pessoa = pessoa;
		this.marca = marca;
		// cast de pessoa para proprietario, para poder usar polimorfismo Ex.: Pessoa p
		// = new Proprietario(..,..,..);
		((Proprietario) this.pessoa).adicionarVeiculo(this);// ao criar um veiculo relaciona o veiculo a uma pessoa
		marca.adicionarVeiculo(this); // ao criar um veiculo relaciona o veiculo a uma marca
		this.tipoVeiculo = tipoVeiculo;
	}

	public Veiculo() {

	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) throws Exception {
		if(ano.isEmpty() || ano.length() > 4)
			throw new Exception("Ano inválido");
		this.ano = ano;
	}

	public Integer getChassi() {
		return chassi;
	}

	public void setChassi(Integer chassi) throws Exception {
		 this.chassi = chassi;
	}

	public Integer getVelocidadeMaxima() {
		return velocidadeMaxima;
	}

	public void setVelocidadeMaxima(Integer velocidadeMaxima) {
		this.velocidadeMaxima = velocidadeMaxima;
	}

	public Integer getVelocidadeAtual() {
		return velocidadeAtual;
	}

	public void setVelocidadeAtual(Integer velocidadeAtual) {
		this.velocidadeAtual = velocidadeAtual;
	}

	public Integer getNrDePortas() {
		return nrDePortas;
	}

	public void setNrDePortas(Integer nrDePortas) throws Exception {
		if(nrDePortas < 2 || nrDePortas > 4)
			throw new Exception("numero de portas invalido");
		this.nrDePortas = nrDePortas;
	}

	public String isTetoSolar() {
		return (this.tetoSolar) ? "Tem teto solar" : "Nao tem teto solar";
	}

	public void setTetoSolar(boolean tetoSolar) {
		this.tetoSolar = tetoSolar;
	}

	public String isCambioCutomatico() {
		return (this.cambioCutomatico) ? "Tem cambio automatico" : "Cambio manual";
	}

	public void setCambioCutomatico(boolean cambioCutomatico) {
		this.cambioCutomatico = cambioCutomatico;
	}

	public Integer getNrMarchas() {
		return nrMarchas;
	}

	public void setNrMarchas(Integer nrMarchas) {
		this.nrMarchas = nrMarchas;
	}

	public Double getVolumeDeCombustivel() {
		return volumeDeCombustivel;
	}

	public void setVolumeDeCombustivel(Double volumeDeCombustivel) {
		this.volumeDeCombustivel = volumeDeCombustivel;
	}

	public Pessoa getProprietario() {
		return pessoa;
	}

	public void setProprietario(Pessoa proprietario) {
		this.pessoa = proprietario;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public String getTipoVeiculo() {
		return (this.tipoVeiculo != null) ? this.tipoVeiculo : null;
	}

	public void setTipoVeiculo(String tipoVeiculo) {
		this.tipoVeiculo = tipoVeiculo;
	}

	public Integer getMarchaAtual() {
		return marchaAtual;
	}

	public void setMarchaAtual(Integer marchaAtual) {
		this.marchaAtual = marchaAtual;
	}

	public void passaMarcha() throws Exception {
		this.marchaAtual = 0;
		if(this.marchaAtual == this.nrMarchas)
			throw new Exception("Marcha maxima, nao é possivel passar!");
		this.marchaAtual++;
	}

	public void reduzMarcha() {

		if (this.marchaAtual == 1 && this.velocidadeAtual == 0) {
			this.marchaAtual--;
			System.out.println("ponto morto");
		} else if (this.marchaAtual <= -1 && this.velocidadeAtual <= 0) {
			System.out.println("Nao da pra reduzir marcha");
		} else if (this.marchaAtual == -1 && this.velocidadeAtual <= 0) {
			System.out.println("Re engatada!");
		} else if (this.velocidadeAtual > 0) {
			System.out.println("Nao da para passar a Re");
		} else if (this.velocidadeAtual >= 0 && this.marchaAtual >= 0) {
			this.marchaAtual--;
		}

	}

	// metodo freia
	public String stop(Veiculo veiculo) {
		try {
			veiculo.setVelocidadeAtual(0);
			return "parou";
		} catch (Exception e) {
			throw new IllegalArgumentException("bateu");
		}
	}

	// acelera de 1 em 1 (incrementa)
	public Integer acelera() throws Exception {
		if(this.getVelocidadeAtual() == this.getVelocidadeMaxima())
			throw new Exception("Velocidade máxima atingida");
		this.velocidadeAtual++;
		return this.getVelocidadeAtual();
	}

	public void entrar() throws Exception {
		System.out.println("Cadastrado! Passagem liberada");
		for (Integer i = 0; i <= 39; i++) {
			System.out.println("Acelerando");
			this.acelera();
			System.out.println(this.velocidadeAtual);
		}
	}

	@Override
	public String toString() {
		return "\n\nVeiculo\nTipo do Veiculo: " + tipoVeiculo + "\nChassi: " + chassi + "\nVelocidade Maxima: "
				+ velocidadeMaxima + "\nNumero de Portas: " + nrDePortas + "\ntetoSolar: " + tetoSolar
				+ "\nCambio Automatico: " + cambioCutomatico + "\nNumero de Marchas: " + nrMarchas
				+ "\nVolume de Combustivel: " + volumeDeCombustivel + marca;
	}

}
