package entity;

public class Endereco {
	private Integer idEndereco;
	private String rua;
	private String bairro;
	private String cidade;
	private String estado;
	private String cep;
	private String complemento;
	private Pessoa proprietario;

	public Endereco(String rua, String bairro, String cidade, String estado, String cep, String complemento) {
		this.rua = rua;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
		this.complemento = complemento;
	}

	public Endereco() {

	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) throws Exception {
		if(rua.isEmpty() || rua.length() < 4)
			throw new Exception("Rua inválida");
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) throws Exception {
		if(bairro.isEmpty() || bairro.length() < 4)
			throw new Exception("Bairro inválido");
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) throws Exception {
		if(cidade.isEmpty() || cidade.length() < 3)
			throw new Exception("Cidade inválida");
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) throws Exception {
		if(estado.isEmpty() || estado.length() < 2)
			throw new Exception("Estado inválido");
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) throws Exception {
		if(cep.isEmpty() || cep.length() < 8)
			throw new Exception("Cidade inválida");
		this.cep = cep;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public Integer getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(Integer idEndereco) {

		this.idEndereco = idEndereco;
	}

	public Pessoa getProprietario() {
		return proprietario;
	}

	public void setProprietario(Pessoa proprietario) {
		this.proprietario = proprietario;
	}

	@Override
	public String toString() {
		return "\nEndereco Proprietario" + "\nID:" + idEndereco + "\nRua:" + rua + "\nBairro:" + bairro + "\nCidade: " + cidade
				+ "\nEstado: " + estado + "\nCEP: " + cep + "\nComplemento: " + complemento;
	}

}
