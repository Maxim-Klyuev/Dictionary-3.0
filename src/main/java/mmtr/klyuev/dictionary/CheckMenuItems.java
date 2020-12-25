package mmtr.klyuev.dictionary;

public abstract class CheckMenuItems {

    protected final String REPEAT = "Incorrect input. There is no such item in the menu. Repeat please.";

    public abstract boolean checkOfMenuItemSelection(String userInput);
}