package gmd.core.demo.client.application.navigation;

import gmd.core.demo.client.place.NameTokens;

import java.util.ArrayList;
import java.util.List;

public class NavigationService {

    private static List<Component> components = new ArrayList<>();

    static {
        components.add(new Component(NameTokens.BADGE, "Badges can notify you that there are new or unread messages or notifications. A badge can be both a notifier that there are additional items associated with an object and an indicator of how many items there are."));
        components.add(new Component(NameTokens.BUTTON, "There are 3 main button types described in material design. The raised button is a standard button that signify actions and seek to give depth to a mostly flat page. The floating circular action button is meant for very important functions. Flat buttons are usually used within elements that already have depth like cards or dialogs."));
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
