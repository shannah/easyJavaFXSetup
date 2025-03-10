package myapp;

import atlantafx.base.theme.CupertinoDark;
import atlantafx.base.theme.CupertinoLight;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import myapp.controller.MainController;
import myapp.services.LocaleService;
import myapp.services.UserSettingsService;
import myapp.services.WindowService;

import java.util.Objects;
import java.util.ResourceBundle;


public class App extends Application {


    public static void main(String[] args) {
        launch();
    }


    @Override
    public void start(Stage stage) {
        try {
            UserSettingsService.initTheme();

            ResourceBundle resourceBundle =
                    ResourceBundle.getBundle("App", LocaleService.getLocale());

            stage.setTitle(resourceBundle.getString("name"));
            stage.getIcons().add(new Image(Objects.requireNonNull(App.class.getResourceAsStream("icon-64.png"))));
            stage.setMinHeight(300);
            stage.setMinWidth(400);
            stage.initStyle(StageStyle.DECORATED);

            MainController.load(stage);

            WindowService.setup(stage);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
