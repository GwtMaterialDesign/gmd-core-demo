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
package gmd.core.demo.client.application.page.home;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gmd.core.demo.client.application.page.home.component.MotionDemo;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialPanel;
import gwt.material.design.client.ui.animate.debugger.AnimationGlobalConfig;
import gwt.material.design.client.ui.animate.debugger.AnimationSpeed;
import gwt.material.design.motion.client.pattern.fade.MaterialFade;
import gwt.material.design.motion.client.pattern.fadethrough.MaterialFadeThrough;
import gwt.material.design.motion.client.pattern.sharedaxis.MaterialSharedAxis;
import gwt.material.design.motion.client.pattern.sharedaxis.SharedAxisConfig;
import gwt.material.design.motion.client.pattern.sharedaxis.SharedAxisType;

import javax.inject.Inject;

public class HomeView extends ViewImpl implements HomePresenter.MyView {

    interface Binder extends UiBinder<Widget, HomeView> {
    }

    @UiField
    MaterialPanel fadeTarget;

    @UiField
    MotionDemo sharedAxisZ, sharedAxisX, sharedAxisY, fadeThrough;

    @UiField
    MaterialButton fadeButton;

    @Inject
    HomeView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));

        AnimationGlobalConfig.SPEED = AnimationSpeed.SLOWEST;
    }

    @UiHandler("fadeEnter")
    void fadeEnter(ClickEvent event) {
        MaterialFade.getInstance().enter(fadeTarget);
    }

    @UiHandler("fadeExit")
    void fadeExit(ClickEvent event) {
        MaterialFade.getInstance().exit(fadeTarget);
    }

    @UiHandler("fadeThroughEnter")
    void item1(ClickEvent event) {
        MaterialFadeThrough.getInstance().animate(fadeThrough.getSource(), fadeThrough.getTarget());
    }

    @UiHandler("fadeThroughExit")
    void item2(ClickEvent event) {
        MaterialFadeThrough.getInstance().animate(fadeThrough.getTarget(), fadeThrough.getSource());
    }

    @UiHandler("sharedXAxisEnter")
    void sharedXAxisEnter(ClickEvent event) {
        MaterialSharedAxis.getInstance()
            .setConfig(new SharedAxisConfig(SharedAxisType.X_AXIS, true))
            .animate(sharedAxisX.getSource(), sharedAxisX.getTarget());
    }

    @UiHandler("sharedXAxisExit")
    void sharedXAxisExit(ClickEvent event) {
        MaterialSharedAxis.getInstance()
            .setConfig(new SharedAxisConfig(SharedAxisType.X_AXIS, false))
            .animate(sharedAxisX.getTarget(), sharedAxisX.getSource());
    }

    @UiHandler("sharedYAxisEnter")
    void sharedYAxisEnter(ClickEvent event) {
        MaterialSharedAxis.getInstance()
            .setConfig(new SharedAxisConfig(SharedAxisType.Y_AXIS, true))
            .animate(sharedAxisY.getSource(), sharedAxisY.getTarget());
    }

    @UiHandler("sharedYAxisExit")
    void sharedYAxisExit(ClickEvent event) {
        MaterialSharedAxis.getInstance()
            .setConfig(new SharedAxisConfig(SharedAxisType.Y_AXIS, false))
            .animate(sharedAxisY.getTarget(), sharedAxisY.getSource());
    }

    @UiHandler("sharedZAxisEnter")
    void sharedZAxisEnter(ClickEvent event) {
        MaterialSharedAxis.getInstance()
            .setConfig(new SharedAxisConfig(SharedAxisType.Z_AXIS, true))
            .animate(sharedAxisZ.getSource(), sharedAxisZ.getTarget());
    }

    @UiHandler("sharedZAxisExit")
    void sharedZAxisExit(ClickEvent event) {
        MaterialSharedAxis.getInstance()
            .setConfig(new SharedAxisConfig(SharedAxisType.Z_AXIS, false))
            .animate(sharedAxisZ.getTarget(), sharedAxisZ.getSource());
    }
}
