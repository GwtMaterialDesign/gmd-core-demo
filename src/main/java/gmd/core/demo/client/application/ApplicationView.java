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

import com.google.gwt.dom.client.Document;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.client.base.helper.ColorHelper;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.pwa.PwaManager;
import gwt.material.design.client.pwa.manifest.js.AppInstaller;
import gwt.material.design.client.pwa.push.js.Notification;
import gwt.material.design.client.ui.MaterialContainer;
import gwt.material.design.client.ui.MaterialLink;
import gwt.material.design.client.ui.MaterialToast;

public class ApplicationView extends ViewImpl implements ApplicationPresenter.MyView {
    interface Binder extends UiBinder<Widget, ApplicationView> {
    }

    @UiField
    MaterialLink install;

    @UiField
    MaterialContainer container;

    private AppInstaller appInstaller;

    @Inject
    ApplicationView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
        bindSlot(ApplicationPresenter.SLOT_MAIN, container);
        appInstaller = new AppInstaller(() -> install.setVisible(true));
    }

    @Override
    protected void onAttach() {
        super.onAttach();

        if (PwaManager.isPwaSupported()) {
            PwaManager.getInstance()
                    .setServiceWorker("service-worker.js")
                    .setThemeColor(ColorHelper.setupComputedBackgroundColor(Color.BLUE_DARKEN_3))
                    .setWebManifest("manifest.url")
                    .load();

            // Will request a notification
            Notification.requestPermission(status -> MaterialToast.fireToast("Permission Status: " + status));
        }

        Document.get().getElementById("splashscreen").removeFromParent();
    }

    @UiHandler("install")
    void install(ClickEvent e) {
        appInstaller.prompt();
    }
}
