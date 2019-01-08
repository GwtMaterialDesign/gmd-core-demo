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
package gmd.core.demo.client.application;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import gmd.core.demo.client.application.page.badge.BadgeModule;
import gmd.core.demo.client.application.page.breadcrumb.BreadcrumbModule;
import gmd.core.demo.client.application.page.button.ButtonModule;
import gmd.core.demo.client.application.page.cards.CardModule;
import gmd.core.demo.client.application.page.checkbox.CheckboxModule;
import gmd.core.demo.client.application.page.chips.ChipsModule;
import gmd.core.demo.client.application.page.collapsible.CollapsibleModule;
import gmd.core.demo.client.application.page.collection.CollectionModule;
import gmd.core.demo.client.application.page.datepicker.DatePickerModule;
import gmd.core.demo.client.application.page.home.HomeModule;

public class ApplicationModule extends AbstractPresenterModule {

    @Override
    protected void configure() {
        install(new HomeModule());
        install(new BadgeModule());
        install(new ButtonModule());
        install(new BreadcrumbModule());
        install(new CardModule());
        install(new CheckboxModule());
        install(new ChipsModule());
        install(new CollapsibleModule());
        install(new CollectionModule());
        install(new DatePickerModule());

        bindPresenter(ApplicationPresenter.class, ApplicationPresenter.MyView.class, ApplicationView.class,
                ApplicationPresenter.MyProxy.class);
    }
}
