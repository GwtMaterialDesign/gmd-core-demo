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
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import gwt.material.design.client.ui.MaterialPanel;

public class AppSelector extends Composite {

    private static final DashboardCardUiBinder uiBinder = GWT.create(DashboardCardUiBinder.class);

    interface DashboardCardUiBinder extends UiBinder<MaterialPanel, AppSelector> {
    }


    public AppSelector() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    protected MaterialPanel getWidget() {
        return (MaterialPanel) super.getWidget();
    }
}
