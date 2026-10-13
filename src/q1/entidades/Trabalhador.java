package entidades;

import java.util.ArrayList;
import java.util.List;

import entidades.enums.NivelTrabalhador;

public class Trabalhador {

	private String nome;
	private NivelTrabalhador nivel;
	private Double salarioBase;

	// Associacao 1 para 1
	private Departamento departamento;
	// Associacao 1 para n (composicao): a lista e criada junto com o objeto
	private List<ContratoHora> contratos;

	public Trabalhador() {
        this.contratos = new ArrayList<>();
	}

	// A lista de contratos nao entra no construtor: ela comeca vazia
	public Trabalhador(String nome, NivelTrabalhador nivel, Double salarioBase, Departamento departamento) {
		this.nome = nome;
		this.nivel = nivel;
		this.salarioBase = salarioBase;
		this.departamento = departamento;
        this.contratos = new ArrayList<>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public NivelTrabalhador getNivel() {
		return nivel;
	}

	public void setNivel(NivelTrabalhador nivel) {
		this.nivel = nivel;
	}

	public Double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	// Sem setContratos: a lista so e alterada por adicionar/remover
	public List<ContratoHora> getContratos() {
		return contratos;
	}

	public void adicionarContrato(ContratoHora contrato) {
		contratos.add(contrato);
	}

	public void removerContrato(ContratoHora contrato) {
		contratos.remove(contrato);
	}

	public double renda(int ano, int mes) {
		double soma = salarioBase;
		for (ContratoHora contrato : contratos) {
			int anoContrato = contrato.getData().getYear();
			int mesContrato = contrato.getData().getMonthValue();
			if (anoContrato == ano && mesContrato == mes) {
				soma += contrato.valorTotal();
			}
		}
		return soma;
	}
}
