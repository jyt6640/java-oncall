package oncall;

import oncall.config.AppConfig;
import oncall.controller.OnCallController;

public class Application {
    public static void main(String[] args) {
        AppConfig config = new AppConfig();
        OnCallController controller = config.onCallController();
        controller.run();
    }
}
