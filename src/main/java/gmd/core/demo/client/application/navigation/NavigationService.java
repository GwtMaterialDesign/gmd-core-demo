package gmd.core.demo.client.application.navigation;

import gmd.core.demo.client.place.NameTokens;

import java.util.ArrayList;
import java.util.List;

public class NavigationService {

    private static List<Component> components = new ArrayList<>();

    static {
        components.add(new Component("Home", "", "/"));
        components.add(new Component(NameTokens.BADGE, "Badges can notify you that there are new or unread messages or notifications. A badge can be both a notifier that there are additional items associated with an object and an indicator of how many items there are."));
        components.add(new Component(NameTokens.BUTTON, "There are 3 main button types described in material design. The raised button is a standard button that signify actions and seek to give depth to a mostly flat page. The floating circular action button is meant for very important functions. Flat buttons are usually used within elements that already have depth like cards or dialogs."));
        components.add(new Component(NameTokens.BREADCRUMB, ""));
        components.add(new Component(NameTokens.CARDS, ""));
        components.add(new Component(NameTokens.CHECKBOX, ""));
        components.add(new Component(NameTokens.CHIPS, ""));
        components.add(new Component(NameTokens.COLLAPSIBLE, ""));
        components.add(new Component(NameTokens.COLLECTION, ""));
        components.add(new Component(NameTokens.DATE_PICKER, ""));
        components.add(new Component(NameTokens.DIALOGS, ""));
        components.add(new Component(NameTokens.DROPDOWN, ""));
        components.add(new Component(NameTokens.ERRORS, ""));
        components.add(new Component(NameTokens.FAB, ""));
        components.add(new Component(NameTokens.FOOTER, ""));
        components.add(new Component(NameTokens.LOADERS, ""));
        components.add(new Component(NameTokens.LISTBOX, ""));
        components.add(new Component(NameTokens.MEDIA, ""));
        components.add(new Component(NameTokens.NAVBAR, ""));
        components.add(new Component(NameTokens.PUSHPIN, ""));
        components.add(new Component(NameTokens.RADIO_BUTTON, ""));
        components.add(new Component(NameTokens.RANGE, ""));
        components.add(new Component(NameTokens.SEARCH, ""));
        components.add(new Component(NameTokens.SIDENAVS, ""));
        components.add(new Component(NameTokens.SCROLLSPY, ""));
        components.add(new Component(NameTokens.SWITCHES, ""));
        components.add(new Component(NameTokens.TABS, ""));
        components.add(new Component(NameTokens.TEXTFIELDS, ""));
    }

    public static List<Component> getSideNavLinks() {
        return components;
    }

    public static Component get(String href) {
        for (Component component : components) {
            if (component.getHref().equals(href)) {
                return component;
            }
        }
        return null;
    }
}
