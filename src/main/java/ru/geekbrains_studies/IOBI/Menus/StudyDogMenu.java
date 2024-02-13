package ru.geekbrains_studies.IOBI.Menus;

import ru.geekbrains_studies.Education.StudyDogEducation;
import ru.geekbrains_studies.IOBI.Colors;
import ru.geekbrains_studies.IOBI.ConsoleIOBI;
import ru.geekbrains_studies.Infrastructure.Shared.IEducable;
import ru.geekbrains_studies.IOBI.Base.MenuItem;
import ru.geekbrains_studies.IOBI.Base.Menu;

import java.util.ArrayList;
import java.util.List;

public class StudyDogMenu extends Menu {
    private final StudyDogEducation education = new StudyDogEducation();

    public StudyDogMenu() {
        menuItems = new ArrayList<>();
        menuItems.add(new MenuItem(this::studyBark, "Обучить дать голос"));
        menuItems.add(new MenuItem(this::studyFetch, "Обучить принести"));
        menuItems.add(new MenuItem(this::studyRoll, "Обучить катить"));
        menuItems.add(new MenuItem(this::studyPaw, "Обучить дать лапу"));
        menuItems.add(new MenuItem(this::studySit, "Обучить сидеть"));
        menuItems.add(new MenuItem(this::studyStay, "Обучить стоять на месте"));
        menuItems.add(new MenuItem(this::back, "назад"));
    }

    private void educate(IEducable educable) {
        List<String> names = education.getAvailableDogNames();
        if (names.isEmpty()) {
            ConsoleIOBI.println(Colors.RED + "Не найдено ни одной собаки для обучения" + Colors.RESET);
        }
        ConsoleIOBI.println(Colors.GREEN + "Собаки для обучения: " + names + Colors.RESET);
        ConsoleIOBI.println(Colors.YELLOW + "Введите имя: " + Colors.RESET);
        String name = ConsoleIOBI.chooseName(names);
        ConsoleIOBI.println(Colors.YELLOW + educable.invoke(name) + Colors.RESET);
    }


    public void studyBark() {educate(education::learnCommandBark);
    }

    public void studyPaw() {
        educate(education::learnCommandPaw);
    }

    public void studyRoll() {
        educate(education::learnCommandRoll);
    }

    public void studyFetch() {
        educate(education::learnCommandFetch);
    }

    public void studySit() {
        educate(education::learnCommandSit);
    }

    public void studyStay() {
        educate(education::learnCommandStay);
    }

    public void back() {
        ConsoleIOBI.setMenu(new StudyMenu());
    }
}
