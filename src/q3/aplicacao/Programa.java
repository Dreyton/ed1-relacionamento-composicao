package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entidades.Corrida;
import entidades.Motorista;
import entidades.Veiculo;
import entidades.enums.CategoriaMotorista;

public class Programa {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Digite os dados do veículo:");
		System.out.print("Placa: ");
		String placa = sc.nextLine();
		System.out.print("Modelo: ");
		String modelo = sc.nextLine();

		System.out.println("Digite os dados do motorista:");
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		System.out.print("Categoria: ");
		String categoria = sc.nextLine();
		System.out.print("Taxa da plataforma (%): ");
		double taxa = sc.nextDouble();sc.nextLine();

		Motorista motorista = new Motorista(nome, CategoriaMotorista.valueOf(categoria), taxa,
				new Veiculo(placa, modelo));

		System.out.print("Quantas corridas para este motorista? ");
		int n = sc.nextInt();sc.nextLine();

		for (int i = 1; i <= n; i++) {
			System.out.println("Digite os dados da corrida #" + i + ":");
			System.out.print("Data (DD/MM/AAAA): ");
			LocalDate data = LocalDate.parse(sc.nextLine(),
                    DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			System.out.print("Distância (km): ");
			double distancia = sc.nextDouble();sc.nextLine();
			System.out.print("Valor por km: ");
			double valorPorKm = sc.nextDouble();sc.nextLine();
			motorista.adicionarCorrida(new Corrida(data, distancia, valorPorKm));
		}

		System.out.println();
		System.out.print("Digite o mês e o ano para calcular o ganho (MM/AAAA): ");
		String mesEAno = sc.next();
		int mes = Integer.parseInt(mesEAno.substring(0, 2));
		int ano = Integer.parseInt(mesEAno.substring(3));

		Veiculo v = motorista.getVeiculo();
		System.out.println("Nome: " + motorista.getNome());
		System.out.println("Veículo: " + v.getModelo() + " (" + v.getPlaca() + ")");
		System.out.println("Ganho em " + mesEAno + ": " + String.format("%.2f", motorista.ganho(ano, mes)));

		sc.close();
	}
}
