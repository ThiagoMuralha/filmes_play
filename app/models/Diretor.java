package models;

import javax.persistence.*;
import play.data.validation.Constraints;
import play.db.ebean.Model;
import play.data.validation.Constraints;

@Entity
public class Diretor extends Model {
	
	private static final long serialVersionUID = 1l;

	public static Finder<Long, Diretor> find = new Finder<Long, Diretor>(Diretor.class);

	@Id
	private Long id;
	@Constraints.Required
	private String nome;
	
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

	public String toString() {
		return "nome = " + this.nome + " e ID = " + this.id;
	}
}