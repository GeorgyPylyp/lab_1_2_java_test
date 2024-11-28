import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        TabPane tabPane = new TabPane();

        // Вкладка 1: Обчислення для паралелепіпеда
        Tab tab1 = new Tab("Завдання 1", createTask1Pane());

        // Вкладка 2: Трамвайні маршрути
        Tab tab2 = new Tab("Завдання 2", createTask2Pane());

        tabPane.getTabs().addAll(tab1, tab2);

        Scene scene = new Scene(tabPane, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("GUI-застосунок");
        primaryStage.show();
    }

    // Створення вкладки для Завдання 1
    private GridPane createTask1Pane() {
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);

        Label labelA = new Label("Сторона a:");
        Label labelB = new Label("Сторона b:");
        Label labelC = new Label("Сторона c:");
        TextField inputA = new TextField();
        TextField inputB = new TextField();
        TextField inputC = new TextField();
        Button calculateButton = new Button("Обчислити");
        Label resultVolume = new Label("Об'єм: ");
        Label resultSurface = new Label("Площа поверхні: ");

        calculateButton.setOnAction(event -> {
            try {
                double a = Double.parseDouble(inputA.getText());
                double b = Double.parseDouble(inputB.getText());
                double c = Double.parseDouble(inputC.getText());

                double volume = a * b * c;
                double surface = 2 * (a * b + b * c + a * c);

                resultVolume.setText("Об'єм: " + volume);
                resultSurface.setText("Площа поверхні: " + surface);

                Alert info = new Alert(Alert.AlertType.INFORMATION, "Об'єм: " + volume + "\nПлоща поверхні: " + surface);
                info.show();
            } catch (NumberFormatException e) {
                Alert error = new Alert(Alert.AlertType.ERROR, "Помилка: Введіть числові значення.");
                error.show();
            }
        });

        pane.add(labelA, 0, 0);
        pane.add(inputA, 1, 0);
        pane.add(labelB, 0, 1);
        pane.add(inputB, 1, 1);
        pane.add(labelC, 0, 2);
        pane.add(inputC, 1, 2);
        pane.add(calculateButton, 0, 3);
        pane.add(resultVolume, 0, 4, 2, 1);
        pane.add(resultSurface, 0, 5, 2, 1);

        return pane;
    }

    // Створення вкладки для Завдання 2
    private GridPane createTask2Pane() {
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);

        Label labelRoute = new Label("Виберіть маршрут:");
        ComboBox<Integer> routeComboBox = new ComboBox<>();
        routeComboBox.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Button showButton = new Button("Показати зупинки");
        Label resultStops = new Label("Зупинки: ");

        showButton.setOnAction(event -> {
            Integer route = routeComboBox.getValue();
            if (route == null) {
                Alert error = new Alert(Alert.AlertType.ERROR, "Помилка: Виберіть номер маршруту.");
                error.show();
                return;
            }

            String stops = getStops(route);
            resultStops.setText("Зупинки: " + stops);

            Alert info = new Alert(Alert.AlertType.INFORMATION, "Зупинки: " + stops);
            info.show();
        });

        pane.add(labelRoute, 0, 0);
        pane.add(routeComboBox, 1, 0);
        pane.add(showButton, 0, 1);
        pane.add(resultStops, 0, 2, 2, 1);

        return pane;
    }

    // Метод для отримання початкової та кінцевої зупинки
    private String getStops(int route) {
        switch (route) {
            case 1: return "Зупинка 1 - Зупинка 9";
            case 2: return "Зупинка 2 - Зупинка 8";
            case 3: return "Зупинка 3 - Зупинка 7";
            case 4: return "Зупинка 4 - Зупинка 6";
            case 5: return "Зупинка 5 - Зупинка 5";
            case 6: return "Зупинка 6 - Зупинка 4";
            case 7: return "Зупинка 7 - Зупинка 3";
            case 8: return "Зупинка 8 - Зупинка 2";
            case 9: return "Зупинка 9 - Зупинка 1";
            default: return "Невідомий маршрут";
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
