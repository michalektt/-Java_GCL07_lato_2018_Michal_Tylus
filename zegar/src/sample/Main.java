package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.time.LocalTime;

import static java.lang.Math.PI;
import static java.lang.Math.cos;
import static java.lang.Math.sin;


public class Main extends Application {
    private Canvas canvas = new Canvas(600, 600);
    private GraphicsContext gc = canvas.getGraphicsContext2D();
    private Stage stage;
    private double r = 0.0; // promień tarczy
    private double centerX = 0.0; // środek tarczy X
    private double centerY = 0.0; // środek tarczy Y

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;
        stage.setTitle("Budzik");
        Group root = new Group();
        root.getChildren().add(canvas);
        stage.setScene(new Scene(root));
        stage.show();

        new AnimationTimer() {
            @Override
            public void handle(long n) {
                drawClock();
                //sprawdzić czy podana w budziku godzina i minuta nie pikrywają się z listą
            }
        }.start();
    }

    private void drawClock() {
        cleanup();

        gc.setStroke(Color.BLACK);
        gc.setFill(Color.BLACK);
        gc.setLineWidth(3);

        // tarcza zegara
        drawCircle(centerX, centerY, r);

        // punkty na tarczy
        gc.setLineWidth(1);
        for (int i = 1; i <= 12; i++) {
            double angle = 2 * PI * i / 12;
            double x = sin(angle) * r + centerX;
            double y = -cos(angle) * r + centerY;
            fillCircle(x, y, 4);
        }

        // środek tarczy
        fillCircle(centerX, centerY, 4);

        // aktualny czas
        LocalTime now = LocalTime.now();
        double hours = (now.getHour() % 12) + (now.getMinute() / 60.0) + (now.getSecond() / 3600.0);
        double minutes = now.getMinute() + (now.getSecond() / 60.0);
        double seconds = now.getSecond();

        final double hourLength = 0.5 * r; // długość wskazówki godzinowej
        final double minuteLength = 0.8 * r; // długość wskazówki minutowej
        final double secondLength1 = 0.95 * r; // długość sekundnika
        final double secondLength2 = 0.1 * r; // długość sekundnika "do tyłu"

        // rysowanie wskazówki godzinowej
        gc.setLineWidth(3);
        gc.strokeLine(
                centerX,
                centerY,
                centerX + sin(2 * PI * hours / 12) * hourLength,
                centerY - cos(2 * PI * hours / 12) * hourLength);

        // rysowanie wskazówki minutowej
        gc.strokeLine(
                centerX,
                centerY,
                centerX + sin(2 * PI * minutes / 60) * minuteLength,
                centerY - cos(2 * PI * minutes / 60) * minuteLength);

        // rysowanie sekundnika
        gc.setStroke(Color.RED);
        gc.setLineWidth(2);
        gc.strokeLine(
                centerX - sin(2 * PI * seconds / 60) * secondLength2,
                centerY + cos(2 * PI * seconds / 60) * secondLength2,
                centerX + sin(2 * PI * seconds / 60) * secondLength1,
                centerY - cos(2 * PI * seconds / 60) * secondLength1);
    }

    private void cleanup() {
        canvas.setWidth(stage.getWidth());
        canvas.setHeight(stage.getHeight());
        double size = Math.min(stage.getHeight(), stage.getWidth()) - 60;
        r = size / 2;
        centerX = size / 2 + 10;
        centerY = size / 2 + 10;
        gc.clearRect(0, 0, 10000, 10000);
    }

    private void drawCircle(double x, double y, double r) {
        gc.strokeOval(x - r, y - r, 2 * r, 2 * r);
    }

    private void fillCircle(double x, double y, double r) {
        gc.fillOval(x - r, y - r, 2 * r, 2 * r);
    }

   // Media sound=

    public static void main(String[] args) {
        launch(args);
    }
}
//stworzyć obiekt alarm zawierający godzinę i minutę
//FXCollections.sort
//komparator użyć do  godziny Switch(Integer.compare(a,b))
//case -1; return -1;
//case +1;return +1;
//Default:Integer.compare a.MIN, b.min); na początku godzinę
//a,b to godizny do porównania
//zrobić obserwowalną listę