package controllers;

import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import java.util.List;
import models.Diretor;
import javax.inject.Inject;

public class DiretorCRUD extends Controller {
	
	@Inject
	FormFactory formFactory;
	
	public Result lista() {
		List<Diretor> diretores = Diretor.find.findList();
		return ok(views.html.diretor.render(diretores)); 
	}
	
	
	
	public Result detalhar(Long id) {
		Form<Diretor> dirForm = formFactory.form(Diretor.class).fill(Diretor.find.byId(id));
		return ok(views.html.alterarDiretor.render(id, dirForm));
	}
	
	
	
	public Result alterar(Long id) {
		Form<Diretor> atualForm = formFactory.form(Diretor.class).fill(Diretor.find.byId(id));		
		Form<Diretor> alterarForm = formFactory.form(Diretor.class).bindFromRequest();
		if(alterarForm.hasErrors()) {
			return badRequest(views.html.alterarDiretor.render(id, alterarForm));
		}
		
		atualForm.get().setNome(alterarForm.get().getNome());
		atualForm.get().update();
		flash("sucesso", "Diretor " + atualForm.get().getNome() + " e id " + atualForm.get().getId() + " alterado com sucesso!");
		return redirect(routes.DiretorCRUD.lista());
	}
	
	
	
	public Result remover(Long id) {
		String nomeDiretor = Diretor.find.byId(id).getNome();
		Diretor.find.ref(id).delete();
		flash("sucesso", "Diretor " + nomeDiretor + " removido com sucesso");
		return lista();
	}
	
	
	
	public Result novoDiretor() {
		if(formFactory.form(Diretor.class) != null)
			System.out.println("O fera não ta nulo");
		else
			System.out.println("Tá nulo sim");
		return ok(views.html.novoDiretor.render(formFactory.form(Diretor.class)));
	}
	
	
	
	public Result gravar() {
		Form<Diretor> form = formFactory.form(Diretor.class).bindFromRequest();
		
		if (form.bindFromRequest().hasErrors()) {
			flash("erro","Foram identificados problemas no cadastro!");
			return ok(views.html.novoDiretor.render(formFactory.form(Diretor.class)));
		}
		else {
			form.get().save();
			flash("sucesso", "Registro gravado com sucesso!");
			return redirect(routes.DiretorCRUD.lista());
		}
	}
}