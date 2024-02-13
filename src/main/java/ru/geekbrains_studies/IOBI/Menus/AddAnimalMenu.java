package ru.geekbrains_studies.IOBI.Menus;

import ru.geekbrains_studies.Infrastructure.Shared.ICreatable;
import ru.geekbrains_studies.Education.AddAnimalEducation;
import ru.geekbrains_studies.IOBI.Base.Menu;
import ru.geekbrains_studies.IOBI.Base.MenuItem;
import ru.geekbrains_studies.IOBI.ConsoleIOBI;

import java.util.ArrayList;
import java.util.Date;

public class AddAnimalMenu extends Menu {
    private final AddAnimalEducation education = new AddAnimalEducation();

    public AddAnimalMenu() {
        menuItems = new ArrayList<>();
        menuItems.add(new MenuItem(this::addDog, "Добавить собаку"));
        menuItems.add(new MenuItem(this::addCat, "Добавить кошку"));
        menuItems.add(new MenuItem(this::addHamster, "Добавить хомяка"));
        menuItems.add(new MenuItem(this::addHorse, "Добавить лошадь"));
        menuItems.add(new MenuItem(this::addCamel, "Добавить верблюда"));
        menuItems.add(new MenuItem(this::addDonkey, "Добавить осла"));
        menuItems.add(new MenuItem(this::back, "назад в меню"));
    }

    public void back() {
        ConsoleIOBI.setMenu(new MainMenu());
    }

    private void addAnimal(ICreatable creator) {
        ConsoleIOBI.println("Введите имя: (мин. 4 буквы)");
        String name = ConsoleIOBI.getStringInput(4);
        ConsoleIOBI.println("Введите дату рождения: (формат: 'дд-мм-гггг')");
        Date birthday = ConsoleIOBI.getDateInput();
        creator.invoke(name, birthday);
    }

    public void addCat() {
        addAnimal(education::addCat);
    }

    public void addDog() {
        addAnimal(education::addDog);
    }

    public void addHamster() {
        addAnimal(education::addHamster);
    }

    public void addHorse() {
        addAnimal(education::addHorse);
    }

    public void addCamel() {
        addAnimal(education::addCamel);
    }

    public void addDonkey() {
        addAnimal(education::addDonkey);
    }
}
