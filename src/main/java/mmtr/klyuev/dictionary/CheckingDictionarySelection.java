package mmtr.klyuev.dictionary;

public class CheckingDictionarySelection extends CheckMenuItems {
	
    @Override
    public boolean checkOfMenuItemSelection(String userInput) {
        boolean result = userInput.matches("^[1-3]{1}");
        if (!result) {
            System.out.println(REPEAT);
        }
        return result;
    }
}