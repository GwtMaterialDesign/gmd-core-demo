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
import gmd.core.demo.client.application.page.animation.AnimationModule;
import gmd.core.demo.client.application.page.badge.BadgeModule;
import gmd.core.demo.client.application.page.breadcrumb.BreadcrumbModule;
import gmd.core.demo.client.application.page.button.ButtonModule;
import gmd.core.demo.client.application.page.cards.CardModule;
import gmd.core.demo.client.application.page.checkbox.CheckboxModule;
import gmd.core.demo.client.application.page.chips.ChipsModule;
import gmd.core.demo.client.application.page.collapsible.CollapsibleModule;
import gmd.core.demo.client.application.page.collection.CollectionModule;
import gmd.core.demo.client.application.page.color.ColorModule;
import gmd.core.demo.client.application.page.datepicker.DatePickerModule;
import gmd.core.demo.client.application.page.dialogs.DialogModule;
import gmd.core.demo.client.application.page.dropdown.DropdownModule;
import gmd.core.demo.client.application.page.errors.ErrorsModule;
import gmd.core.demo.client.application.page.fab.FabModule;
import gmd.core.demo.client.application.page.footer.FooterModule;
import gmd.core.demo.client.application.page.home.HomeModule;
import gmd.core.demo.client.application.page.icon.IconModule;
import gmd.core.demo.client.application.page.layout.LayoutModule;
import gmd.core.demo.client.application.page.listbox.ListBoxModule;
import gmd.core.demo.client.application.page.loaders.LoadersModule;
import gmd.core.demo.client.application.page.media.MediaModule;
import gmd.core.demo.client.application.page.navbar.NavBarModule;
import gmd.core.demo.client.application.page.pushpin.PushPinModule;
import gmd.core.demo.client.application.page.radiobutton.RadioButtonModule;
import gmd.core.demo.client.application.page.range.RangeModule;
import gmd.core.demo.client.application.page.scrollspy.ScrollspyModule;
import gmd.core.demo.client.application.page.search.SearchModule;
import gmd.core.demo.client.application.page.security.SecurityModule;
import gmd.core.demo.client.application.page.shadow.ShadowModule;
import gmd.core.demo.client.application.page.sidenavs.SideNavModule;
import gmd.core.demo.client.application.page.switches.SwitchModule;
import gmd.core.demo.client.application.page.tabs.TabsModule;
import gmd.core.demo.client.application.page.textfields.TextFieldModule;

public class ApplicationModule extends AbstractPresenterModule {

    @Override
    protected void configure() {
        install(new HomeModule());
        install(new AnimationModule());
        install(new BadgeModule());
        install(new BreadcrumbModule());
        install(new ButtonModule());
        install(new CardModule());
        install(new CheckboxModule());
        install(new ChipsModule());
        install(new CollapsibleModule());
        install(new CollectionModule());
        install(new ColorModule());
        install(new DatePickerModule());
        install(new DialogModule());
        install(new DropdownModule());
        install(new ErrorsModule());
        install(new FabModule());
        install(new FooterModule());
        install(new IconModule());
        install(new LayoutModule());
        install(new ListBoxModule());
        install(new LoadersModule());
        install(new MediaModule());
        install(new NavBarModule());
        install(new PushPinModule());
        install(new RadioButtonModule());
        install(new RangeModule());
        install(new ScrollspyModule());
        install(new SecurityModule());
        install(new SearchModule());
        install(new SideNavModule());
        install(new ShadowModule());
        install(new SwitchModule());
        install(new TabsModule());
        install(new TextFieldModule());

        bindPresenter(ApplicationPresenter.class, ApplicationPresenter.MyView.class, ApplicationView.class,
                ApplicationPresenter.MyProxy.class);
    }
}
