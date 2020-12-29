package mmtr.klyuev.dictionary;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Dictionary {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        ConsoleMenu consoleMenu = context.getBean("consoleMenu", ConsoleMenu.class);

        consoleMenu.consoleGreeting();
        consoleMenu.consoleShowDictionaryFiles();
        consoleMenu.consoleShowMenu();
        consoleMenu.consoleShowAllWords();
        consoleMenu.consoleShowTranslationOneWord();
        consoleMenu.consoleAddWord();
        consoleMenu.consoleDeleteWord();
//        consoleMenu.runConsole();

        context.close();
    }
}
