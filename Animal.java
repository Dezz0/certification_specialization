public class Animal {
    private String name;
    private String type;
    private String commands;

    public Animal(String name, String type, String commands) {
        this.name = name;
        this.type = type;
        this.commands = commands;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getCommands() {
        return commands;
    }

    public void addCommand(String newCommand) {
        commands += ", " + newCommand;
    }
}
