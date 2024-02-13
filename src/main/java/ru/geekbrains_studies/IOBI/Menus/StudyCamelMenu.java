package ru.geekbrains_studies.IOBI.Menus;

import ru.geekbrains_studies.Education.StudyCamelEducation;
import ru.geekbrains_studies.IOBI.Base.Menu;
import ru.geekbrains_studies.IOBI.Base.MenuItem;
import ru.geekbrains_studies.IOBI.Colors;
import ru.geekbrains_studies.IOBI.ConsoleIOBI;
import ru.geekbrains_studies.Infrastructure.Shared.IEducable;

import java.util.ArrayList;
import java.util.List;

public class StudyCamelMenu extends Menu {
    private final StudyCamelEducation education = new StudyCamelEducation();

    public StudyCamelMenu() {
        menuItems = new ArrayList<>();
        menuItems.add(new MenuItem(this::studyWalk, "Обучить ходить"));
        menuItems.add(new MenuItem(this::studyCarryLoad, "Обучить нести груз"));
        menuItems.add(new MenuItem(this::studySit, "Обучить сидеть"));
        menuItems.add(new MenuItem(this::studyRun, "Обучить бежать"));
        menuItems.add(new MenuItem(this::back, "вернуться назад в меню"));
    }

    private void educate(IEducable educable) {
        List<String> names = education.getAvailableCamelNames();
        if (names.isEmpty()) {
            ConsoleIOBI.println(Colors.RED + "Не найдено ни одного верблюда для обучения" + Colors.RESET);
        }
        ConsoleIOBI.println(Colors.GREEN + "Верблюды для обучения: " + names + Colors.RESET);
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

    public void studySit() {
        educate(education::learnCommandSit);
    }

    public void studyRun() {
        educate(education::learnCommandRun);
    }

    public void back() {
        ConsoleIOBI.setMenu(new StudyMenu());
    }
}