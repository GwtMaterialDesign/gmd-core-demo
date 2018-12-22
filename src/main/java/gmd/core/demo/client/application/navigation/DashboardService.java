package gmd.core.demo.client.application.navigation;

import java.util.ArrayList;
import java.util.List;

public class DashboardService {

    public static List<Dashboard> getDashboards(){
        List<Dashboard> dashboards = new ArrayList<>();
        dashboards.add(new Dashboard("Core", "GMD Core Widgets", "#button", "https://www.gstatic.com/devrel-devsite/va3e6d7c495ae58d2f0c21ab1e6f48fa6e19121edf44f1cc6af04d15995811aa0/web/images/illustrations/fast.svg"));
        dashboards.add(new Dashboard("Addins / Incubator", "Core Widget extension widgets", "", "https://www.gstatic.com/devrel-devsite/va3e6d7c495ae58d2f0c21ab1e6f48fa6e19121edf44f1cc6af04d15995811aa0/web/images/illustrations/fast.svg"));
        dashboards.add(new Dashboard("DataTable", "Support for GWT Cell Tables", "", "https://www.gstatic.com/devrel-devsite/va3e6d7c495ae58d2f0c21ab1e6f48fa6e19121edf44f1cc6af04d15995811aa0/web/images/illustrations/fast.svg"));
        dashboards.add(new Dashboard("AmCharts 4", "Our recommended charting Library", "https://gwtmaterialdesign.github.io/gmd-amcharts4-demo/", "https://www.gstatic.com/devrel-devsite/va3e6d7c495ae58d2f0c21ab1e6f48fa6e19121edf44f1cc6af04d15995811aa0/web/images/illustrations/fast.svg"));
        return dashboards;
    }
}
