package luigi.ui;

import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import luigi.Luigi;

/**
 * Controller for the main GUI.
 */
public class MainWindow extends AnchorPane {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;

    private Luigi luigi;

    private Image userImage = new Image(this.getClass().getResourceAsStream("/images/Mario.png"));
    private Image luigiImage = new Image(this.getClass().getResourceAsStream("/images/Luigi.png"));

    @FXML
    public void initialize() {
        String greeting = "Hello! I'm Luigi!" +System.lineSeparator() + "How can I help you?";
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
        dialogContainer.getChildren().add(DialogBox.getLuigiDialog(greeting, luigiImage));
    }

    /** Injects the Duke instance */
    public void setLuigi(Luigi luigi) {
        this.luigi = luigi;
    }

    /**
     * Creates two dialog boxes, one echoing user input and the other containing Duke's reply and then appends them to
     * the dialog container. Clears the user input after processing. Exits program if user types "bye".
     */
    @FXML
    private void handleUserInput() {
        String input = userInput.getText();
        String response = luigi.getResponse(input);
        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(input, userImage),
                DialogBox.getLuigiDialog(response, luigiImage)
        );
        userInput.clear();
        if (response.equals("Bye!")) {
            PauseTransition delay = new PauseTransition(Duration.seconds(1));
            delay.setOnFinished(event -> Platform.exit());
            delay.play();
        }
    }
}

