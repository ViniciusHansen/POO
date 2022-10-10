package dados;

public class ClientePremium extends Cliente{
	private float descontoBonus;
	
	public float getMensalidade() {
		float sum=0;
		for(Conta c : contas) {
			sum += c.getValor()-c.getDesconto()-descontoBonus;
		}
		return sum;
	}

	public float getDesconto() {
		return super.getDescontos() + descontoBonus;
	}
	
	public float getDescontoBonus() {
		return descontoBonus;
	}

	public void setDescontoBonus(float descontoBonus) {
		this.descontoBonus = descontoBonus;
	}

	@Override
	public String toString() {
		return "ClientePremium [descontoBonus=" + descontoBonus + "]";
	}
	
}
