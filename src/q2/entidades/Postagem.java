package entidades;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Postagem {

	private LocalDateTime momento;
	private String titulo;
	private String conteudo;
	private Integer curtidas;

	// Associacao 1 para n (composicao)
	private List<Comentario> comentarios = new ArrayList<>();

	public Postagem() {
	}

	public Postagem(LocalDateTime momento, String titulo, String conteudo, Integer curtidas) {
		this.momento = momento;
		this.titulo = titulo;
		this.conteudo = conteudo;
		this.curtidas = curtidas;
	}

	public LocalDateTime getMomento() {
		return momento;
	}

	public void setMomento(LocalDateTime momento) {
		this.momento = momento;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public Integer getCurtidas() {
		return curtidas;
	}

	public void setCurtidas(Integer curtidas) {
		this.curtidas = curtidas;
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void adicionarComentario(Comentario comentario) {
		comentarios.add(comentario);
	}

	public void removerComentario(Comentario comentario) {
		comentarios.remove(comentario);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(titulo + "\n");
		sb.append(curtidas);
		sb.append(" Curtidas - ");
		sb.append(momento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) + "\n");
		sb.append(conteudo + "\n");
		sb.append("Comentários:\n");
		for (Comentario c : comentarios) {
			sb.append(c.getTexto() + "\n");
		}
		return sb.toString();
	}
}
