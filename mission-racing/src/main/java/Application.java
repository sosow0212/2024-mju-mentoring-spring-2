import controller.CarController;
import view.InputVIew;
import view.OutputView;

public class Application {

    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputVIew inputVIew = new InputVIew();
        CarController carController = new CarController(inputVIew, outputView);
        carController.run();
    }
}
