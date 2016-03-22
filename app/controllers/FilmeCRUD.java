package controllers;

import models.Filme;
import models.Diretor;
import java.util.List;

import javax.inject.Inject;

import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

public class FilmeCRUD extends Controller {
	
	@Inject
	FormFactory formFactory;
	
	public Result lista() {
		List<Filme> filmes = Filme.find.where().orderBy("ano").findList();
		return ok(views.html.filme.render(filmes));
	}
}
