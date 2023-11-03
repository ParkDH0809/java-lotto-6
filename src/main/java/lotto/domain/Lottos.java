package lotto.domain;

import lotto.service.LottoService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {
    int numberOfLottos;
    List<Lotto> lottos = new ArrayList<>();
    public Lottos(String purchaseAmount) {
        numberOfLottos = validatePurchaseAmount(purchaseAmount);
        initEachLotto();
    }

    private int validatePurchaseAmount(String purchaseAmount) {
        validateNumber(purchaseAmount);
        return validateDivisibilityByLottoPrice(purchaseAmount);
    }

    private void validateNumber(String purchaseAmount) {
        try {
            Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private int validateDivisibilityByLottoPrice(String purchaseAmount) {
        int purchaseResult = Integer.parseInt(purchaseAmount);
        if(purchaseResult % 1000 != 0) {
            throw new IllegalArgumentException();
        }
        return purchaseResult / 1000;
    }

    private void initEachLotto() {
        for(int i = 0; i < numberOfLottos; i++) {
            lottos.add(new Lotto(LottoService.generateRandomLottoNumber()));
        }
    }

    public int getNumberOfLottos() {
        return numberOfLottos;
    }

    public List<List<Integer>> getAllLottoNumbers() {
        List<List<Integer>> allLottoNumbers = new ArrayList<>();
        for(Lotto lotto : lottos) {
            allLottoNumbers.add(lotto.getNumbers());
        }
        return Collections.unmodifiableList(allLottoNumbers);
    }
}
