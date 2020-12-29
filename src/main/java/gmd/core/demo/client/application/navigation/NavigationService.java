package gmd.core.demo.client.application.navigation;

import gmd.core.demo.client.place.NameTokens;

import java.util.ArrayList;
import java.util.List;

public class NavigationService {

    private static List<Component> components = new ArrayList<>();

    static {
        components.add(new Component("Get Started", "", "/"));
        components.add(new Component(NameTokens.ANIMATION, "We used AnimateCSS to built our core animations."));
        components.add(new Component(NameTokens.BADGE, "Badges can notify you that there are new or unread messages or notifications. A badge can be both a notifier that there are additional items associated with an object and an indicator of how many items there are."));
        components.add(new Component(NameTokens.BUTTON, "There are 3 main button types described in material design. The raised button is a standard button that signify actions and seek to give depth to a mostly flat page. The floating circular action button is meant for very important functions. Flat buttons are usually used within elements that already have depth like cards or dialogs."));
        components.add(new Component(NameTokens.BREADCRUMB, "Breadcrumbs are a good way to display your current location. This is usually used when you have multiple layers of content."));
        components.add(new Component(NameTokens.CARDS, "Cards are a convenient means of displaying content composed of different types of objects. They are also well-suited for presenting similar objects whose size or supported actions can vary considerably, like photos with captions of variable length."));
        components.add(new Component(NameTokens.CHECKBOX, "Checkboxes allow the user to select multiple options from a set. If you have multiple options appearing in a list, you can preserve space by using checkboxes instead of on/off switches."));
        components.add(new Component(NameTokens.CHIPS, "Chips represent complex entities in small blocks, such as a contact. They can contain a photo, short title string, and brief information. Chips are manipulated through drag-and-drop. Touching them invokes the full view in a card or full screen view or invokes a menu of options related to that chip's entity."));
        components.add(new Component(NameTokens.COLLAPSIBLE, "Collapsibles are accordion elements that expand when clicked on. They allow you to hide content that is not immediately relevant to the user."));
        components.add(new Component(NameTokens.COLLECTION, "Collections allow you to group list objects together."));
        components.add(new Component(NameTokens.COLOR, "Color in material design is inspired by bold hues juxtaposed with muted environments, deep shadows, and bright highlights. Material takes cues from contemporary architecture, road signs, pavement marking tape, and athletic courts. Color should be unexpected and vibrant."));
        components.add(new Component(NameTokens.DATE_PICKER, "A dialog picker is used to select a single date on mobile. The selected day is indicated by a filled circle. The current day is indicated by a different color and type weight."));
        components.add(new Component(NameTokens.DIALOGS, "Dialogs are content that are not original visible on a page but show up with extra information if needed. The transitions should make the appearance of the dialog make sense and not jarring to the user."));
        components.add(new Component(NameTokens.DROPDOWN, "You can add dropdown easily by specifying it's item content and add a UiHandler on it to implement any event."));
        components.add(new Component(NameTokens.ERRORS, "Errors occur when an app fails to complete what is expected, such as: The app does not understand user input, The system or app fails , A user intends to run incompatible operations concurrently"));
        components.add(new Component(NameTokens.ICON, "We have included 740 Material Design Icons courtesy of Google. You can download them directly from the Material Design specs."));
        components.add(new Component(NameTokens.FAB, "FAB or Floating action buttons are used for a promoted action. They are distinguished by a circled icon floating above the UI and have motion behaviors that include morphing, launching, and a transferring anchor point."));
        components.add(new Component(NameTokens.FOOTER, "Footers are a great way to organize a lot of site navigation and information at the end of a page. This is where the user will look once hes finished scrolling through the current page or is looking for additional information about your website."));
        components.add(new Component(NameTokens.LAYOUT, "Provides you an easy way to layout your content using the Grid System and also using helper classes."));
        components.add(new Component(NameTokens.LOADERS, "If you have content that will take a long time to load, you should give the user feedback. For this reason we provide a number activity + progress indicators."));
        components.add(new Component(NameTokens.LISTBOX, "Material ListBox is another dropdown component that will set / get the value depends on the selected index"));
        components.add(new Component(NameTokens.SECURITY, "We've used GWT's SafeHtml Utility and Sanitization classes to avoid XSS Injection inside our TextMixin."));
        components.add(new Component(NameTokens.MEDIA, "Media components include things that have to do with large media objects like Images, Video, Audio, etc."));
        components.add(new Component(NameTokens.NAVBAR, "The navbar is fully contained by an HTML5 Nav tag. Inside a recommended container div, there are 2 main parts of the navbar. A logo or brand link, and the navigations links. You can align these links to the left or right."));
        components.add(new Component(NameTokens.PUSHPIN, "Pushpin is our fixed positioning plugin. You can check out our live examples: the fixed Table of Contents on the right."));
        components.add(new Component(NameTokens.RADIO_BUTTON, "Radio buttons allow the user to select one option from a set. Use radio buttons for exclusive selection if you think that the user needs to see all available options side-by-side."));
        components.add(new Component(NameTokens.RANGE, "Range or Sliders are ideal components for adjusting settings that reflect intensity levels, such as volume, brightness, or color saturation."));
        components.add(new Component(NameTokens.SEARCH, "Attached to NavBar component or can be used on external panels."));
        components.add(new Component(NameTokens.SIDENAVS, "Also called navigation drawer - it slides in from the left and contains the navigation destinations for your app."));
        components.add(new Component(NameTokens.SCROLLSPY, "Scrollspy is a jQuery plugin that tracks certain elements and which element the user's screen is currently centered on. Our main demo of this is our table of contents on every documentation page to the right. Clicking on these links will also scroll the page to that element."));
        components.add(new Component(NameTokens.SHADOW, "By importing another project called gwt-material-themes, you can now easily integrate it and make your app more professional with branding identity."));
        components.add(new Component(NameTokens.SWITCHES, "On/off switches toggle the state of a single settings option. The option that the switch controls, as well as the state it’s in, should be made clear from the corresponding inline label. Switches take on the same visual properties of the radio button."));
        components.add(new Component(NameTokens.TABS, "The tabs structure consists of an unordered list of tabs that have hashes corresponding to tab ids. Then when you click on each tab, only the container with the corresponding tab id will become visible."));
        components.add(new Component(NameTokens.TEXTFIELDS, "Text fields allow users to input, edit, and select text. Text fields typically reside in forms but can appear in other places, like dialog boxes and search."));
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
