package gmd.core.demo.client.application.page;

import com.google.gwt.dom.client.Style;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;
import gmd.core.demo.client.application.ApplicationView;
import gmd.core.demo.client.application.navigation.Component;
import gmd.core.demo.client.application.navigation.NavigationService;
import gmd.core.demo.client.application.widget.CodeSection;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.constants.HideOn;
import gwt.material.design.client.ui.MaterialLink;
import gwt.material.design.client.ui.MaterialPushpin;
import gwt.material.design.client.ui.MaterialScrollspy;
import gwt.material.design.client.ui.MaterialToast;

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

        ApplicationView.showHeader(true);

        createTableOfContents();
    }

    protected void createTableOfContents() {
        if (getView().asWidget() instanceof MaterialWidget) {

            MaterialWidget widget = (MaterialWidget) getView().asWidget();
            widget.setGrid("s12 l9");
            widget.setFloat(Style.Float.LEFT);

            MaterialScrollspy scrollspy = new MaterialScrollspy();
            scrollspy.setGrid("s12 l3");
            scrollspy.setRight(0);
            scrollspy.setHideOn(HideOn.HIDE_ON_MED_DOWN);

            MaterialPushpin pushpin = new MaterialPushpin();
            pushpin.setWidget(scrollspy);
            pushpin.setOffset(64.0);
            pushpin.setTop(320.0);
            pushpin.apply();

            for (Widget w : widget) {
                if (w instanceof CodeSection) {
                    String name = ((CodeSection) w).getSectionTitle();
                    MaterialLink link = new MaterialLink(name);
                    link.setHref("#" + ((CodeSection) w).getScrollspy());
                    scrollspy.add(link);
                }
            }

            if (widget.getParent() != null && widget.getParent() instanceof MaterialWidget) {
                ((MaterialWidget) widget.getParent()).add(scrollspy);
            } else {
                widget.add(scrollspy);
            }
        }
    }
}
