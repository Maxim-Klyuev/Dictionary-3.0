package mmtr.klyuev.dictionary;

public class LatinDict extends DictionaryMatchingCondition {

    private final String LATIN_ALPHABET = "Incorrect input. Does not meet alphabet requirements.\nWords can only be 4 characters long and these characters are Latin only.";

    @Override
    public boolean checkOfDictionaryResponse(String userInput) {
        String[] args = userInput.split(" ");
        boolean result = args[0].matches("^[a-z]{4}");
        if (!result) {
            System.out.println(LATIN_ALPHABET);
        }
        return result && args.length == 2;
    }
}