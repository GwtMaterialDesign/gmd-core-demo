package gmd.core.demo.client.application;

import gwt.material.design.client.pwa.serviceworker.ServiceEvent;
import gwt.material.design.client.pwa.serviceworker.ServiceWorkerManager;
import gwt.material.design.client.pwa.serviceworker.js.ServiceWorker;
import gwt.material.design.client.pwa.serviceworker.js.ServiceWorkerOption;
import gwt.material.design.client.ui.MaterialToast;

public class AppServiceWorkerManager extends ServiceWorkerManager {

    public static final String SCOPE = "/gmd-core-demo/";

    public AppServiceWorkerManager() {
        super(SCOPE + "service-worker.js");

        ServiceWorkerOption option = ServiceWorkerOption.create();
        option.setScope(SCOPE);
        setOption(option);
    }

    @Override
    public boolean onNewServiceWorkerFound(ServiceEvent event, ServiceWorker serviceWorker) {
        MaterialToast.fireToast("New Updates Installed");
        return super.onNewServiceWorkerFound(event, serviceWorker);
    }

    @Override
    public boolean onOffline(ServiceEvent event) {
        MaterialToast.fireToast("You're offline but you can still browse.");
        return super.onOffline(event);
    }

    @Override
    public boolean onOnline(ServiceEvent event) {
        MaterialToast.fireToast("Connected");
        return super.onOnline(event);
    }
}
