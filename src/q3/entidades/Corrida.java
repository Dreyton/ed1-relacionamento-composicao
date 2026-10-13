package entidades;

import java.time.LocalDate;

public class Corrida {

	private LocalDate data;
	private Double distancia;
	private Double valorPorKm;

	public Corrida() {
	}

	public Corrida(LocalDate data, Double distancia, Double valorPorKm) {
		this.data = data;
		this.distancia = distancia;
		this.valorPorKm = valorPorKm;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Double getDistancia() {
		return distancia;
	}

	public void setDistancia(Double distancia) {
		this.distancia = distancia;
	}

	public Double getValorPorKm() {
		return valorPorKm;
	}

	public void setValorPorKm(Double valorPorKm) {
		this.valorPorKm = valorPorKm;
	}

	public double valorTotal() {
		return distancia * valorPorKm;
	}
}
