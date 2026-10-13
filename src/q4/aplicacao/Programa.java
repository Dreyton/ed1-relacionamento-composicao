package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import entidades.ItemPedido;
import entidades.Pedido;

public class Programa {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);

		Pedido p1 = new Pedido(
                LocalDateTime.parse("15/09/2026 12:30:10",
                        DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")),
                "Maria Souza", "Rua das Mangueiras, 120");
		p1.adicionarItem(new ItemPedido("Tacacá", 2, 18.00));
		p1.adicionarItem(new ItemPedido("Suco de cupuaçu", 1, 9.50));

		Pedido p2 = new Pedido(
                LocalDateTime.parse("15/09/2026 19:45:02",
                        DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")),
                "João Pereira", "Travessa Belém, 45");
		p2.adicionarItem(new ItemPedido("Pato no tucupi", 1, 42.00));
		p2.adicionarItem(new ItemPedido("Açaí com farinha", 2, 15.00));
		p2.adicionarItem(new ItemPedido("Água mineral", 1, 3.50));

		System.out.println(p1);
		System.out.println();
		System.out.println(p2);
	}
}
