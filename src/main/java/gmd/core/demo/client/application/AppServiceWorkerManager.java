package gmd.core.demo.client.application;

import com.google.gwt.user.client.Window;
import gwt.material.design.client.pwa.serviceworker.ServiceEvent;
import gwt.material.design.client.pwa.serviceworker.ServiceWorkerManager;
import gwt.material.design.client.pwa.serviceworker.js.ServiceWorker;
import gwt.material.design.client.pwa.serviceworker.js.ServiceWorkerOption;
import gwt.material.design.client.ui.MaterialToast;

public class AppServiceWorkerManager extends ServiceWorkerManager {

    public AppServiceWorkerManager() {
        super("/gmd-core-demo/service-worker.js");

        ServiceWorkerOption option = ServiceWorkerOption.create();
        option.setScope("/gmd-core-demo/");
        setOption(option);
    }

    @Override
    public boolean onNewServiceWorkerFound(ServiceEvent event, ServiceWorker serviceWorker) {
        Window.Location.reload();
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
