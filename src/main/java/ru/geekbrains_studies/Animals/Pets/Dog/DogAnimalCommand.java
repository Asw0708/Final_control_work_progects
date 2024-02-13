package ru.geekbrains_studies.Animals.Pets.Dog;



import ru.geekbrains_studies.Animals.Base.AnimalCommand;

import java.util.UUID;

public class DogAnimalCommand extends AnimalCommand {

    public static final String SIT = "Сидеть";
    public static final String STAY = "Стоять";
    public static final String FETCH = "Аппорт";
    public static final String PAW = "Дать лапу";
    public static final String BARK = "Голос";
    public static final String ROLL = "Свернуть";

    private DogAnimalCommand(UUID id, UUID animalId, String title) {
        super(id, animalId, title);
    }

    public static DogAnimalCommand commandSit(UUID animalId){
        return new DogAnimalCommand(UUID.randomUUID(), animalId, SIT);
    }

    public static DogAnimalCommand commandStay(UUID animalId){
        return new DogAnimalCommand(UUID.randomUUID(), animalId, STAY);
    }

    public static DogAnimalCommand commandFetch(UUID animalId){
        return new DogAnimalCommand(UUID.randomUUID(), animalId, FETCH);
    }

    public static DogAnimalCommand commandPaw(UUID animalId){
        return new DogAnimalCommand(UUID.randomUUID(), animalId, PAW);
    }

    public static DogAnimalCommand commandBark(UUID animalId){
        return new DogAnimalCommand(UUID.randomUUID(), animalId, BARK);
    }
    public static DogAnimalCommand commandRoll(UUID animalId){
        return new DogAnimalCommand(UUID.randomUUID(), animalId, ROLL);
    }
}
