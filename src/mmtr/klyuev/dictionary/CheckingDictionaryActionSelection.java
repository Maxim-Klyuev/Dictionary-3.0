package mmtr.klyuev.dictionary;

public class CheckingDictionaryActionSelection extends CheckMenuItems {

    @Override
    public boolean checkOfMenuItemSelection(String userInput) {
        boolean result = userInput.matches("^[1-6]{1}");
        if (!result) {
            System.out.println(REPEAT);
        }
        return result;
    }
}