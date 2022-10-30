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
package gmd.core.demo.client.application.page.security;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.safehtml.shared.SimpleHtmlSanitizer;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.client.base.mixin.TextMixin;
import gwt.material.design.client.sanitizer.DefaultValueSanitizer;
import gwt.material.design.client.sanitizer.StandardValueSanitizer;
import gwt.material.design.client.ui.MaterialChip;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialTextBox;

import javax.inject.Inject;

public class SecurityView extends ViewImpl implements SecurityPresenter.MyView {
    interface Binder extends UiBinder<Widget, SecurityView> {
    }

    @UiField
    MaterialLabel label, label2;

    @UiField
    MaterialChip chip, chip2;

    @UiField
    MaterialTextBox valueSanitizerBox;

    @Inject
    SecurityView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));


        valueSanitizerBox.setValueSanitizer(new DefaultValueSanitizer());
    }

    @Override
    protected void onAttach() {
        super.onAttach();


        chip.setText("<b>Chip</b> with <i>SimpleHtmlSanitizer</i>");
        label.setText("<b>Sanitized Label</b> with <i>SimpleHtmlSanitizer</i>");

        GWT.log(label.getText());

        TextMixin.setDefaultSanitizer(SimpleHtmlSanitizer.getInstance());
        chip2.setText("<b>Chip</b> with <i>SimpleHtmlSanitizer</i>");
        label2.setText("<b>Sanitized Label</b> with <i>SimpleHtmlSanitizer</i>");

        GWT.log(label2.getText());
    }

    @UiHandler("getValue")
    void getValue(ClickEvent event) {
        GWT.log(label.getText());
    }
}
