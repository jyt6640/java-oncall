package oncall;

import oncall.controller.InputController;
import oncall.controller.OnCallController;
import oncall.validator.InputValidator;
import oncall.view.InputView;
import oncall.view.OutputView;

public class Application {
    public static void main(String[] args) {
        OnCallController onCallController = new OnCallController(new InputController(new InputView(), new OutputView(), new InputValidator()));
        onCallController.run();
    }
}
