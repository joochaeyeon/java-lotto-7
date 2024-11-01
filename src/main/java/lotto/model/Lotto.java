package lotto.model;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        if (!isValidRange(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (hasDuplicates(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }

    // TODO: 추가 기능 구현
    private boolean isValidRange(List<Integer> numbers) {
        return numbers.stream().allMatch(number -> number >= 1 && number <= 45);
    }

    private boolean hasDuplicates(List<Integer> numbers) {
        return numbers.stream().distinct().count() != numbers.size();
    }


    public List<Integer> getNumbers() {
        return numbers;
    }

}