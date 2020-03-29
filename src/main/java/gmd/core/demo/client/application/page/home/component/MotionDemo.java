package gmd.core.demo.client.application.page.home.component;

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
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import gmd.core.demo.client.application.navigation.Dashboard;
import gwt.material.design.client.ui.MaterialImage;
import gwt.material.design.client.ui.MaterialPanel;
import gwt.material.design.client.ui.MaterialTitle;
import gwt.material.design.client.ui.MaterialToast;

public class MotionDemo extends Composite {

    private static DashboardCardUiBinder uiBinder = GWT.create(DashboardCardUiBinder.class);

    interface DashboardCardUiBinder extends UiBinder<MaterialPanel, MotionDemo> {
    }

    @UiField
    MaterialTitle titleLabel;

    @UiField
    MaterialImage imgSource, imgTarget, imgHeader;

    @UiField
    MaterialPanel source, target;

    private String title, description;
    private String sourceUrl, targetUrl, headerUrl;

    public MotionDemo() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    protected void onAttach() {
        super.onAttach();

        titleLabel.setTitle(title);
        titleLabel.setDescription(description);

        imgSource.setUrl(sourceUrl);
        imgTarget.setUrl(targetUrl);
        imgHeader.setUrl(headerUrl);
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public String getTargetUrl() {
        return targetUrl;
    }

    public void setTargetUrl(String targetUrl) {
        this.targetUrl = targetUrl;
    }

    public MaterialPanel getSource() {
        return source;
    }

    public MaterialPanel getTarget() {
        return target;
    }

    public String getHeaderUrl() {
        return headerUrl;
    }

    public void setHeaderUrl(String headerUrl) {
        this.headerUrl = headerUrl;
    }
}
