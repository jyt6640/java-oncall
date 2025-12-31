package oncall;

import oncall.controller.InputController;
import oncall.controller.OnCallController;
import oncall.view.InputView;

public class Application {
    public static void main(String[] args) {
        OnCallController onCallController = new OnCallController(new InputController(new InputView()));
        onCallController.run();
    }
}
