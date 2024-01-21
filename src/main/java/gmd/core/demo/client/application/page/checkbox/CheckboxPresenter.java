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
package gmd.core.demo.client.application.page.checkbox;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import gmd.core.demo.client.application.ApplicationPresenter;
import gmd.core.demo.client.application.page.AppPresenter;
import gmd.core.demo.client.place.NameTokens;

public class CheckboxPresenter extends AppPresenter<CheckboxPresenter.MyView, CheckboxPresenter.MyProxy> {
	interface MyView extends View {
	}

	@ProxyStandard
	@NameToken(NameTokens.CHECKBOX)
	interface MyProxy extends ProxyPlace<CheckboxPresenter> {
	}

	@Inject
	CheckboxPresenter(
		EventBus eventBus,
		MyView view,
		MyProxy proxy,
		PlaceManager placeManager) {
		super(eventBus, view, proxy, ApplicationPresenter.SLOT_MAIN, placeManager);
	}
}
