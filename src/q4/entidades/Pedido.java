package entidades;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.List;

public class Pedido {

	private LocalDateTime momento;
	private String cliente;
	private String endereco;

	// Associacao 1 para n (composicao)
	private List<ItemPedido> itens = new ArrayList<>();

	public Pedido() {
	}

	public Pedido(LocalDateTime momento, String cliente, String endereco) {
		this.momento = momento;
		this.cliente = cliente;
		this.endereco = endereco;
	}

	public LocalDateTime getMomento() {
		return momento;
	}

	public void setMomento(LocalDateTime momento) {
		this.momento = momento;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public List<ItemPedido> getItens() {
		return itens;
	}

	public void adicionarItem(ItemPedido item) {
		itens.add(item);
	}

	public void removerItem(ItemPedido item) {
		itens.remove(item);
	}

	public double total() {
		double soma = 0.0;
		for (ItemPedido item : itens) {
			soma += item.subtotal();
		}
		return soma;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Pedido de " + cliente + "\n");
		sb.append("Realizado em " + momento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) + "\n");
		sb.append("Entrega: " + endereco + "\n");
		sb.append("Itens:\n");
		for (ItemPedido item : itens) {
			sb.append(item + "\n");
		}
		sb.append("Total: R$ " + String.format("%.2f", total()));
		return sb.toString();
	}
}
