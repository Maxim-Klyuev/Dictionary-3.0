package mmtr.klyuev.dictionary;

public interface DictionaryStorage {

    String showAllWords();

    String translateOneWord(String userInput);

    void addWord(String userInput);

    boolean deleteWord(String userInput);
}