import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The InstructionMenu class displays a graphical instruction menu for the Pong game.
 * It explains the game rules and controls to the players.
 */
public class InstructionMenu {

    private static boolean gameStarted = false; // Flag to track if "Start Game" was clicked

    /**
     * Displays the instruction menu for Pong.
     * 
     * @return true if the user clicks "Start Game".
     */
    public static boolean showInstructions() {
        // Create the JFrame
        JFrame frame = new JFrame("Pong Game - Instructions");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());

        // Create a JPanel for the instructions
        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Add a title
        JLabel title = new JLabel("Welcome to Pong!");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setForeground(Color.WHITE);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(Box.createRigidArea(new Dimension(0, 20))); // Add some space
        panel.add(title);

        // Add the game description
        JLabel description = new JLabel("<html><div style='text-align: center;'>"
                + "The goal of the game is to score points by bouncing the ball past the opponent's paddle.<br>"
                + "With every ball collision with paddle, the paddle shrinks and gets smaller and they reset back to normal height when one player gets a point.<br>"
                + "The first player to reach 5 points wins!</div></html>");
        description.setFont(new Font("Arial", Font.PLAIN, 16));
        description.setForeground(Color.WHITE);
        description.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(Box.createRigidArea(new Dimension(0, 20))); // Add some space
        panel.add(description);

        // Add controls
        JLabel controls = new JLabel("<html><div style='text-align: center;'>"
        + "<b>Player 1:</b> Use <b>Z</b> to move up and <b>X</b> to move down.<br>"
        + "<b>Player 2:</b> Use <b>N</b> to move up and <b>M</b> to move down.</div></html>");
        controls.setFont(new Font("Arial", Font.PLAIN, 16));
        controls.setForeground(Color.WHITE);
        controls.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(Box.createRigidArea(new Dimension(0, 20))); // Add some space
        panel.add(controls);

        // Add a "Start Game" button
        JButton startButton = new JButton("Start Game");
        startButton.setFont(new Font("Arial", Font.BOLD, 18));
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(Box.createRigidArea(new Dimension(0, 30))); // Add some space
        panel.add(startButton);

        // Add action listener to the button
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gameStarted = true; // Set flag to true when the button is clicked
                frame.dispose();   // Close the instructions window
            }
        });

        // Add the panel to the frame
        frame.add(panel, BorderLayout.CENTER);

        // Center the frame and make it visible
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // Wait until the frame is disposed (when "Start Game" is clicked)
        while (frame.isDisplayable()) {
            try {
                Thread.sleep(100); // Sleep briefly to avoid busy-waiting
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }

        return gameStarted; // Return true if the game was started
    }
    
}
