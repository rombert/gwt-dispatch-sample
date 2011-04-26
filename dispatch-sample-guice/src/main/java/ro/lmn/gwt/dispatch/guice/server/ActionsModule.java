package ro.lmn.gwt.dispatch.guice.server;

import ro.lmn.gwt.dispatch.guice.shared.IncrementCounter;
import net.customware.gwt.dispatch.server.guice.ActionHandlerModule;


/**
 * @author Robert Munteanu
 *
 */
public class ActionsModule extends ActionHandlerModule {

    @Override
    protected void configureHandlers() {

        bindHandler(IncrementCounter.class, IncrementCounterHandler.class);
    }

}
