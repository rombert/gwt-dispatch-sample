package ro.lmn.gwt.dispatch.guice.server;

import net.customware.gwt.dispatch.server.guice.ServerDispatchModule;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;

/**
 * @author Robert Munteanu
 * 
 */
public class BootstrapListener extends GuiceServletContextListener {

    @Override
    protected Injector getInjector() {

        return Guice.createInjector(new ServerDispatchModule(), new ActionsModule(), new DispatchServletModule());
    }

}
