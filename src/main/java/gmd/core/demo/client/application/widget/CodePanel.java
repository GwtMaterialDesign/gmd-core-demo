package gmd.core.demo.client.application.widget;

import com.google.gwt.dom.client.Document;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.ui.html.Pre;

import static gwt.material.design.jquery.client.api.JQuery.$;

public class CodePanel extends MaterialWidget {

    private Pre pre = new Pre();

    public CodePanel() {
        super(Document.get().createDivElement());
    }

    @Override
    protected void onLoad() {
        super.onLoad();


        String html = new String();
        for (Widget widget : getChildren()) {
            html = html + $(widget.getElement()).html();
        }
        html.replace(">", "&gt;")
                .replace("<", "&lt;");

        pre.setHTML(html);
        add(pre);
    }
}
