package source.data.inventory;

import source.data.tool.Tool;

import java.util.EmptyStackException;
import java.util.Stack;

public class Inventory {
    public static final int MAX_INVENTORY_CAPACITY = 20;

    private String inventoryID;
    private String inventoryName;
    private String location;
    private Stack<Tool> tools = new Stack<>();

    @SuppressWarnings("all")
    public Inventory(String inventoryID, String inventoryName, String location) {
        this.inventoryID = inventoryID;
        this.inventoryName = inventoryName + " Inventory";
        this.location = location;
        this.tools = new Stack<>();
    }

    public String getInventoryID() {return inventoryID;}
    public void setInventoryID(String inventoryID) {this.inventoryID = inventoryID;}
    public String getLocation() {return location;}
    public void setLocation(String location) {this.location = location;}
    public Stack<Tool> getTools() {return tools;}
    public void setTools(Stack<Tool> tools) {this.tools = tools;}

    public void push(Tool tool) {
        if (tool == null) {
            throw new IllegalArgumentException("Tool cannot be null");
        }

        for (Tool toolEntry : tools) {
            if (toolEntry.getCode().equals(tool.getCode())) {
                throw new IllegalArgumentException("Tool with code " + tool.getCode() + " already exists");
            }
        }

        if (tools.size() >= MAX_INVENTORY_CAPACITY) {
            throw new IllegalStateException("Inventory is full");
        }

        if (!inventoryName.contains(tool.getName())) {
            throw new IllegalArgumentException("Tool category does not match inventory name");
        }

        tools.push(tool);
    }

    public Tool pop() {
        if(tools.isEmpty()) {
            throw new EmptyStackException();
        } else {
            return tools.pop();
        }
    }

    public Tool peek() {
        if(tools.isEmpty()) {
            throw new EmptyStackException();
        } else {
            return tools.peek();
        }
    }

    public boolean contains(Tool tool) {
        return tools.contains(tool);
    }

    public int size() {
        return tools.size();
    }

    public boolean isEmpty() {
        return tools.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Inventory Stack (top to bottom):\\n");
        for (int i=tools.size()-1; i>=0; i--) {
            sb.append(tools.get(i));
        }
        return sb.toString();
    }
}
