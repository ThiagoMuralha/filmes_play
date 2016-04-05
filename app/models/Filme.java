package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import com.avaje.ebean.Model;

@Entity
public class Filme extends Model {

	private static final long serialVersionUID = 1l;
	
	public static Finder<Long, Filme> find = new Finder<Long, Filme>(Filme.class);
	
	@Id
	private Long id;
	@Column
	private String nome;
	@Column
	private String tipo;
	@Column
	private Double nota;
	@Column
	private Integer duracao;
	@Column
	private Integer ano;
	@Column
	private String genero;
	@Column
	private Integer votos;
	@Column
	private String url;
	@ManyToOne	
	private Diretor diretor;
	
	// getters e setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Double getNota() {
		return nota;
	}
	public void setNota(Double nota) {
		this.nota = nota;
	}
	public Integer getDuracao() {
		return duracao;
	}
	public void setDuracao(Integer duracao) {
		this.duracao = duracao;
	}
	public Integer getAno() {
		return ano;
	}
	public void setAno(Integer ano) {
		this.ano = ano;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public Integer getVotos() {
		return votos;
	}
	public void setVotos(Integer votos) {
		this.votos = votos;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Diretor getDiretor() {
		return diretor;
	}
	public void setDiretor(Diretor diretor) {
		this.diretor = diretor;
	}
	
	
	public String toString() {
		return this.nome;
	}
	public boolean equals(Object o) {
		Filme filme = (Filme) o;
		
		if(filme.nome == this.nome && filme.diretor.getNome() == this.diretor.getNome())
			return true;
		else
			return false;
	}
}
