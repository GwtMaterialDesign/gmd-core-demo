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
        dashboards.add(new Dashboard("https://www.youtube.com/watch?v=sEVqfqDUOpE", "https://i9.ytimg.com/vi/sEVqfqDUOpE/hqdefault.jpg?time=1588974754911&sqp=CIio1_UF&rs=AOn4CLDntwRiXWbYdOhbijWYOElMderoWg"));
        dashboards.add(new Dashboard("https://www.youtube.com/watch?v=e-XY4EGVIuc", "https://i9.ytimg.com/vi/e-XY4EGVIuc/hqdefault.jpg?time=1588974768597&sqp=CIio1_UF&rs=AOn4CLBFLZ2-8erGPSLVSC9qxcIOlQHl-Q"));
        dashboards.add(new Dashboard("https://www.youtube.com/watch?v=79owqV8PPhQ", "https://i9.ytimg.com/vi/79owqV8PPhQ/hqdefault.jpg?time=1588974793863&sqp=CIio1_UF&rs=AOn4CLCJ89ogIwHw6LP_xtjFcZUNC__Wkw"));
        dashboards.add(new Dashboard("https://www.youtube.com/watch?v=Ishwhsy95GA", "https://i9.ytimg.com/vi/Ishwhsy95GA/hqdefault.jpg?time=1588974814084&sqp=CIio1_UF&rs=AOn4CLDBy1dGm1UFFYL7YqB9Kr2k3x39Fg"));
        dashboards.add(new Dashboard("https://www.youtube.com/watch?v=UXVf9-OntGI", "https://i9.ytimg.com/vi/UXVf9-OntGI/hqdefault.jpg?time=1588974829109&sqp=CIio1_UF&rs=AOn4CLDDJcX8Qu5DP38AEBueCZGKCRpp2Q"));
        dashboards.add(new Dashboard("https://www.youtube.com/watch?v=snVp1blqzAk", "https://i9.ytimg.com/vi/snVp1blqzAk/hqdefault.jpg?time=1588974594984&sqp=CNyl1_UF&rs=AOn4CLAmWWUKoKXGjoncgaaZ0jejtsf3jQ"));
        // Widgets
        dashboards.add(new Dashboard("https://www.youtube.com/watch?v=ABzcNAzERf4", "https://i9.ytimg.com/vi/ABzcNAzERf4/hqdefault.jpg?time=1588974848729&sqp=CIio1_UF&rs=AOn4CLB4cXErvknT40xI3tlzWQ-zVr_AxQ"));
        dashboards.add(new Dashboard("https://www.youtube.com/watch?v=RULFd9mLZEI", "https://i9.ytimg.com/vi/RULFd9mLZEI/hqdefault.jpg?time=1588974912520&sqp=CLSq1_UF&rs=AOn4CLBL0c_Pdf5v3lefXo7qjF0N94QVhg"));
        dashboards.add(new Dashboard("https://www.youtube.com/watch?v=nbhhGDBtcCs", "https://i9.ytimg.com/vi/nbhhGDBtcCs/hqdefault.jpg?time=1588974944220&sqp=CLSq1_UF&rs=AOn4CLBirt6SlyA2eLP2iXHDeJruJxwk2g"));
        dashboards.add(new Dashboard("https://www.youtube.com/watch?v=FuMt4Q0xuPE", "https://i9.ytimg.com/vi/FuMt4Q0xuPE/hqdefault.jpg?time=1588974970661&sqp=CLSq1_UF&rs=AOn4CLDc0HAIUxNsbfFGuBjAwhN1CgWa3g"));
        dashboards.add(new Dashboard("https://www.youtube.com/watch?v=lHHbk5ICuoo", "https://i9.ytimg.com/vi/lHHbk5ICuoo/hqdefault.jpg?time=1588975007701&sqp=CLSq1_UF&rs=AOn4CLA9XMdXU7znKwbTLp08OMK_wqD0ow"));
        dashboards.add(new Dashboard("https://www.youtube.com/watch?v=npYq9tb7lB8", "https://i9.ytimg.com/vi/npYq9tb7lB8/hqdefault.jpg?time=1588975028390&sqp=CLSq1_UF&rs=AOn4CLDYunnpdIxj0YMFaeQ-bSp1gYitQw"));
        return dashboards;
    }
}
