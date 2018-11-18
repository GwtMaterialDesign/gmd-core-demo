/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2018 GwtMaterialDesign
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

import gwt.material.design.client.pwa.serviceworker.ServiceEvent;
import gwt.material.design.client.pwa.serviceworker.ServiceWorkerManager;
import gwt.material.design.client.pwa.serviceworker.js.ServiceWorkerRegistration;
import gwt.material.design.client.ui.MaterialToast;

public class AppServiceWorker extends ServiceWorkerManager {

    public AppServiceWorker() {
        super("service-worker.js");
    }

    @Override
    public boolean onInstalled(ServiceEvent event) {
        return super.onInstalled(event);
    }

    @Override
    public boolean onActivating(ServiceEvent event) {
        return super.onActivating(event);
    }

    @Override
    public boolean onActivated(ServiceEvent event) {
        return super.onActivated(event);
    }

    @Override
    public boolean onOnline(ServiceEvent event) {
        MaterialToast.fireToast("Network is Online");
        return super.onOnline(event);
    }

    @Override
    public boolean onOffline(ServiceEvent event) {
        MaterialToast.fireToast("Network is Offline");
        return super.onOffline(event);
    }

    @Override
    public boolean onRegistered(ServiceEvent event, ServiceWorkerRegistration registration) {
        return super.onRegistered(event, registration);
    }

    @Override
    public boolean onRedundant(ServiceEvent event) {
        return super.onRedundant(event);
    }

    @Override
    public boolean onMessageReceived(ServiceEvent event, Object data) {
        return super.onMessageReceived(event, data);
    }
}
