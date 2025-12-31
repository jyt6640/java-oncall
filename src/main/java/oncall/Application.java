package oncall;

import oncall.config.AppConfig;
import oncall.controller.OnCallController;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        OnCallController controller = appConfig.onCallController();
        controller.run();
    }
}
