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
package gmd.core.demo.client.application.page.animation;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.client.ui.*;
import gwt.material.design.client.ui.animate.MaterialAnimation;
import gwt.material.design.client.ui.animate.Transition;
import gwt.material.design.client.ui.html.UnorderedList;

import javax.inject.Inject;

public class AnimationView extends ViewImpl implements AnimationPresenter.MyView {
    interface Binder extends UiBinder<Widget, AnimationView> {
    }

    @UiField
    MaterialCard card;

    @UiField
    MaterialButton iconHeart, iconCallback;

    @UiField
    MaterialListBox lstAnimations;

    @UiField
    UnorderedList listContainer;

    @UiField
    MaterialImage image;

    @UiField
    MaterialRow gridPanel;

    private MaterialAnimation infiniteAnimation;

    @Inject
    AnimationView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    protected void onAttach() {
        super.onAttach();

        buildSelection();
    }

    protected void buildSelection() {
        int i = 0;
        for (Transition transition : Transition.values()) {
            // skip the first four animations
            if (i >= 4) {
                lstAnimations.addItem(transition.getCssName());
            }
            i++;
        }
    }

    @UiHandler("btnAnimate")
    void onAnimateCoreTransition(ClickEvent e) {
        animate();
    }

    @UiHandler("lstAnimations")
    void onAnimateWithListBox(ValueChangeEvent<String> e) {
        animate();
    }

    private void animate() {
        String value = lstAnimations.getSelectedValue();
        Transition transition = Transition.fromStyleName(value);
        MaterialAnimation animation = new MaterialAnimation();
        animation.setTransition(transition);
        animation.setDelay(0);
        animation.setDuration(1000);
        animation.setInfinite(false);
        animation.animate(card);
    }

    @UiHandler("btnAnimateInfinite")
    void onAnimateInfinite(ClickEvent e) {
        infiniteAnimation = new MaterialAnimation();
        infiniteAnimation.setDelay(0);
        infiniteAnimation.setTransition(Transition.PULSE);
        infiniteAnimation.setDuration(1000);
        infiniteAnimation.setInfinite(true);
        infiniteAnimation.animate(iconHeart);
    }

    @UiHandler("btnStopAnimation")
    void onStopAnimation(ClickEvent e) {
        infiniteAnimation.stopAnimation();
    }

    @UiHandler("btnAnimateCallback")
    void onCallback(ClickEvent e) {
        MaterialAnimation animation = new MaterialAnimation();
        animation.setDelay(0);
        animation.setDuration(1000);
        animation.transition(Transition.FLIPINX);
        animation.animate(iconCallback, () -> {
            MaterialToast.fireToast("Animation is finished");
        });
    }

    @UiHandler("btnCloseGrid")
    void onCloseGrid(ClickEvent e) {
        MaterialAnimation gridAnimation = new MaterialAnimation();
        gridAnimation.setTransition(Transition.CLOSE_GRID);
        gridAnimation.animate(gridPanel);
    }

    @UiHandler("btnShowGrid")
    void onShowGrid(ClickEvent e) {
        MaterialAnimation gridAnimation = new MaterialAnimation();
        gridAnimation.setTransition(Transition.SHOW_GRID);
        gridAnimation.animate(gridPanel);
    }

    @UiHandler("btnStaggered")
    void onStaggered(ClickEvent e) {
        MaterialAnimation gridAnimation = new MaterialAnimation();
        gridAnimation.setTransition(Transition.SHOW_STAGGERED_LIST);
        gridAnimation.animate(listContainer);
    }

    @UiHandler("btnFade")
    void onFade(ClickEvent e) {
        MaterialAnimation gridAnimation = new MaterialAnimation();
        gridAnimation.setTransition(Transition.FADE_IN_IMAGE);
        gridAnimation.animate(image);
    }
}
