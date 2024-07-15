import controller.CarController;
import domain.CarRandomNumber;
import domain.CreateRandomNumber;
import view.InputVIew;
import view.OutputView;

public class Application {

    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputVIew inputVIew = new InputVIew();
        CreateRandomNumber createRandomNumber = new CarRandomNumber();
        CarController carController = new CarController(inputVIew, outputView, createRandomNumber);
        carController.run();
    }
}
