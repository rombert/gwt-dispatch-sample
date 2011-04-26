package ro.lmn.gwt.dispatch.guice.server;

import net.customware.gwt.dispatch.server.ActionHandler;
import net.customware.gwt.dispatch.server.ExecutionContext;
import net.customware.gwt.dispatch.shared.ActionException;
import ro.lmn.gwt.dispatch.guice.shared.IncrementCounter;
import ro.lmn.gwt.dispatch.guice.shared.IncrementCounterResult;

public class IncrementCounterHandler implements ActionHandler<IncrementCounter, IncrementCounterResult> {

    private int current = 0;

    public Class<IncrementCounter> getActionType() {
        return IncrementCounter.class;
    }

    public synchronized IncrementCounterResult execute( IncrementCounter action, ExecutionContext context ) throws ActionException {
        current += action.getAmount();
        return new IncrementCounterResult( action.getAmount(), current );
    }

    public synchronized void rollback( IncrementCounter action, IncrementCounterResult result, ExecutionContext context ) throws ActionException {
        // Reset to the previous value.
        current = result.getCurrent() - result.getAmount();
    }
}