import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordCounterApp extends JFrame {

    private JTextArea textArea;
    private JLabel wordCountLabel;
    private JLabel characterCountLabel;
    private JLabel paragraphCountLabel;

    public WordCounterApp() {
        setTitle("Word Counter Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null); // Center the window
        setLayout(new BorderLayout());

        // Text area for user input
        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        // Panel for labels
        JPanel labelPanel = new JPanel(new GridLayout(7, 3));

        // Labels for word count, character count, and paragraph count
        wordCountLabel = new JLabel("Words: 0");
        characterCountLabel = new JLabel("Characters: 0");
        paragraphCountLabel = new JLabel("Paragraphs: 0");

        labelPanel.add(wordCountLabel);
        labelPanel.add(characterCountLabel);
        labelPanel.add(paragraphCountLabel);
        add(labelPanel, BorderLayout.SOUTH);

        // Button to count words
        JButton countButton = new JButton("Count Words");
        countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                countWords();
            }
        });
        add(countButton, BorderLayout.NORTH);
    }

    private void countWords() {
        String text = textArea.getText();

        // Count words
        String[] words = text.split("\\s+");
        int wordCount = words.length;

        // Count characters
        int characterCount = text.length();

        // Count paragraphs (assuming paragraphs are separated by double line breaks)
        String[] paragraphs = text.split("\n\n");
        int paragraphCount = paragraphs.length;

        // Update labels
        wordCountLabel.setText("Words: " + wordCount);
        characterCountLabel.setText("Characters: " + characterCount);
        paragraphCountLabel.setText("Paragraphs: " + paragraphCount);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                WordCounterApp app = new WordCounterApp();
                app.setVisible(true);
            }
        });
    }
}
