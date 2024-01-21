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
package gmd.core.demo.client.application.page.home;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gmd.core.demo.client.application.navigation.Dashboard;
import gmd.core.demo.client.application.widget.DashboardCard;
import gmd.core.demo.client.constants.AppConstants;
import gwt.material.design.client.ui.MaterialLink;
import gwt.material.design.client.ui.MaterialRow;

import javax.inject.Inject;
import java.util.List;

public class HomeView extends ViewImpl implements HomePresenter.MyView {

	interface Binder extends UiBinder<Widget, HomeView> {
	}

	@UiField
	MaterialRow dashboardsRow, videosRow;

	@UiField
	MaterialLink github, slack;

	@Inject
	HomeView(Binder uiBinder) {
		initWidget(uiBinder.createAndBindUi(this));

		github.setHref(AppConstants.GITHUB_REPO);
		slack.setHref(AppConstants.SLACK_CHANNEL);
	}

	@Override
	public void buildDashboards(List<Dashboard> dashboards) {
		dashboards.forEach(dashboard -> dashboardsRow.add(new DashboardCard(dashboard)));
	}

	@Override
	public void buildVideos(List<Dashboard> videos) {
		videos.forEach(video -> videosRow.add(new DashboardCard(video)));
	}
}
