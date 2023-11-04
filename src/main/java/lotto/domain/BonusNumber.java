package lotto.domain;

public class BonusNumber {
    int bonusNumber;

    public BonusNumber(String inputBonusNumber) {
        validateInputBonusNumber(inputBonusNumber);
        bonusNumber = Integer.parseInt(inputBonusNumber);
    }

    public void validateInputBonusNumber(String inputValue) {
        validateOnlyNumber(inputValue);
        validateBetweenMinNumberAndMaxNumber(inputValue);
    }

    private void validateOnlyNumber(String content) {
        if(!content.matches("[0-9]+")) {
            throw new IllegalArgumentException();
        }
    }

    private int validateBetweenMinNumberAndMaxNumber(String content) {
        int result = Integer.parseInt(content);
        if(result < 0 || 45 < result) {
            throw new IllegalArgumentException();
        }
        return result;
    }
}
