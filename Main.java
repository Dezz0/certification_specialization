import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Counter counter = new Counter()) {
            AnimalManager animalManager = new AnimalManager("animals.txt");
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("---------------------------------");
                System.out.println("Меню:");
                System.out.println("1. Завести новое животное");
                System.out.println("2. Определить класс животного");
                System.out.println("3. Увидеть список команд, которое выполняет животное");
                System.out.println("4. Обучить животное новым командам");
                System.out.println("5. Выход");
                System.out.print("Выберите действие: ");

                String choice = scanner.nextLine();

                switch (choice) {
                    case "1":
                        counter.add(); // Увеличиваем значение счетчика при добавлении нового животного
                        System.out.print("Введите имя нового животного: ");
                        String name = scanner.nextLine();
                        System.out.print("Введите тип нового животного: ");
                        String type = scanner.nextLine();
                        System.out.print("Введите список команд, которое выполняет животное: ");
                        String commands = scanner.nextLine();
                        animalManager.addAnimal(name, type, commands);
                        break;
                    case "2":
                        System.out.print("Введите имя животного: ");
                        String inputAnimalName = scanner.nextLine();
                        String animalType = animalManager.findAnimalType(inputAnimalName);
                        if (animalType != null) {
                            System.out.println("Животное " + inputAnimalName + " относится к классу: " + animalType);
                        } else {
                            System.out.println("Животное с таким именем не найдено.");
                        }
                        break;
                    case "3":
                        System.out.print("Введите имя животного: ");
                        String animalName = scanner.nextLine();
                        animalManager.showCommands(animalName);
                        break;
                    case "4":
                        System.out.print("Введите имя животного: ");
                        String inputAnimalName2 = scanner.nextLine();
                        System.out.print("Введите новую команду: ");
                        String newCommand = scanner.nextLine();
                        animalManager.addCommand(inputAnimalName2, newCommand);
                        break;
                    case "5":
                        System.out.println("Завершение работы программы.");
                        return; // Возвращаемся из метода main, закрывая программу
                    default:
                        System.out.println("Неверный выбор.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
