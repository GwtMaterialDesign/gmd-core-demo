package gmd.core.demo.client.application.widget;

/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2016 GwtMaterialDesign
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


import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import gmd.core.demo.client.application.navigation.Dashboard;
import gwt.material.design.client.ui.*;

public class DashboardCard extends Composite {

    private static DashboardCardUiBinder uiBinder = GWT.create(DashboardCardUiBinder.class);

    interface DashboardCardUiBinder extends UiBinder<MaterialColumn, DashboardCard> {
    }

    @UiField
    MaterialImage image;

    @UiField
    MaterialImage iconImage;

    @UiField
    MaterialLabel title;

    @UiField
    MaterialLink link;

    @UiField
    MaterialPanel namePanel;

    private Dashboard dashboard;

    public DashboardCard(Dashboard dashboard) {
        initWidget(uiBinder.createAndBindUi(this));

        this.dashboard = dashboard;
    }

    @Override
    protected void onAttach() {
        super.onAttach();

        if (dashboard.getTitle() == null) {
            namePanel.removeFromParent();
            getWidget().setCursor(Style.Cursor.POINTER);
            getWidget().addClickHandler(event -> Window.open(dashboard.getUrl(), "", "_blank"));

        } else {
            iconImage.setUrl(dashboard.getImage());
            image.removeFromParent();
        }

        image.setUrl(dashboard.getImage());
        title.setText(dashboard.getTitle());
        link.setHref(dashboard.getUrl());
    }

    @Override
    protected MaterialColumn getWidget() {
        return (MaterialColumn) super.getWidget();
    }
}
