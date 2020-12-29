package mmtr.klyuev.dictionary;

public class CheckExitPointFromMethod extends CheckMenuItems {

    @Override
    public boolean checkOfMenuItemSelection(String userInput) {
        boolean result = userInput.matches("^[1-2]{1}");
        if (!result) {
            System.out.println(REPEAT);
        }
        return result;
    }
}
