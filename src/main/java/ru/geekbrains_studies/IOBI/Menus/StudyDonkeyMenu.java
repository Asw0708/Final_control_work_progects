package ru.geekbrains_studies.IOBI.Menus;

import ru.geekbrains_studies.Education.StudyDonkeyEducation;
import ru.geekbrains_studies.IOBI.Colors;
import ru.geekbrains_studies.IOBI.ConsoleIOBI;
import ru.geekbrains_studies.Infrastructure.Shared.IEducable;
import ru.geekbrains_studies.IOBI.Base.MenuItem;
import ru.geekbrains_studies.IOBI.Base.Menu;

import java.util.ArrayList;
import java.util.List;

public class StudyDonkeyMenu extends Menu {

    private final StudyDonkeyEducation education = new StudyDonkeyEducation();

    public StudyDonkeyMenu() {
        menuItems = new ArrayList<>();
        menuItems.add(new MenuItem(this::studyWalk, "Обучить ходить"));
        menuItems.add(new MenuItem(this::studyCarryLoad, "Обучить нести груз"));
        menuItems.add(new MenuItem(this::studyBray, "Обучить дать голос"));
        menuItems.add(new MenuItem(this::studyKick, "Обучить лягнуть"));
        menuItems.add(new MenuItem(this::back, "назад"));
    }

    private void educate(IEducable educable) {
        List<String> names = education.getAvailableDonkeyNames();
        if (names.isEmpty()) {
            ConsoleIOBI.println(Colors.RED + "Не найдено ни одного осла для обучения" + Colors.RESET);
        }
        ConsoleIOBI.println(Colors.GREEN + "Ослы для обучения: " + names + Colors.RESET);
        ConsoleIOBI.println(Colors.YELLOW + "Введите имя: " + Colors.RESET);
        String name = ConsoleIOBI.chooseName(names);
        ConsoleIOBI.println(Colors.YELLOW + educable.invoke(name) + Colors.RESET);
    }

    public void studyWalk() {
        educate(education::learnCommandWalk);
    }

    public void studyCarryLoad() {
        educate(education::learnCommandCarryLoad);
    }

    public void studyBray() {
        educate(education::learnCommandBray);
    }

    public void studyKick() {
        educate(education::learnCommandKick);
    }

    public void back() {
        ConsoleIOBI.setMenu(new StudyMenu());
    }
}