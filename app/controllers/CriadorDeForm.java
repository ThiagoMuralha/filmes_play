package controllers;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.executable.ExecutableValidator;
import javax.validation.metadata.BeanDescriptor;
import play.data.FormFactory;
import play.data.format.Formatters;
import play.i18n.MessagesApi;

// validador que o construtor da FormFactory precisa
class Validador implements Validator {

	@Override
	public ExecutableValidator forExecutables() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BeanDescriptor getConstraintsForClass(Class<?> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T unwrap(Class<T> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> Set<ConstraintViolation<T>> validate(T arg0, Class<?>... arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> Set<ConstraintViolation<T>> validateProperty(T arg0, String arg1, Class<?>... arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> Set<ConstraintViolation<T>> validateValue(Class<T> arg0, String arg1, Object arg2, Class<?>... arg3) {
		// TODO Auto-generated method stub
		return null;
	}
}

public class CriadorDeForm {

	MessagesApi msgAPI;
	Formatters formatador;
	Validador validador;
	FormFactory factory;
	
	public CriadorDeForm() {
		msgAPI = new MessagesApi(null);
		formatador = new Formatters(msgAPI);
		validador = new Validador();
		factory = new FormFactory(msgAPI, formatador, validador);
	}

	
	// getters e setters
	public MessagesApi getmsgAPI() {
		return msgAPI;
	}
	public void setmsgAPI(MessagesApi msgAPI) {
		this.msgAPI = msgAPI;
	}
	public Formatters getFormatador() {
		return formatador;
	}
	public void setFormatador(Formatters formatador) {
		this.formatador = formatador;
	}
	public Validador getValidador() {
		return validador;
	}
	public void setValidador(Validador validador) {
		this.validador = validador;
	}
	public FormFactory getFactory() {
		return factory;
	}
	public void setFactory(FormFactory factory) {
		this.factory = factory;
	}
}
