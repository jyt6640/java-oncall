package oncall.config;

import oncall.controller.InputController;
import oncall.controller.OnCallController;
import oncall.validator.InputValidator;
import oncall.view.InputView;
import oncall.view.OutputView;

public class AppConfig {
    public InputView inputView() {
        return new InputView();
    }

    public OutputView outputView() {
        return new OutputView();
    }

    public InputValidator inputValidator() {
        return new InputValidator();
    }

    public InputController inputController() {
        return new InputController(
                inputView(),
                outputView(),
                inputValidator()
        );
    }

    public OnCallController onCallController() {
        return new OnCallController(
                inputController(),
                outputView()
        );
    }

}
