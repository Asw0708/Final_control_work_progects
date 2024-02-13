package ru.geekbrains_studies.Application.Services;

import ru.geekbrains_studies.Animals.Base.Animal;
import ru.geekbrains_studies.Animals.PackAnimals.Camel.Camel;
import ru.geekbrains_studies.Animals.PackAnimals.Donkey.Donkey;
import ru.geekbrains_studies.Animals.PackAnimals.Horse.Horse;
import ru.geekbrains_studies.Animals.Pets.Cat.Cat;
import ru.geekbrains_studies.Animals.Pets.Dog.Dog;
import ru.geekbrains_studies.Animals.Pets.Hamster.Hamster;
import ru.geekbrains_studies.Application.Base.Service;
import java.util.Date;

public class AddAnimalService extends Service {


    public void addCat(String name, Date birthday) {
        addAnimal(Cat.create(name, birthday));
    }

    public void addDog(String name, Date birthday) {
        addAnimal(Dog.create(name, birthday));
    }

    public void addHamster(String name, Date birthday) {
        addAnimal(Hamster.create(name, birthday));
    }

    public void addHorse(String name, Date birthday) {
        addAnimal(Horse.create(name, birthday));
    }

    public void addCamel(String name, Date birthday) {
        addAnimal(Camel.create(name, birthday));
    }

    public void addDonkey(String name, Date birthday) {
        addAnimal(Donkey.create(name, birthday));
    }


    private void addAnimal(Animal animal) {
        farm.addAnimal(animal);
        db.save(farm);
    }


}
