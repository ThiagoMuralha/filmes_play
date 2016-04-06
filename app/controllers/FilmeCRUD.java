package controllers;

import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import java.util.List;
import models.Filme;
import javax.inject.Inject;

public class FilmeCRUD extends Controller {
	
	@Inject
	FormFactory formFactory;
	
	public Result lista() {
		List<Filme> filmes = Filme.find.where().orderBy("ano").findList();
		if(filmes.isEmpty())
			System.out.println("Tá vazio");
		else
			System.out.println("Não tá vazio");
		System.out.println("vai retornar");
		System.out.println(filmes.isEmpty());
		return ok(views.html.filme.render(filmes));
	}
	
	
	
	public Result detalhar(Long id) {
		Form<Filme> filmeForm = formFactory.form(Filme.class).fill(Filme.find.byId(id));
		return ok(views.html.alterarFilme.render(id, filmeForm));
	}
	
	
	
	 public Result alterar(Long id) {
		Form<Filme> atualForm = formFactory.form(Filme.class).fill(Filme.find.byId(id));		
		Form<Filme> alterarForm = formFactory.form(Filme.class).bindFromRequest();
		if(alterarForm.hasErrors()) {
			return badRequest(views.html.alterarFilme.render(id, alterarForm));
		}
		atualForm.get().setNome(alterarForm.get().getNome());
		atualForm.get().update();
		flash("sucesso", "Filme " + atualForm.get().getNome() + " e id " + atualForm.get().getId() + " alterado com sucesso!");
		return redirect(routes.FilmeCRUD.lista());
	}
	
	
	
	public Result remover(Long id) {
		String nomeFilme = Filme.find.byId(id).getNome();
		Filme.find.ref(id).delete();
		flash("sucesso", "File " + nomeFilme + " removido com sucesso");
		return lista();
	}
	
	
	
	public Result novoFilme() {
		if(formFactory.form(Filme.class) != null)
			System.out.println("O fera não ta nulo");
		else
			System.out.println("Tá nulo sim");
		return ok(views.html.novoFilme.render(formFactory.form(Filme.class)));
	}
	
	
	
	public Result gravar() {
		Form<Filme> form = formFactory.form(Filme.class).bindFromRequest();
		if(form.bindFromRequest().hasErrors()) {
			flash("erro","Foram identificados problemas no cadastro!");
			return ok(views.html.novoFilme.render(formFactory.form(Filme.class)));
		}
		else {
			form.get().save();
			flash("sucesso", "Registro gravado com sucesso!");
			return redirect(routes.FilmeCRUD.lista());
		}
	}
}
