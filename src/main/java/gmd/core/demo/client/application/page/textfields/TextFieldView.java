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
package gmd.core.demo.client.application.page.textfields;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.HasEnabled;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gmd.core.demo.client.application.model.FieldState;
import gmd.core.demo.client.application.model.User;
import gmd.core.demo.client.application.model.UserOracle;
import gwt.material.design.addins.client.autocomplete.MaterialAutoComplete;
import gwt.material.design.addins.client.combobox.MaterialComboBox;
import gwt.material.design.client.base.AbstractValueWidget;
import gwt.material.design.client.base.CopyCommandCallback;
import gwt.material.design.client.base.HasFieldTypes;
import gwt.material.design.client.base.HasReadOnly;
import gwt.material.design.client.base.HasStatusText;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.constants.FieldType;
import gwt.material.design.client.constants.StatusDisplayType;
import gwt.material.design.client.events.PasteEvent;
import gwt.material.design.client.js.CopyCommandData;
import gwt.material.design.client.ui.MaterialDoubleBox;
import gwt.material.design.client.ui.MaterialFloatBox;
import gwt.material.design.client.ui.MaterialIcon;
import gwt.material.design.client.ui.MaterialIntegerBox;
import gwt.material.design.client.ui.MaterialListValueBox;
import gwt.material.design.client.ui.MaterialLongBox;
import gwt.material.design.client.ui.MaterialRow;
import gwt.material.design.client.ui.MaterialTextArea;
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.client.ui.MaterialToast;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class TextFieldView extends ViewImpl implements TextFieldPresenter.MyView {
    interface Binder extends UiBinder<Widget, TextFieldView> {
    }

    @UiField
    MaterialTextBox txtBoxValue, txtBoxAsNullValue, pasteItHere, copyToClipboard;

    @UiField
    MaterialTextArea txtAreaAuto, txtAreaValue, txtAreaFocus;

    @UiField
    MaterialFloatBox txtFloatBox, txtFloatRO, txtFloatTRO, txtFloatValue;

    @UiField
    MaterialIntegerBox txtIntegerBox, txtIntegerRO, txtIntegerTRO, txtIntegerValue;

    @UiField
    MaterialDoubleBox txtDoubleBox, txtDoubleRO, txtDoubleTRO, txtDoubleValue;

    @UiField
    MaterialLongBox txtLongBox, txtLongRO, txtLongTRO, txtLongValue;

    @UiField
    MaterialComboBox<String> combo4, combo5;

    @UiField
    MaterialListValueBox<FieldState> defaultStates;

    @UiField
    MaterialListValueBox<FieldType> fieldTypes;

    @UiField
    MaterialRow defaultStatesRow;

    @UiField
    MaterialAutoComplete acDefault;

    @UiField
    MaterialTextBox firstName;

    @Inject
    TextFieldView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
        txtFloatBox.setValue(1000.25f);
        txtFloatRO.setValue(1000.25f);
        txtFloatTRO.setValue(1000.25f);
        txtFloatValue.setValue(1000.25f);
        txtIntegerBox.setValue(10);
        txtIntegerRO.setValue(10);
        txtIntegerTRO.setValue(10);
        txtIntegerValue.setValue(10);
        txtDoubleBox.setValue(9999.90);
        txtDoubleRO.setValue(9999.90);
        txtDoubleTRO.setValue(9999.90);
        txtDoubleValue.setValue(9999.90);
        txtLongBox.setValue((long) 1000.00);
        txtLongRO.setValue((long) 1000.00);
        txtLongTRO.setValue((long) 1000.00);
        txtLongValue.setValue((long) 1000.00);

        txtAreaAuto.setValue("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc quam mauris, accumsan placerat " +
            "lectus ac, tincidunt mattis nisl. Ut efficitur massa in libero gravida tincidunt. Vestibulum eget massa " +
            "eget ex auctor tempus. Aenean vitae augue euismod, lacinia lectus ut, rhoncus enim. Sed vitae laoreet " +
            "felis, eget ullamcorper nunc. Vivamus elit urna, varius et arcu vel, euismod auctor augue. Praesent " +
            "scelerisque scelerisque libero sit amet euismod. Mauris eu est at felis feugiat tincidunt eu vel lectus. " +
            "Ut pretium magna vitae massa sollicitudin, eu tincidunt sapien scelerisque. Maecenas gravida lorem non dui " +
            "pretium, id vestibulum mi imperdiet. Fusce facilisis, dui nec ultrices molestie, nisi metus bibendum lacus, " +
            "eget posuere est odio vitae nulla. Mauris laoreet non justo fringilla tempus. Mauris ut risus risus. " +
            "Vivamus auctor accumsan gravida. Nam venenatis sapien nisl, quis accumsan odio dignissim non. Vestibulum " +
            "aliquam semper condimentum. Suspendisse a eros elementum, dapibus quam in, aliquet lorem. Morbi mi dui, " +
            "convallis at luctus ultricies, malesuada at leo. Morbi et turpis a ex vehicula ullamcorper. Vestibulum " +
            "lacinia, orci eget elementum fermentum, lectus velit interdum erat, sit amet pharetra justo elit in tortor. " +
            "Suspendisse ac vestibulum nisi.\n" +
            "\n" +
            "Nunc euismod metus nec elit sollicitudin blandit. Proin eleifend ex bibendum sodales blandit. Vestibulum " +
            "varius pharetra arcu, sit amet pellentesque odio hendrerit nec. Integer faucibus imperdiet tortor a tempus. " +
            "Sed accumsan condimentum nisl. Cras interdum sapien quis maximus commodo. Nulla malesuada imperdiet enim, " +
            "non ornare elit auctor in. Fusce at ipsum eget turpis tincidunt maximus. Nunc sodales tortor nec tincidunt " +
            "fringilla. Quisque sollicitudin ipsum at dolor faucibus, ultricies convallis ipsum convallis. Donec " +
            "consequat velit vel molestie tempus. Donec et accumsan lacus, non sollicitudin quam. Morbi arcu lacus, " +
            "blandit eu lacus nec, finibus tempus ligula.", true);

        txtAreaFocus.setValue("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc quam mauris, accumsan placerat " +
            "lectus ac, tincidunt mattis nisl. Ut efficitur massa in libero gravida tincidunt. Vestibulum eget massa " +
            "eget ex auctor tempus. Aenean vitae augue euismod, lacinia lectus ut, rhoncus enim. Sed vitae laoreet " +
            "felis, eget ullamcorper nunc. Vivamus elit urna, varius et arcu vel, euismod auctor augue. Praesent " +
            "scelerisque scelerisque libero sit amet euismod. Mauris eu est at felis feugiat tincidunt eu vel lectus. " +
            "Ut pretium magna vitae massa sollicitudin, eu tincidunt sapien scelerisque. Maecenas gravida lorem non dui " +
            "pretium, id vestibulum mi imperdiet. Fusce facilisis, dui nec ultrices molestie, nisi metus bibendum lacus, " +
            "eget posuere est odio vitae nulla. Mauris laoreet non justo fringilla tempus. Mauris ut risus risus. " +
            "Vivamus auctor accumsan gravida. Nam venenatis sapien nisl, quis accumsan odio dignissim non. Vestibulum " +
            "aliquam semper condimentum. Suspendisse a eros elementum, dapibus quam in, aliquet lorem. Morbi mi dui, " +
            "convallis at luctus ultricies, malesuada at leo. Morbi et turpis a ex vehicula ullamcorper. Vestibulum " +
            "lacinia, orci eget elementum fermentum, lectus velit interdum erat, sit amet pharetra justo elit in tortor. " +
            "Suspendisse ac vestibulum nisi.\n" +
            "\n" +
            "Nunc euismod metus nec elit sollicitudin blandit. Proin eleifend ex bibendum sodales blandit. Vestibulum " +
            "varius pharetra arcu, sit amet pellentesque odio hendrerit nec. Integer faucibus imperdiet tortor a tempus. " +
            "Sed accumsan condimentum nisl. Cras interdum sapien quis maximus commodo. Nulla malesuada imperdiet enim, " +
            "non ornare elit auctor in. Fusce at ipsum eget turpis tincidunt maximus. Nunc sodales tortor nec tincidunt " +
            "fringilla. Quisque sollicitudin ipsum at dolor faucibus, ultricies convallis ipsum convallis. Donec " +
            "consequat velit vel molestie tempus. Donec et accumsan lacus, non sollicitudin quam. Morbi arcu lacus, " +
            "blandit eu lacus nec, finibus tempus ligula.", true);


        generateComboBox(combo4);
        generateComboBox(combo5);

        setupFieldStates();
        setupFieldType();

        UserOracle oracle = new UserOracle();
        oracle.addContacts(getAllUsers());
        acDefault.setSuggestions(oracle);

        copyToClipboard.setCopyCommandCallback(new CopyCommandCallback() {

            @Override
            public void success(MaterialWidget widget, MaterialIcon clipboardIcon, CopyCommandData data) {
                MaterialToast.fireToast("Copied: " + data.text);
            }

            @Override
            public void error(CopyCommandData data) {
                MaterialToast.fireToast("Error copying text : " + data.text);
            }
        });
    }


    protected void setupFieldType() {
        fieldTypes.addItem(FieldType.DEFAULT);
        fieldTypes.addItem(FieldType.OUTLINED);
        fieldTypes.addItem(FieldType.FILLED);
        fieldTypes.addItem(FieldType.ALIGNED_LABEL);
        fieldTypes.addValueChangeHandler(event -> {
            for (Widget w : defaultStatesRow) {
                if (w instanceof HasFieldTypes) {
                    ((HasFieldTypes) w).setFieldType(event.getValue());
                }
            }
        });
    }

    protected void setupFieldStates() {
        defaultStates.addItem(FieldState.DEFAULT);
        defaultStates.addItem(FieldState.ERROR);
        defaultStates.addItem(FieldState.ERROR_HOVERABLE);
        defaultStates.addItem(FieldState.SUCCESS);
        defaultStates.addItem(FieldState.SUCCESS_HOVERABLE);
        defaultStates.addItem(FieldState.HELPER);
        defaultStates.addItem(FieldState.READ_ONLY);
        defaultStates.addItem(FieldState.DISABLED);

        defaultStates.addValueChangeHandler(valueChangeEvent -> {
            switch (valueChangeEvent.getValue()) {
                case ERROR:
                    for (Widget w : defaultStatesRow) {
                        if (w instanceof HasFieldTypes && w instanceof HasStatusText) {
                            ((HasStatusText) w).setStatusDisplayType(StatusDisplayType.DEFAULT);
                            ((HasStatusText) w).setErrorText(FieldState.ERROR.getMessage());
                        }
                    }
                    break;
                case ERROR_HOVERABLE:
                    for (Widget w : defaultStatesRow) {
                        if (w instanceof HasFieldTypes && w instanceof HasStatusText) {
                            ((HasStatusText) w).setStatusDisplayType(StatusDisplayType.HOVERABLE);
                            ((HasStatusText) w).setErrorText(FieldState.ERROR.getMessage());
                        }
                    }
                    break;
                case SUCCESS:
                    for (Widget w : defaultStatesRow) {
                        if (w instanceof HasFieldTypes && w instanceof HasStatusText) {
                            ((HasStatusText) w).setStatusDisplayType(StatusDisplayType.DEFAULT);
                            ((HasStatusText) w).setSuccessText(FieldState.SUCCESS.getMessage());
                        }
                    }
                    break;
                case SUCCESS_HOVERABLE:
                    for (Widget w : defaultStatesRow) {
                        if (w instanceof HasFieldTypes && w instanceof HasStatusText) {
                            ((HasStatusText) w).setStatusDisplayType(StatusDisplayType.HOVERABLE);
                            ((HasStatusText) w).setSuccessText(FieldState.SUCCESS.getMessage());
                        }
                    }
                    break;
                case HELPER:
                    for (Widget w : defaultStatesRow) {
                        if (w instanceof HasFieldTypes && w instanceof HasStatusText) {
                            ((HasStatusText) w).setHelperText(FieldState.HELPER.getMessage());
                        }
                    }
                    break;
                case DEFAULT:
                    for (Widget w : defaultStatesRow) {
                        if (w instanceof HasFieldTypes && w instanceof HasStatusText) {
                            ((HasStatusText) w).setStatusDisplayType(StatusDisplayType.DEFAULT);
                            ((HasStatusText) w).clearStatusText();
                            ((HasStatusText) w).setHelperText(null);
                        }
                        if (w instanceof HasReadOnly) {
                            ((HasReadOnly) w).setReadOnly(false);
                        }
                        if (w instanceof HasEnabled) {
                            ((HasEnabled) w).setEnabled(true);
                        }
                    }
                    break;
                case READ_ONLY:
                    for (Widget w : defaultStatesRow) {
                        if (w instanceof HasReadOnly) {
                            ((HasReadOnly) w).setReadOnly(true);
                        }
                    }
                    break;
                case DISABLED:
                    for (Widget w : defaultStatesRow) {
                        if (w instanceof MaterialWidget) {
                            ((MaterialWidget) w).setEnabled(false);
                        }
                    }
                    break;
            }
        });
    }

    private void generateComboBox(MaterialComboBox<String> combo) {
        combo.addItem("Option 1");
        combo.addItem("Option 2");
        combo.addItem("Option 3");
    }

    @UiHandler("pasteItHere")
    void pasteItHere(PasteEvent event) {
        MaterialToast.fireToast("Paste Event fire : " + event.getValue());
    }

    @UiHandler("validateDefault")
    void validateDefault(ClickEvent e) {
        defaultStatesRow.validate();
    }

    @UiHandler("txtBoxValue")
    void onTextBox(ValueChangeEvent<String> e) {
        MaterialToast.fireToast("Value " + e.getValue());
    }

    @UiHandler("btnTextBoxValue")
    void onTextBoxValue(ClickEvent e) {
        txtBoxValue.setValue("Text Box");
    }

    @UiHandler("btnTextBoxValueEvent")
    void onTextBoxValueEvent(ClickEvent e) {
        txtBoxValue.setValue("Text Box 2", true);
    }

    @UiHandler("txtAreaValue")
    void onTextArea(ValueChangeEvent<String> e) {
        MaterialToast.fireToast("Value " + e.getValue());
    }

    @UiHandler("btnTextAreaValue")
    void onTextAreaValue(ClickEvent e) {
        txtAreaValue.setValue("Text Area");
    }

    @UiHandler("btnTextAreaValueEvent")
    void onTextAreaValueEvent(ClickEvent e) {
        txtAreaValue.setValue("Text Area 2", true);
    }

    @UiHandler("txtIntegerValue")
    void onTextInteger(ValueChangeEvent<Integer> e) {
        MaterialToast.fireToast("Value " + e.getValue());
    }

    @UiHandler("btnTextIntegerValue")
    void onTextIntegerValue(ClickEvent e) {
        txtIntegerValue.setValue(20000);
    }

    @UiHandler("btnTextIntegerValueEvent")
    void onTextIntegerValueEvent(ClickEvent e) {
        txtIntegerValue.setValue(1000, true);
    }

    @UiHandler("txtLongValue")
    void onTextLong(ValueChangeEvent<Long> e) {
        MaterialToast.fireToast("Value " + e.getValue());
    }

    @UiHandler("btnTextLongValue")
    void onTextLongValue(ClickEvent e) {
        txtLongValue.setValue(20000L);
    }

    @UiHandler("btnTextLongValueEvent")
    void onTextLongValueEvent(ClickEvent e) {
        txtLongValue.setValue(1000L, true);
    }

    @UiHandler("txtDoubleValue")
    void onTextDouble(ValueChangeEvent<Double> e) {
        MaterialToast.fireToast("Value " + e.getValue());
    }

    @UiHandler("btnTextDoubleValue")
    void onTextDoubleValue(ClickEvent e) {
        txtDoubleValue.setValue(20.00);
    }

    @UiHandler("btnTextDoubleValueEvent")
    void onTextDoubleValueEvent(ClickEvent e) {
        txtDoubleValue.setValue(10.50, true);
    }

    @UiHandler("txtFloatValue")
    void onTextFloat(ValueChangeEvent<Float> e) {
        MaterialToast.fireToast("Value " + e.getValue());
    }

    @UiHandler("btnTextFloatValue")
    void onTextFloatValue(ClickEvent e) {
        txtFloatValue.setValue(20.00f);
    }

    @UiHandler("btnTextFloatValueEvent")
    void onTextFloatValueEvent(ClickEvent e) {
        txtFloatValue.setValue(10.50f, true);
    }

    @UiHandler("btnTextBoxGetValue")
    void textBoxGetValue(ClickEvent e) {
        MaterialToast.fireToast(txtBoxValue.getValue());
    }

    @UiHandler("btnTextAreaGetValue")
    void textAreaGetValue(ClickEvent e) {
        MaterialToast.fireToast(txtAreaValue.getValue());
    }

    @UiHandler("btnTextIntegerGetValue")
    void textIntegerGetValue(ClickEvent e) {
        MaterialToast.fireToast(txtIntegerValue.getValue() + "");
    }

    @UiHandler("btnTextLongGetValue")
    void textLongGetValue(ClickEvent e) {
        MaterialToast.fireToast(txtLongValue.getValue() + "");
    }

    @UiHandler("btnTextDoubleGetValue")
    void textDoubleGetValue(ClickEvent e) {
        MaterialToast.fireToast(txtDoubleValue.getValue() + "");
    }

    @UiHandler("btnTextFloatGetValue")
    void textFloatGetValue(ClickEvent e) {
        MaterialToast.fireToast(txtFloatValue.getValue() + "");
    }

    @UiHandler("getValueAsNull")
    void getValueAsNull(ClickEvent e) {
        if (txtBoxAsNullValue.getValue() == null) {
            MaterialToast.fireToast("Value is null");
        } else {
            if (txtBoxAsNullValue.getValue().isEmpty()) {
                MaterialToast.fireToast("Value is empty");
            } else {
                MaterialToast.fireToast("Value : " + txtBoxAsNullValue.getValue());
            }
        }
    }

    @UiHandler("switchAsNullValue")
    void switchAsNullValue(ValueChangeEvent<Boolean> event) {
        txtBoxAsNullValue.clear();
        txtBoxAsNullValue.setReturnBlankAsNull(event.getValue());
    }

    @UiHandler("reset")
    void reset(ClickEvent e) {
        for (Widget w : defaultStatesRow) {
            if (w instanceof AbstractValueWidget) {
                ((AbstractValueWidget) w).reset();
            }
        }
    }

    @UiHandler("sensitive")
    void sensitive(ValueChangeEvent<Boolean> event) {
        firstName.setSensitive(event.getValue());
    }

    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        list.add(new User("https://s3.amazonaws.com/uifaces/faces/twitter/stevedesigner/128.jpg", User.Position.DEVELOPER, true, "Luis Hoppe", "luis@mail.com", "123123123", "718-555-7654", "Makati City, Philippines", "Gwt Material"));
        list.add(new User("https://s3.amazonaws.com/uifaces/faces/twitter/yassiryahya/128.jpg", User.Position.DEVELOPER, true, "Irwin Mueller", "irwin@mail.com", "123123123", "718-432-7654", "Makati City, Philippines", "Gwt Material"));
        list.add(new User("https://s3.amazonaws.com/uifaces/faces/twitter/lebinoclard/128.jpg", User.Position.DEVELOPER, true, "Levin Card", "levin@mail.com", "123123123", "432-555-7654", "Makati City, Philippines", "Gwt Material"));
        list.add(new User("https://s3.amazonaws.com/uifaces/faces/twitter/lmjabreu/128.jpg", User.Position.DEVELOPER, false, "Dr. Cassie Keeling", "cassie@mail.com", "123123123", "432-555-7654", "Makati City, Philippines", "Gwt Material"));
        list.add(new User("https://s3.amazonaws.com/uifaces/faces/twitter/ariil/128.jpg", User.Position.DEVELOPER, false, "Dr. Madelynn Schamberger", "madelyn@mail.com", "123123123", "543-555-7654", "Makati City, Philippines", "Gwt Material"));
        list.add(new User("https://s3.amazonaws.com/uifaces/faces/twitter/devankoshal/128.jpg", User.Position.MARKETING, false, "Dominique Schmidt", "dom@mail.com", "123123123", "718-657-7654", "Makati City, Philippines", "Gwt Material"));
        list.add(new User("https://s3.amazonaws.com/uifaces/faces/twitter/karthipanraj/128.jpg", User.Position.CTO, false, "Rowland Heller", "rowland@mail.com", "123123123", "718-765-7654", "Makati City, Philippines", "Gwt Material"));
        list.add(new User("https://s3.amazonaws.com/uifaces/faces/twitter/GavicoInd/128.jpg", User.Position.CEO, false, "Quincy Schimmel", "quincy@mail.com", "123123123", "46-555-876", "Makati City, Philippines", "Gwt Material"));
        list.add(new User("https://s3.amazonaws.com/uifaces/faces/twitter/roybarberuk/128.jpg", User.Position.MARKETING, false, "Tierra VonRueden", "tierra@mail.com", "123123123", "654-56-7654", "Makati City, Philippines", "Gwt Material"));
        list.add(new User("https://s3.amazonaws.com/uifaces/faces/twitter/kimcool/128.jpg", User.Position.MARKETING, false, "Travis Larson", "travis@mail.com", "123123123", "465-456-7654", "Makati City, Philippines", "Gwt Material"));
        list.add(new User("https://s3.amazonaws.com/uifaces/faces/twitter/tonymillion/128.jpg", User.Position.MARKETING, false, "Clint Heller", "clint@mail.com", "123123123", "645-555-65", "Makati City, Philippines", "Gwt Material"));
        return list;
    }
}
