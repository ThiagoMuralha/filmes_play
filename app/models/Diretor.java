package models;

import javax.persistence.*;
import play.validation.Constraints;
import play.db.ebean.Model;

@Entity
public class Diretor extends Model {

	private static final long serialVersionUID = 1l;

	@id
	@GeneratedValue
	public Long id;

	@Constraints.Required
	public String nome;

	public static Model.Finder<Long, Diretor> find = new Model.Finder<Long, Diretor>(Long.class, Diretor.class);
}