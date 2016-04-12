package models;

import java.util.List;

import javax.persistence.*;
import play.data.validation.Constraints;
import com.avaje.ebean.Model;

@Entity
public class Diretor extends Model {
	
	private static final long serialVersionUID = 1l;

	public static Finder<Long, Diretor> find = new Finder<Long, Diretor>(Diretor.class);

	@Id
	private Long id;
	@Constraints.Required
	private String nome;
	@OneToMany(mappedBy="diretor")
	private List<Filme> filmes;
	
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
	public List<Filme> getFilmes() {
		return filmes;
	}

	public String toString() {
		return "nome = " + this.nome + " e ID = " + this.id;
	}
}