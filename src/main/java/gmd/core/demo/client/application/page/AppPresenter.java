package gmd.core.demo.client.application.page;

import com.google.gwt.event.shared.GwtEvent;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;
import gmd.core.demo.client.application.ApplicationView;
import gmd.core.demo.client.application.navigation.Component;
import gmd.core.demo.client.application.navigation.NavigationService;

public class AppPresenter<V extends View, P extends Proxy<?>> extends Presenter<V, P> {

    private PlaceManager placeManager;

    public AppPresenter(EventBus eventBus, V view, P proxy, GwtEvent.Type<RevealContentHandler<?>> slot, PlaceManager placeManager) {
        super(eventBus, view, proxy, slot);

        this.placeManager = placeManager;
    }


    @Override
    protected void onReveal() {
        super.onReveal();

        Component component = NavigationService.get(placeManager.getCurrentPlaceRequest().getNameToken());

        if (component != null) {
            ApplicationView.setComponent(component);
        }
    }
}
