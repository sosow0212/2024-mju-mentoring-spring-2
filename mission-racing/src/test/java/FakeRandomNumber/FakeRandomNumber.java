package FakeRandomNumber;

import com.racing.console.domain.CreateRandomNumber;

public class FakeRandomNumber implements CreateRandomNumber {
    @Override
    public int generateRandomNumber() {
        return 4;
    }
}
