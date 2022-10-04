package dados;

public class Cidade {
	private String nome;
	private String estado;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String toString() {
		return "Cidade [nome=" + nome + ", estado=" + estado + "]";
	}
}


