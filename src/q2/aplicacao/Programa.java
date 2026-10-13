package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import entidades.Comentario;
import entidades.Postagem;

public class Programa {

	public static void main(String[] args) throws ParseException {

		Comentario c1 = new Comentario("Tenha uma boa viagem");
		Comentario c2 = new Comentario("Uau, que incrível!");
		Postagem p1 = new Postagem(LocalDateTime.parse("21/06/2018 13:05:44",
                    DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")), "Viajando para a Nova Zelândia",
				"Vou visitar esse país maravilhoso!", 12);
		p1.adicionarComentario(c1);
		p1.adicionarComentario(c2);

		Comentario c3 = new Comentario("Boa noite");
		Comentario c4 = new Comentario("Que a Força esteja com você");
		Postagem p2 = new Postagem(LocalDateTime.parse("28/07/2018 23:14:19",
                    DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")), "Boa noite, pessoal", "Até amanhã", 5);
		p2.adicionarComentario(c3);
		p2.adicionarComentario(c4);

		System.out.println(p1);
		System.out.println(p2);
	}
}
