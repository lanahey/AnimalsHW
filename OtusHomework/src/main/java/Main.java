import animals.Animal;
import data.AnimalInputData;
import data.ColorsData;
import data.CommandsData;
import factory.AnimalFactory;
import tables.AbsTable;
import tables.AnimalTable;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static selectors.UserSelector.*;

public class Main {
    public static void main(String... args) throws SQLException {
        List<Animal> animals = new ArrayList<>();
        //AnimalTable animalTable = new AnimalTable();

        Scanner scanner = new Scanner(System.in);

        CommandsData[] commandsData = CommandsData.values();
        String[] commandsStr = new String[commandsData.length];
        for (int i = 0; i < commandsData.length; i++){
            commandsStr[i] = commandsData[i].name().toLowerCase();
        }

        while(true) {
            System.out.printf("Введите одну из команд: %s\n", String.join("/", commandsStr));
            CommandsData userCommandData = selectCommand(scanner);

            switch (userCommandData) {
                case ADD -> {
                    AnimalInputData userAnimalInputData = selectAnimal(scanner);

                    AnimalFactory animalFactory = new AnimalFactory();
                    Animal userAnimal = animalFactory.create(userAnimalInputData);

                    //userAnimal.setType(userAnimalData);

                    System.out.println("Введите имя животного");
                    String name = scanner.next();
                    userAnimal.setName(name);

                    userAnimal.setAge(getAge(scanner));

                    userAnimal.setWeight(getWetgh(scanner));

                    userAnimal.setColor(ColorsData.valueOf(String.valueOf(selectAnimalColor(scanner))));
                    animals.add(userAnimal);


                    //List<String> columns = new ArrayList<>();
                    //columns.add("id int");


                    //animalTable.createTable();
                    //animalTable.insert(userAnimal);

                    userAnimal.say();
                }
                case LIST -> {
                    System.out.println("Вы ввели List");
                    for(Animal animal: animals){
                        System.out.println(animal.toString());
                    }

                    /*ArrayList<Animal> animalsList = animalTable.selectAll();
                    System.out.println("Вывод таблицы животных:");
                    for (Animal tmp:animalsList){
                        System.out.println(tmp.toString());
                    }*/

                }
                case DELETE -> {
                    System.out.println("Вы ввели Delete");
                    System.out.println("Введите id животного, которое вы хотите удалить?");
                    //animalTable.delete(getId(scanner));
                }

                case UPDATE -> {
                    System.out.println("Вы ввели Update");
                    System.out.println("Введите id животного, которое вы хотите отредактировать?");
                    //animalTable.update(getId(scanner));
                }

                case EXIT -> {
                    System.out.println("До новых встреч!");
                    System.exit(0);
                }
            }
        }
    }



}
