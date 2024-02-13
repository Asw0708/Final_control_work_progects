package ru.geekbrains_studies.Application.Base;

import ru.geekbrains_studies.Infrastructure.AnimalFabric;

import ru.geekbrains_studies.Infrastructure.DB.Db;
import ru.geekbrains_studies.Infrastructure.Farm;
import ru.geekbrains_studies.Infrastructure.DB.AnimalDb;


public abstract class Service {
    protected final Farm farm;
    protected final Db<Farm> db = new AnimalDb();

    protected Service() {
        farm = db.load();
        if (farm.getAllAnimals().isEmpty()) {
            AnimalFabric.fillAnimals(farm.getAllAnimals());
            db.save(farm);
        }
    }
}
