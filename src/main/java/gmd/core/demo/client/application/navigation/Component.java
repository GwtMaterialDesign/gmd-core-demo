package gmd.core.demo.client.application.navigation;

public class Component {

    private String name;
    private String description;
    private String href;
    private String javaSource;
    private String xmlSource;

    public Component() {}

    public Component(String name, String description, String href) {
        this.name = name;
        this.description = description;
        this.href = href;
    }

    public Component(String href, String description) {
        this.href = href;
        this.description = description;
        this.name = generateName(href);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static String generateName(String href) {
        String output = href.replaceAll("([A-Z][a-z]+)", " $1") // Words beginning with UC
                .replaceAll("([A-Z][A-Z]+)", " $1") // "Words" of only UC
                .replaceAll("([^A-Za-z ]+)", " $1") // "Words" of non-letters
                .trim();

        output = output.substring(0, 1).toUpperCase() + output.substring(1);
        return output;
    }

    public String getJavaSource() {
        return javaSource;
    }

    public void setJavaSource(String javaSource) {
        this.javaSource = javaSource;
    }

    public String getXmlSource() {
        return xmlSource;
    }

    public void setXmlSource(String xmlSource) {
        this.xmlSource = xmlSource;
    }
}
