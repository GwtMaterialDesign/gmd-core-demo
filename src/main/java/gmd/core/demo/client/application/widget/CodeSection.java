package gmd.core.demo.client.application.widget;

import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialPanel;

public class CodeSection extends MaterialPanel {

    private MaterialLabel titleLabel = new MaterialLabel();
    private MaterialLabel descriptionLabel = new MaterialLabel();
    private String sectionTitle;
    private String description;

    public CodeSection() {
        super();

        setPadding(40);
    }

    public CodeSection(String title, String description) {
        this();
        this.sectionTitle = title;
        this.description = description;
    }

    @Override
    protected void onLoad() {
        super.onLoad();


        if (sectionTitle != null) {
            titleLabel.setFontSize("1.4em");
            titleLabel.setText(sectionTitle);
            insert(titleLabel, 0);
        }

        if (description != null) {
            descriptionLabel.setMarginBottom(20);
            descriptionLabel.setText(description);
            insert(descriptionLabel, 1);
        }
    }

    public MaterialLabel getTitleLabel() {
        return titleLabel;
    }

    public void setTitleLabel(MaterialLabel titleLabel) {
        this.titleLabel = titleLabel;
    }

    public MaterialLabel getDescriptionLabel() {
        return descriptionLabel;
    }

    public void setDescriptionLabel(MaterialLabel descriptionLabel) {
        this.descriptionLabel = descriptionLabel;
    }

    public String getSectionTitle() {
        return sectionTitle;
    }

    public void setSectionTitle(String sectionTitle) {
        this.sectionTitle = sectionTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
