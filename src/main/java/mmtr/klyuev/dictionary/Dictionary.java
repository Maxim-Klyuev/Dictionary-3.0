package mmtr.klyuev.dictionary;

public class Dictionary {

    public static void main(String[] args) {
		ConsoleMenu consoleMenu = new ConsoleMenu();
        consoleMenu.consoleGreeting();
        consoleMenu.consoleShowDictionaryFiles();
        consoleMenu.consoleShowMenu();
        consoleMenu.consoleShowAllWords();
        consoleMenu.consoleShowTranslationOneWord();
        consoleMenu.consoleAddWord();
        consoleMenu.consoleDeleteWord();
//        consoleMenu.runConsole();
    }
}
