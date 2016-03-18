package models;

import javax.persistence.*;
import play.data.validation.Constraints;
import com.avaje.ebean.Model;

@Entity
public class Diretor extends Model {
	
	private static final long serialVersionUID = 1l;

	@Id
	public Long id;

	@Constraints.Required
	public String nome;

	public static Model.Finder<Long, Diretor> find = new Model.Finder<Long, Diretor>(Long.class, Diretor.class);
}