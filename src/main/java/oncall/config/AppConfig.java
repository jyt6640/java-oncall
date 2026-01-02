package oncall.config;

import oncall.controller.InputController;
import oncall.controller.OnCallController;
import oncall.service.GenerateScheduleService;
import oncall.view.InputView;
import oncall.view.OutputView;

public class AppConfig {

    public InputView inputView() {
        return new InputView();
    }

    ;

    public OutputView outputView() {
        return new OutputView();
    }

    public InputController inputController() {
        return new InputController(
                inputView(),
                outputView()
        );
    }

    public GenerateScheduleService generateScheduleService() {
        return new GenerateScheduleService();
    }

    public OnCallController onCallController() {
        return new OnCallController(
                inputController(),
                outputView(),
                generateScheduleService()
        );
    }
}
