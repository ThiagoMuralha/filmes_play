package controllers;

import play.*;
import java.util.List;
import models.Diretor;
import play.mvc.*;
import views.html.*;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

	List<Diretor> diretores = Diretor.find.findList();
	
    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
        return ok(index.render("Your new application is ready."));
    }

    public Result sobre() {
    	return ok(views.html.sobre.render("Top 100 filmes Cult", 
    									  play.core.PlayVersion.current()));
    }
}
