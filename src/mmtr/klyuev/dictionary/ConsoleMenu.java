package mmtr.klyuev.dictionary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Scanner;
import java.util.Formatter;

public class ConsoleMenu {

    @Autowired
    private DictionaryStorage dictionaryStorageOnFileSystem;

    @Autowired
    @Qualifier("latinDict")
    private DictionaryMatchingCondition latinDict;

    @Autowired
    @Qualifier("digitDict")
    private DictionaryMatchingCondition digitDict;

    @Autowired
    @Qualifier("checkingDictionarySelection")
    private CheckMenuItems checkingDictionarySelection;

    @Autowired
    @Qualifier("checkingDictionaryActionSelection")
    private CheckMenuItems checkingDictionaryActionSelection;

    @Autowired
    @Qualifier("checkExitPointFromMethod")
    private CheckMenuItems checkExitPointFromMethod;

    private Formatter formatter = new Formatter();
    private Scanner in = new Scanner(System.in);

    private final String DELIMITER = "=========================================================================";
    private final String GREETING = "You are welcome by the translator.";
    private final String DICTIONARIES = "Select a dictionary.\n" + "1. Latin Dictionary.\n2. Digit Dictionary.\n3. Exit.";
    private final String LIST_OF_ACTIONS = "1. Show dictionary contents.\n2. Translate one word." +
            "\n3. Add word to dictionary.\n4. Delete word from dictionary." +
            "\n5. Back to dictionary selection.\n6. Exit.";
    private final String SELECT_ACT = "Select an action.\n" + LIST_OF_ACTIONS;
    private final String CONTENTS_DICT = "Contents of the dictionary:";
    private final String ENTER_WORD_TRANSLATE = "Enter a word to translate.";
    private final String ENTER_WORD_ADD = "Enter a key-value pair after SPACE to add to the dictionary.";
    private final String ENTER_WORD_DEL = "Enter a key to remove an entry from the dictionary.";
    private final String TRANSLATE = "Translation by key <%s> :";
    private final String ADD = "Entry <%s> added.";
    private final String DELETE = "Key entry <%s> deleted.";
    private final String LATIN_ALPHABET = "Words can only be 4 characters long and these characters are Latin only.";
    private final String DIGIT_ALPHABET = "Words can only be 5 characters long and these characters are digits only.";
    private final String EXIT = "2. Exit.";
    private final String BACK = "1. Back.";
    private final String ONE_BACK = "1";
    private final String TWO_EXIT = "2";
    private final String ERROR_DELETE = "This word is not in the dictionary.";

    private void showTemplate(String str) {
        System.out.println(DELIMITER);
        System.out.println(str);
        System.out.println(DELIMITER);
    }

    private void useFormatter(String userInput, String s) {
        formatter = new Formatter();
        formatter.format(s, userInput);
        System.out.println(formatter);
        formatter.close();
    }

    private String correctSelection(CheckMenuItems check, String menuItemBar) {
        String userInput = in.nextLine().trim();
        while (!check.checkOfMenuItemSelection(userInput)) {
            System.out.println(menuItemBar);
            userInput = in.nextLine().trim();
        }
        return userInput;
    }


    public void consoleGreeting() {
        showTemplate(GREETING);
    }

    public String consoleShowDictionaryFiles() {
        showTemplate(DICTIONARIES);
        return correctSelection(checkingDictionarySelection, DICTIONARIES + "\n" + DELIMITER);
    }

    public String consoleShowMenu() {
        showTemplate(SELECT_ACT);
        return correctSelection(checkingDictionaryActionSelection, SELECT_ACT + "\n" + DELIMITER);
    }

    public String consoleShowAllWords() {
        showTemplate(CONTENTS_DICT);
        System.out.println(dictionaryStorageOnFileSystem.showAllWords());
        showTemplate(BACK + "\n" + EXIT);
        return correctSelection(checkExitPointFromMethod, BACK + "\n" + EXIT + "\n" + DELIMITER);
    }

    public String consoleShowTranslationOneWord() {
        showTemplate(ENTER_WORD_TRANSLATE + "\n" + LATIN_ALPHABET + "\n" + BACK + "\n" + EXIT);
        String userInput = in.nextLine().trim().toLowerCase();
        while (!userInput.equals(ONE_BACK) && !userInput.equals(TWO_EXIT)) {
            useFormatter(userInput, TRANSLATE);
            System.out.println(dictionaryStorageOnFileSystem.translateOneWord(userInput));
            showTemplate(ENTER_WORD_TRANSLATE + "\n" + LATIN_ALPHABET + "\n" + BACK + "\n" + EXIT);
            userInput = in.nextLine().trim().toLowerCase();
        }
        return userInput;
    }

    public void consoleAddWord() {
        showTemplate(ENTER_WORD_ADD + "\n" + BACK + "\n" + EXIT);
        String userInput = in.nextLine().trim().toLowerCase();
        while (!userInput.equals(ONE_BACK) && !userInput.equals(TWO_EXIT)) {
            if (latinDict.checkOfDictionaryResponse(userInput)) {
                dictionaryStorageOnFileSystem.addWord(userInput);
                useFormatter(userInput, ADD);
            }
            showTemplate(ENTER_WORD_ADD + "\n" + BACK + "\n" + EXIT);
            userInput = in.nextLine().trim().toLowerCase();
        }
    }

    public void consoleDeleteWord() {
        showTemplate(ENTER_WORD_DEL + "\n" + BACK + "\n" + EXIT);
        String userInput = in.nextLine().trim().toLowerCase();
        while (!userInput.equals(ONE_BACK) && !userInput.equals(TWO_EXIT)) {
            if (dictionaryStorageOnFileSystem.deleteWord(userInput)) {
                dictionaryStorageOnFileSystem.deleteWord(userInput);
                useFormatter(userInput, DELETE);
            } else System.out.println(ERROR_DELETE);
            showTemplate(ENTER_WORD_DEL + "\n" + BACK + "\n" + EXIT);
            userInput = in.nextLine().trim().toLowerCase();
        }
    }

    public void runConsole() {
        consoleGreeting();
    }
}