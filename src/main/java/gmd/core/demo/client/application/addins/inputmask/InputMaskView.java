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
package gmd.core.demo.client.application.addins.inputmask;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.addins.client.inputmask.MaterialIntegerInputMask;
import gwt.material.design.client.ui.MaterialToast;
import gwt.material.design.incubator.client.dob.DateOfBirthPicker;

import javax.inject.Inject;
import java.util.Date;

public class InputMaskView extends ViewImpl implements InputMaskPresenter.MyView {
    interface Binder extends UiBinder<Widget, InputMaskView> {
    }

    @UiField
    MaterialIntegerInputMask inputMask;

    @UiField
    DateOfBirthPicker dob;

    @Inject
    InputMaskView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @UiHandler("getValue")
    void getValue(ClickEvent e) {
        MaterialToast.fireToast(inputMask.getValue() + "");
    }

    @UiHandler("getValueWithMask")
    void getCleanValue(ClickEvent e) {
        MaterialToast.fireToast(inputMask.getValueWithMask() + "");
    }

    @UiHandler("setValue")
    void setValue(ClickEvent e) {
        inputMask.setValue(43243);
    }

    @UiHandler("getDobValue")
    void getDobValue(ClickEvent e) {
        MaterialToast.fireToast(dob.getValue() + "");
    }

    @UiHandler("setDobValue")
    void setDobValue(ClickEvent e) {
        dob.setValue(new Date());
    }
}
