package ru.geekbrains_studies.IOBI.Menus;

import ru.geekbrains_studies.Education.StudyCatEducation;
import ru.geekbrains_studies.IOBI.Base.Menu;
import ru.geekbrains_studies.IOBI.Base.MenuItem;
import ru.geekbrains_studies.IOBI.Colors;
import ru.geekbrains_studies.IOBI.ConsoleIOBI;
import ru.geekbrains_studies.Infrastructure.Shared.IEducable;

import java.util.ArrayList;
import java.util.List;

public class StudyCatMenu extends Menu {
    private final StudyCatEducation education = new StudyCatEducation();

    public StudyCatMenu() {
        menuItems = new ArrayList<>();
        menuItems.add(new MenuItem(this::studySit, "Обучить сидеть"));
        menuItems.add(new MenuItem(this::studyPounce, "Обучить идти ко мне"));
        menuItems.add(new MenuItem(this::studyScratch, "Обучить царапать"));
        menuItems.add(new MenuItem(this::studyMeow, "Обучить голосу"));
        menuItems.add(new MenuItem(this::studyJump, "Обучить прыжку"));
        menuItems.add(new MenuItem(this::back, "назад"));
    }

    private void educate(IEducable educable) {
        List<String> names = education.getAvailableCatNames();
        if (names.isEmpty()) {
            ConsoleIOBI.println(Colors.RED + "Не найдено ни одной кошки для обучения" + Colors.RESET);
        }
        ConsoleIOBI.println(Colors.GREEN + "Коты/кошки для обучения: " + names + Colors.RESET);
        ConsoleIOBI.println(Colors.YELLOW + "Введите имя: " + Colors.RESET);
        String name = ConsoleIOBI.chooseName(names);
        ConsoleIOBI.println(Colors.YELLOW + educable.invoke(name) + Colors.RESET);
    }

    public void studySit() {
        educate(education::learnCommandSit);
    }

    public void studyPounce() {
        educate(education::learnCommandPounce);
    }

    public void studyScratch() {
        educate(education::learnCommandScratch);
    }

    public void studyMeow() {
        educate(education::learnCommandMeow);
    }

    public void studyJump() {
        educate(education::learnCommandJump);
    }

    public void back() {
        ConsoleIOBI.setMenu(new StudyMenu());
    }
}
