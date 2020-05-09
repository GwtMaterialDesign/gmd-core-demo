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
        dashboards.add(new Dashboard("https://www.youtube.com/watch?v=sEVqfqDUOpE", "images/setup-banner.png"));
        dashboards.add(new Dashboard("https://www.youtube.com/watch?v=e-XY4EGVIuc", "images/build-banner.png"));
        dashboards.add(new Dashboard("https://www.youtube.com/watch?v=79owqV8PPhQ", "images/style-banner.png"));
        dashboards.add(new Dashboard("https://www.youtube.com/watch?v=Ishwhsy95GA", "images/animations-banner.png"));
        dashboards.add(new Dashboard("https://www.youtube.com/watch?v=UXVf9-OntGI", "images/snapshots-banner.png"));
        dashboards.add(new Dashboard("https://www.youtube.com/watch?v=eFjqrxFIQvI", "images/jquery-banner.png"));
        dashboards.add(new Dashboard("https://www.youtube.com/watch?v=snVp1blqzAk", "images/dark.jpg"));
        // Widgets
        dashboards.add(new Dashboard("https://www.youtube.com/watch?v=ABzcNAzERf4", "images/badge.jpg"));
        dashboards.add(new Dashboard("https://www.youtube.com/watch?v=RULFd9mLZEI", "images/button.jpg"));
        dashboards.add(new Dashboard("https://www.youtube.com/watch?v=nbhhGDBtcCs", "images/breadcrumb.jpg"));
        dashboards.add(new Dashboard("https://www.youtube.com/watch?v=FuMt4Q0xuPE", "images/card.jpg"));
        dashboards.add(new Dashboard("https://www.youtube.com/watch?v=lHHbk5ICuoo", "images/checkbox.jpg"));
        dashboards.add(new Dashboard("https://www.youtube.com/watch?v=npYq9tb7lB8", "images/chips.jpg"));
        return dashboards;
    }
}
