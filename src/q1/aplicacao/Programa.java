package aplicacao;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entidades.ContratoHora;
import entidades.Departamento;
import entidades.Trabalhador;
import entidades.enums.NivelTrabalhador;

public class Programa {

	public static void main(String[] args){

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Digite o nome do departamento: ");
		String nomeDepartamento = sc.nextLine();
		System.out.println("Digite os dados do trabalhador:");
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		System.out.print("Nível: ");
		String nivel = sc.nextLine();
		System.out.print("Salário base: ");
		double salarioBase = sc.nextDouble();

		Trabalhador trabalhador = new Trabalhador(nome, NivelTrabalhador.valueOf(nivel), salarioBase,
				new Departamento(nomeDepartamento));

		System.out.print("Quantos contratos para este trabalhador? ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Digite os dados do contrato #" + i + ":");
            sc.nextLine();
            System.out.print("Data (DD/MM/AAAA): ");
            LocalDate data = LocalDate.parse(sc.nextLine(),
                    DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			System.out.print("Valor por hora: ");
			double valorPorHora = sc.nextDouble();
			System.out.print("Duração (horas): ");
			int horas = sc.nextInt();
			ContratoHora contrato = new ContratoHora(data, valorPorHora, horas);
			trabalhador.adicionarContrato(contrato);
		}

        sc.nextLine();
		System.out.println();
		System.out.print("Digite o mês e o ano para calcular a renda (MM/AAAA): ");
		String mesEAno = sc.nextLine();
        YearMonth dataRenda =  YearMonth.parse(mesEAno, DateTimeFormatter.ofPattern("MM/yyyy"));

		System.out.println("Nome: " + trabalhador.getNome());
		System.out.println("Departamento: " + trabalhador.getDepartamento().getNome());
		System.out.println("Renda em " + mesEAno + ": " +
                String.format("%.2f", trabalhador.renda(dataRenda.getYear(), dataRenda.getMonthValue())));

		sc.close();
	}
}
