import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AnimalManager {
    private ArrayList<Animal> animals;
    private File databaseFile;

    public String findAnimalType(String animalName) {
        for (Animal animal : animals) {
            if (animal.getName().equalsIgnoreCase(animalName)) {
                return animal.getType();
            }
        }
        return null; // Если животное не найдено, возвращаем null
    }

    public AnimalManager(String filename) {
        animals = new ArrayList<>();
        databaseFile = new File(filename);
        loadDatabase();
    }

    private void loadDatabase() {
        try {
            Scanner scanner = new Scanner(databaseFile);
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(",");
                animals.add(new Animal(data[0], data[1], data[2]));
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addAnimal(String name, String type, String commands) {
        animals.add(new Animal(name, type, commands));
        saveDatabase();
    }

    public void addCommand(String animalName, String newCommand) {
        for (Animal animal : animals) {
            if (animal.getName().equals(animalName)) {
                animal.addCommand(newCommand);
                saveDatabase();
                return;
            }
        }
        System.out.println("Животное не найдено.");
    }

    public void showCommands(String animalName) {
        for (Animal animal : animals) {
            if (animal.getName().equals(animalName)) {
                System.out.println("Команды для животного " + animal.getName() + ": " + animal.getCommands());
                return;
            }
        }
        System.out.println("Животное не найдено.");
    }

    private void saveDatabase() {
        try {
            FileWriter writer = new FileWriter(databaseFile);
            for (Animal animal : animals) {
                writer.write(animal.getName() + "," + animal.getType() + "," + animal.getCommands() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
