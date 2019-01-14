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
package gmd.core.demo.client.application.page.button;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.DoubleClickEvent;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialToast;

import javax.inject.Inject;

public class ButtonView extends ViewImpl implements ButtonPresenter.MyView {
    interface Binder extends UiBinder<Widget, ButtonView> {
    }

    @UiField
    MaterialButton btnClick, btnHover, btnDoubleClick;

    @Inject
    ButtonView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @UiHandler("btnClick")
    void onClick(ClickEvent e) {
        MaterialToast.fireToast("Click Triggered");
        btnClick.setText("Clicked");
    }

    @UiHandler("btnHover")
    void onHover(MouseOverEvent e) {
        MaterialToast.fireToast("Hover Triggered");
        btnHover.setText("Hovered");
    }

    @UiHandler("btnDoubleClick")
    void onDoubleClick(DoubleClickEvent e) {
        MaterialToast.fireToast("Double Click Triggered");
        btnDoubleClick.setText("Double Clicked");
    }
}
