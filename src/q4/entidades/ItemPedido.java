package entidades;

public class ItemPedido {

	private String descricao;
	private Integer quantidade;
	private Double precoUnitario;

	public ItemPedido() {
	}

	public ItemPedido(String descricao, Integer quantidade, Double precoUnitario) {
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.precoUnitario = precoUnitario;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(Double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public double subtotal() {
		return quantidade * precoUnitario;
	}

	@Override
	public String toString() {
		return quantidade + " x " + descricao
				+ " - R$ " + String.format("%.2f", precoUnitario)
				+ " = R$ " + String.format("%.2f", subtotal());
	}
}
