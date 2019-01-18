package gmd.core.demo.client.application.navigation;

import java.util.ArrayList;
import java.util.List;

public class DashboardService {

    public static List<Dashboard> getDashboards(){
        List<Dashboard> dashboards = new ArrayList<>();
        dashboards.add(new Dashboard("Core", "GMD Core Widgets", "#button", "//i.imgur.com/wS2BUIs.png"));
        dashboards.add(new Dashboard("Addins", "Core Widget extension widgets", "https://gwtmaterialdesign.github.io/gmd-addins-demo/", "//i.imgur.com/bO2kFKs.png"));
        dashboards.add(new Dashboard("DataTable", "Support for GWT Cell Tables", "https://gwtmaterialdesign.github.io/gmd-table-demo/", "//i.imgur.com/AKO3awU.png"));
        dashboards.add(new Dashboard("AmCharts", "Our recommended charting Library", "https://gwtmaterialdesign.github.io/gmd-amcharts4-demo/", "//i.imgur.com/U8IIMaY.png"));
        return dashboards;
    }

    public static List<Dashboard> getVideos(){
        List<Dashboard> dashboards = new ArrayList<>();
        dashboards.add(new Dashboard("https://www.youtube.com/watch?v=sEVqfqDUOpE", "https://i.imgur.com/TgFk76k.png"));
        dashboards.add(new Dashboard("https://www.youtube.com/watch?v=e-XY4EGVIuc", "https://i.imgur.com/QsSCWV8.png"));
        dashboards.add(new Dashboard("https://www.youtube.com/watch?v=79owqV8PPhQ", "https://i.imgur.com/8qHhNtl.png"));
        dashboards.add(new Dashboard("https://www.youtube.com/watch?v=Ishwhsy95GA", "https://i.imgur.com/eG0XMlT.png"));
        dashboards.add(new Dashboard("https://www.youtube.com/watch?v=UXVf9-OntGI", "https://i.imgur.com/DMSkEAj.png"));
        dashboards.add(new Dashboard("https://www.youtube.com/watch?v=eFjqrxFIQvI", "https://i.imgur.com/Vbk8aoA.png"));
        return dashboards;
    }
}
