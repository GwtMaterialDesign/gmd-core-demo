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

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;
import gmd.core.demo.client.application.navigation.Component;
import gwt.material.design.client.base.helper.ScrollHelper;
import gwt.material.design.client.constants.Blur;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.constants.OverlayOption;
import gwt.material.design.client.ui.*;
import gwt.material.design.client.ui.animate.MaterialAnimation;
import gwt.material.design.client.ui.animate.Transition;

import java.util.List;

import static gwt.material.design.jquery.client.api.JQuery.$;

public class ApplicationView extends ViewImpl implements ApplicationPresenter.MyView {

    interface Binder extends UiBinder<Widget, ApplicationView> {
    }

    @UiField
    static MaterialLabel title, description, navBrand;

    @UiField
    static MaterialPanel header;

    @UiField
    MaterialAnchorButton javaSource, xmlSource;

    @UiField
    MaterialSideNavPush sidenav;

    @UiField
    MaterialRow container;

    @Inject
    ApplicationView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
        bindSlot(ApplicationPresenter.SLOT_MAIN, container);
    }

    @Override
    public void setupSideNav(List<Component> links) {
        sidenav.setOverlayOption(new OverlayOption(new Blur(4, $("#app-container")),  Color.WHITE));
        links.forEach(component -> sidenav.add(new MaterialLink(component.getName(), component.getHref())));
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
                    navBrand.setText("Core | " + title.getText());
                    scrolling = true;
                }

            } else {
                MaterialAnimation animation = new MaterialAnimation();
                animation.setTransition(Transition.FADEINUP);
                animation.animate(navBrand);
                navBrand.setText("Core");
                scrolling = false;
            }
        });
    }

    @Override
    public void updateSideNavActiveState(int index) {
        if (index > -1) {
            sidenav.setActive(index + 1);
        }
    }

    public static void setComponent(Component component) {
        title.setText(component.getName());
        description.setText(component.getDescription());
    }

    public static void showHeader(boolean show) {
        header.setVisible(show);
    }
}
