package ro.lmn.gwt.dispatch.guice.server;

import net.customware.gwt.dispatch.server.guice.GuiceStandardDispatchServlet;

import com.google.inject.servlet.ServletModule;

/**
 * @author Robert Munteanu
 *
 */
public class DispatchServletModule extends ServletModule {

    @Override
    protected void configureServlets() {
    
        serve("/ro.lmn.gwt.GwtDispatch/dispatch").with(GuiceStandardDispatchServlet.class);
    }
}
