/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2017 GwtMaterialDesign
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package gmd.core.demo.client.application;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import gmd.core.demo.client.application.events.MenuHandlers;
import gmd.core.demo.client.application.navigation.Component;
import gmd.core.demo.client.application.navigation.NavigationService;
import gmd.core.demo.client.constants.AppConstants;
import gwt.material.design.client.base.SearchObject;
import gwt.material.design.client.base.helper.ScrollHelper;
import gwt.material.design.client.base.viewport.Resolution;
import gwt.material.design.client.constants.Blur;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.constants.OverlayOption;
import gwt.material.design.client.ui.*;
import gwt.material.design.client.ui.animate.MaterialAnimation;
import gwt.material.design.client.ui.animate.Transition;
import gwt.material.design.incubator.client.search.InlineSearch;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static gwt.material.design.jquery.client.api.JQuery.$;

public class ApplicationView extends ViewWithUiHandlers<MenuHandlers> implements ApplicationPresenter.MyView {

    interface Binder extends UiBinder<Widget, ApplicationView> {
    }

    @UiField
    static MaterialLabel title, description, navBrand;

    @UiField
    static MaterialPanel header, footer;

    @UiField
    MaterialAnchorButton github, gitter;

    @UiField
    static MaterialAnchorButton javaSource, xmlSource;

    @UiField
    MaterialSideNavPush sidenav;

    @UiField
    MaterialLabel name, version, year;

    @UiField
    MaterialRow container;

    @UiField
    MaterialFAB fabUp;

    @UiField
        InlineSearch search;

    @Inject
    ApplicationView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
        bindSlot(ApplicationPresenter.SLOT_MAIN, container);
    }

    @Override
    public void setupSideNav(List<Component> links) {
        name.setText(AppConstants.NAME);
        version.setText("Version " + AppConstants.VERSION);
        github.setHref(AppConstants.GITHUB_REPO);
        gitter.setHref(AppConstants.GITTER_CHANNEL);
        sidenav.setOverlayOption(new OverlayOption(new Blur(4, $("#app-container")), Color.WHITE));
        links.forEach(component -> {
            MaterialLink link = new MaterialLink(component.getName(), component.getHref());
            link.addClickHandler(event -> {
                if (gwt.material.design.client.js.Window.matchMedia(Resolution.ALL_MOBILE.asMediaQuery()) ||
                        gwt.material.design.client.js.Window.matchMedia(Resolution.TABLET.asMediaQuery())) {
                    sidenav.close();
                }
            });
            sidenav.add(link);
        });
        sidenav.addOpenedHandler(event -> getUiHandlers().setContentPush());
        sidenav.addClosedHandler(event -> getUiHandlers().setContentPush());
        year.setText(DateTimeFormat.getFormat("yyyy").format(new Date()));
        search.addCloseHandler(event -> search.close());
    }

    boolean scrolling;

    @Override
    public void setupHeader() {
        Window.addWindowScrollHandler(event -> {
            boolean isInViewPort = new ScrollHelper().isInViewPort(title);
            if (!isInViewPort) {
                if (!scrolling) {
                    MaterialAnimation animation = new MaterialAnimation();
                    animation.setTransition(Transition.FADEINUP);
                    animation.animate(navBrand);
                    navBrand.setText(title.getText());
                    scrolling = true;
                }

            } else {
                MaterialAnimation animation = new MaterialAnimation();
                animation.setTransition(Transition.FADEINUP);
                animation.animate(navBrand);
                navBrand.setText("");
                scrolling = false;
            }

            if (event.getScrollTop() > 320) {
                if (fabUp.getOpacity() == 0) {
                    MaterialAnimation animation = new MaterialAnimation();
                    animation.setTransition(Transition.ZOOMIN);
                    animation.animate(fabUp, () -> {
                        fabUp.setOpacity(1);
                    });
                }
            } else {
                if (fabUp.getOpacity() == 1) {
                    MaterialAnimation animation = new MaterialAnimation();
                    animation.setTransition(Transition.ZOOMOUT);
                    animation.animate(fabUp, () -> {
                        fabUp.setOpacity(0);
                    });
                }
            }
        });
    }

    @Override
    public void updateSideNavActiveState(int index) {
        if (index > -1) {
            sidenav.setActive(index + 1);
        }
    }

    @Override
    public void setupSearch() {
        List<SearchObject> searchObjects = new ArrayList<>();
        List<Component> sideNavLinks = NavigationService.getSideNavLinks();
        for (Component component : sideNavLinks) {
            SearchObject searchObject = new SearchObject();
            searchObject.setKeyword(component.getName());
            searchObject.setLink("#" + component.getHref());
            searchObjects.add(searchObject);
        }
        search.setListSearches(searchObjects);
        search.addCloseHandler(event -> {
            search.clear();
        });
    }

    @UiHandler("fabUp")
    void fabUp(ClickEvent e) {
        ScrollHelper scrollHelper = new ScrollHelper();
        if (scrollHelper.hasVerticalScrollbar()) {
            scrollHelper.scrollTo(0);
        }
    }

    public static void setComponent(Component component) {
        title.setText(component.getName());
        description.setText(component.getDescription());
        javaSource.setHref(component.getJavaSource());
        xmlSource.setHref(component.getXmlSource());
    }

    public static void showHeader(boolean show) {
        header.setVisible(show);
        footer.setVisible(show);
        navBrand.setVisible(show);
    }
}
