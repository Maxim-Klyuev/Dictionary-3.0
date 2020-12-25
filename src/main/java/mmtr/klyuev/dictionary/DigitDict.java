package mmtr.klyuev.dictionary;

public class DigitDict extends DictionaryMatchingCondition {

    private final String DIGIT_ALPHABET = "Incorrect input. Does not meet alphabet requirements.\nWords can only be 5 characters long and these characters are digits only.";
    
    @Override
    public boolean checkOfDictionaryResponse(String userInput) {
        String[] args = userInput.split(" ");
        boolean result = args[0].matches("\\d{5}");
        if (!result) {
            System.out.println(DIGIT_ALPHABET);
        }
        return result && args.length == 2;
    }
}