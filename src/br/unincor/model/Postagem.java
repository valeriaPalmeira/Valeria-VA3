package br.unincor.model;

public class Postagem {
	
	private Long id;
	private String titulo;
	private String categoria;
	private String usuario;
	private Long quantidade;
	
	
	public Postagem(Long id) {
		super();
		this.id = id;
	}

	public Postagem(Long id, String titulo, String categoria, String usuario, Long quantidade) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.categoria = categoria;
		this.usuario = usuario;
		if (quantidade >= 0)
			this.quantidade = quantidade;
		else
			this.quantidade = 0L;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Long quantidade) {
		if (quantidade >= 0)
			this.quantidade = quantidade;
		else
			this.quantidade = 0L;
	}

	@Override
	public String toString() {
		return "Postagem [id=" + id + ", titulo=" + titulo + ", categoria=" + categoria + ", usuario=" + usuario
				+ ", quantidade=" + quantidade + "]";
	}
	

}
