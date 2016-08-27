package br.com.app.web.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Esse Session Listener é interessante para saber quando a Sessão foi criada ou fechada para um certo usuário
 * @author pazin
 *
 */
public class SessionListener implements HttpSessionListener {

	public void sessionCreated( HttpSessionEvent event )
	{
//		System.out.println("==== Session is created ====");
        event.getSession().setMaxInactiveInterval(30*60);
	}

	public void sessionDestroyed( HttpSessionEvent event )
	{
//		System.out.println("==== Session is destroyed ====");
	}

}
