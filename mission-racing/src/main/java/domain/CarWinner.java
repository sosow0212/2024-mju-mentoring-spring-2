package domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CarWinner {

    private static final int INITIAL_NUMBER = 0;

    private final List<String> carWinner;

    public CarWinner(List<String> carNames, List<Integer> moveCounts) {
        this.carWinner = makeWinners(carNames, moveCounts);
    }

    public List<String> getCarWinner() {
        return carWinner;
    }

    private List<String> makeWinners(List<String> carNames, List<Integer> moveCounts) {
        List<String> winner = new ArrayList<>();
        List<Integer> winnerMoveCountOrder = findWinnerMoveCounts(moveCounts);
        for (int moveCountOrder : winnerMoveCountOrder) {
            winner.add(carNames.get(moveCountOrder));
        }
        return winner;
    }

    private List<Integer> findWinnerMoveCounts(List<Integer> moveCounts) {
        int winnerMoveCount = Collections.max(moveCounts);
        return IntStream.range(INITIAL_NUMBER, moveCounts.size())
                .filter(i -> moveCounts.get(i) == winnerMoveCount)
                .boxed()
                .collect(Collectors.toList());
    }
}
