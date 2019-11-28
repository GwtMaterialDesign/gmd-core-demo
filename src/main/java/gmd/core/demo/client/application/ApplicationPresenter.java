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
import com.google.gwt.dom.client.StyleInjector;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.presenter.slots.NestedSlot;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.Proxy;
import gmd.core.demo.client.application.events.ContentPushEvent;
import gmd.core.demo.client.application.events.MenuHandlers;
import gmd.core.demo.client.application.navigation.Component;
import gmd.core.demo.client.application.navigation.NavigationService;
import gmd.core.demo.client.resources.AppResources;
import gwt.material.design.client.base.helper.ColorHelper;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.pwa.PwaManager;

import java.util.List;

public class ApplicationPresenter extends Presenter<ApplicationPresenter.MyView, ApplicationPresenter.MyProxy>
        implements MenuHandlers {

    interface MyView extends View, HasUiHandlers<MenuHandlers> {
        void setupSideNav(List<Component> links);

        void setupHeader();

        void updateSideNavActiveState(int index);

        void setupSearch();
    }

    private PlaceManager manager;

    public static final NestedSlot SLOT_MAIN = new NestedSlot();

    @ProxyStandard
    interface MyProxy extends Proxy<ApplicationPresenter> {
    }

    @Inject
    ApplicationPresenter(EventBus eventBus,
                         MyView view,
                         MyProxy proxy,
                         PlaceManager manager) {
        super(eventBus, view, proxy, RevealType.Root);

        this.manager = manager;
        getView().setUiHandlers(this);
    }

    @Override
    protected void onBind() {
        super.onBind();

        getView().setupSideNav(NavigationService.getSideNavLinks());
        getView().setupHeader();
        getView().setupSearch();
    }

    @Override
    protected void onReveal() {
        super.onReveal();

        if (PwaManager.isPwaSupported()) {
            PwaManager.getInstance()
                    .setServiceWorker("service-worker.js")
                    .setThemeColor(ColorHelper.setupComputedBackgroundColor(Color.BLUE_DARKEN_3))
                    .setWebManifest("manifest.url")
                    .load();

            // Will request a notification
            // Notification.requestPermission(status -> MaterialToast.fireToast("Permission Status: " + status));
        }

        StyleInjector.inject(AppResources.INSTANCE.appCss().getText());

        Document.get().getElementById("splashscreen").removeFromParent();

        String nameToken = manager.getCurrentPlaceRequest().getNameToken();
        if (nameToken != null) {
            getView().updateSideNavActiveState(NavigationService.getSideNavLinks().indexOf(NavigationService.get(nameToken)));
        }
    }

    @Override
    public void setContentPush() {
        ContentPushEvent.fire(this);
    }
}
