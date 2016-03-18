package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.diretor;
import models.Diretor;
import java.util.List;

public class DiretorCRUD extends Controller {
	List<Diretor> diretores;
	
	
	public Result lista() {
		diretores = Diretor.find.findList();
		for(Diretor diretor : diretores) {
			System.out.println(diretor.id + " " + diretor.nome);
		}
		return ok(views.html.diretor.render()); 
	}
	
	public Result novoDiretor() {
		return TODO;
	}
}