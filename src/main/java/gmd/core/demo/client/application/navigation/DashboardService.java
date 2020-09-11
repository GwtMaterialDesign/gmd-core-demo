package gmd.core.demo.client.application.navigation;

import java.util.ArrayList;
import java.util.List;

public class DashboardService {

    public static List<Dashboard> getDashboards() {
        List<Dashboard> dashboards = new ArrayList<>();
        dashboards.add(new Dashboard("Core", "GMD Core Widgets", "#button", "images/gmd-logo.webp"));
        dashboards.add(new Dashboard("Addins", "Core Widget extension widgets", "https://gwtmaterialdesign.github.io/gmd-addins-demo/", "images/addins-logo.webp", false));
        dashboards.add(new Dashboard("DataTable", "Support for GWT Cell Tables", "https://gwtmaterialdesign.github.io/gmd-table-demo/", "images/datatable-logo.webp", false));
        dashboards.add(new Dashboard("AmCharts", "Our recommended charting Library", "https://gwtmaterialdesign.github.io/gmd-amcharts4-demo/", "images/charts-logo.webp"));
        return dashboards;
    }

    public static List<Dashboard> getVideos() {
        List<Dashboard> dashboards = new ArrayList<>();
        dashboards.add(new Dashboard("https://www.youtube.com/watch?v=rVo_CeDaA8s", "images/setup-banner.png"));
        dashboards.add(new Dashboard("https://www.youtube.com/watch?v=ijRgwm8wZiU", "images/setup-pwa.png"));
        dashboards.add(new Dashboard("https://www.youtube.com/watch?v=e-XY4EGVIuc", "images/build-banner.png"));
        dashboards.add(new Dashboard("https://www.youtube.com/watch?v=79owqV8PPhQ", "images/style-banner.png"));
        dashboards.add(new Dashboard("https://www.youtube.com/watch?v=Ishwhsy95GA", "images/animations-banner.png"));
        dashboards.add(new Dashboard("https://www.youtube.com/watch?v=UXVf9-OntGI", "images/snapshots-banner.png"));
        dashboards.add(new Dashboard("https://www.youtube.com/watch?v=eFjqrxFIQvI", "images/jquery-banner.png"));
        dashboards.add(new Dashboard("https://www.youtube.com/watch?v=snVp1blqzAk", "images/dark.jpg"));
        dashboards.add(new Dashboard("https://www.youtube.com/watch?v=57RH_V7V4CI", "images/custom-widget.png"));
        dashboards.add(new Dashboard("https://www.youtube.com/watch?v=higukSoPr9Q", "images/custom-widget-2.png"));
        return dashboards;
    }
}
