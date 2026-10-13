package entidades;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entidades.enums.CategoriaMotorista;

public class Motorista {

	private String nome;
	private CategoriaMotorista categoria;
	private Double taxaPlataforma; // em porcentagem (ex.: 25.0 = 25%)

	// Associacao 1 para 1
	private Veiculo veiculo;
	// Associacao 1 para n (composicao)
	private List<Corrida> corridas = new ArrayList<>();

	public Motorista() {
	}

	public Motorista(String nome, CategoriaMotorista categoria, Double taxaPlataforma, Veiculo veiculo) {
		this.nome = nome;
		this.categoria = categoria;
		this.taxaPlataforma = taxaPlataforma;
		this.veiculo = veiculo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public CategoriaMotorista getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaMotorista categoria) {
		this.categoria = categoria;
	}

	public Double getTaxaPlataforma() {
		return taxaPlataforma;
	}

	public void setTaxaPlataforma(Double taxaPlataforma) {
		this.taxaPlataforma = taxaPlataforma;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public List<Corrida> getCorridas() {
		return corridas;
	}

	public void adicionarCorrida(Corrida corrida) {
		corridas.add(corrida);
	}

	public void removerCorrida(Corrida corrida) {
		corridas.remove(corrida);
	}

	public double ganho(int ano, int mes) {
		double soma = 0.0;
		for (Corrida c : corridas) {
			int anoCorrida = c.getData().getYear();
			int mesCorrida = c.getData().getMonthValue();
			if (anoCorrida == ano && mesCorrida == mes) {
				soma += c.valorTotal();
			}
		}
		return (1.0 - taxaPlataforma / 100.0) * soma;
	}
}
