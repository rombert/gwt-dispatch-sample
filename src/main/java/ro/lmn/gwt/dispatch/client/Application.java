package ro.lmn.gwt.dispatch.client;

import net.customware.gwt.dispatch.client.DefaultExceptionHandler;
import net.customware.gwt.dispatch.client.DispatchAsync;
import net.customware.gwt.dispatch.client.standard.StandardDispatchAsync;
import ro.lmn.gwt.dispatch.shared.IncrementCounter;
import ro.lmn.gwt.dispatch.shared.IncrementCounterResult;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Application implements EntryPoint {

    private final DispatchAsync dispatch = new StandardDispatchAsync(new DefaultExceptionHandler());
    
    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {

        VerticalPanel all = new VerticalPanel();
        all.add(new HTML("<h1>GWT-dispatch demo</h1>"));
        
        final Label resultLabel = new Label("No results yet");
        resultLabel.addStyleName("counterResult");
        
        Button incrementButton = new Button("Increment");
        incrementButton.addClickHandler(new ClickHandler() {
            
            public void onClick(ClickEvent event) {
        
                resultLabel.setText("Processing...");
                
                dispatch.execute(new IncrementCounter(1), new AsyncCallback<IncrementCounterResult>() {

                    public void onFailure(Throwable caught) {

                        resultLabel.setText("Processing error : " + caught.getMessage() + " .");
                        
                    }

                    public void onSuccess(IncrementCounterResult result) {

                        resultLabel.setText("Counter value is now " + result.getCurrent() +  " .");
                        
                    }
                });
                
            }
        });

        FlowPanel panel = new FlowPanel();

        panel.add(incrementButton);
        panel.add(resultLabel);
        
        all.add(panel);

        RootPanel.get().add(all);
    }
}
