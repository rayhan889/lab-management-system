package source.data.tool;

enum ToolCategory {
    HEAVY,
    SMALL
}

public class Tool {
    protected String code;
    protected String name;
    protected String description;
    protected ToolCategory category;

    public Tool(String code, String name, String description, ToolCategory category) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.category = category;
    }

    public String getCode() {return code;}
    public void setCode(String code) {this.code = code;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}
    public ToolCategory getCategory() {return category;}
    public void setCategory(ToolCategory category) {this.category = category;}

    @Override
    public String toString() {
        return "Tool [code=" + code
                + ", name=" + name
                + ", description=" + description
                + ", category=" + category + "]";
    }
}
