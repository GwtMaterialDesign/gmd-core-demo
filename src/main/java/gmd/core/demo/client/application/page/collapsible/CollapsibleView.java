/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2017 GwtMaterialDesign
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
package gmd.core.demo.client.application.page.collapsible;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.client.ui.*;

import javax.inject.Inject;

public class CollapsibleView extends ViewImpl implements CollapsiblePresenter.MyView {
    interface Binder extends UiBinder<Widget, CollapsibleView> {
    }

    @UiField
    MaterialCollapsible colaps, expandable, preselect;

    @UiField
    MaterialCollapsibleItem secondItem, activeCollaps;

    @UiField
    MaterialCollapsibleItem item;

    @Inject
    CollapsibleView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));

        colaps.addCollapseHandler(event -> {
            MaterialToast.fireToast("CollapseEvent fired: " + getCollapseText(event.getTarget()));
        });

        expandable.addCollapseHandler(event -> {
            MaterialToast.fireToast("CollapseEvent fired: " + getCollapseText(event.getTarget()));
        });

        colaps.addExpandHandler(event -> {
            MaterialToast.fireToast("ExpandEvent fired: " + getCollapseText(event.getTarget()));
        });

        expandable.addExpandHandler(event -> {
            MaterialToast.fireToast("ExpandEvent fired: " + getCollapseText(event.getTarget()));
        });
    }

    @Override
    protected void onAttach() {
        super.onAttach();

        preselect.setActive(2);
        activeCollaps.setActive(true);
    }

    protected String getCollapseText(MaterialCollapsibleItem target) {
        MaterialCollapsibleHeader header = target.getHeader();
        if (header.getChildren().size() != 0) {
            if (header.getChildren().get(0) instanceof MaterialLink) {
                return ((MaterialLink) header.getChildren().get(0)).getText();
            }
        }
        return "No text";
    }

    @UiHandler("expand")
    void expand(ClickEvent e) {
        secondItem.expand();
    }

    @UiHandler("setActive")
    void setActive(ClickEvent e) {
        item.setActive(true);
    }

    @UiHandler("setActiveExpandable")
    void setActiveExpandable(ClickEvent e) {
        expandable.setActive(1);
    }

    @UiHandler("open")
    void onOpen(ClickEvent e) {
        colaps.open(2);
    }

    @UiHandler("close")
    void onClose(ClickEvent e) {
        colaps.close(2);
    }
}
