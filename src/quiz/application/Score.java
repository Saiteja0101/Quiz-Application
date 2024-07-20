package quiz.application;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Score extends JFrame implements ActionListener {

    private String name;
    private int score;

    Score(String name, int score) {
        this.name = name;
        this.score = score;
        
        setBounds(400, 150, 750, 550);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/score.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 200, 300, 250);
        add(image);

        JLabel heading = new JLabel("Thank you " + name + " for playing Simple Minds");
        heading.setBounds(45, 30, 700, 30);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 26));
        add(heading);

        JLabel lblscore = new JLabel("Your score is " + score);
        lblscore.setBounds(350, 200, 300, 30);
        lblscore.setFont(new Font("Tahoma", Font.PLAIN, 26));
        add(lblscore);

        JButton submit = new JButton("Play Again");
        submit.setBounds(380, 270, 120, 30);
        submit.setBackground(new Color(30, 144, 255));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        JButton viewAns = new JButton("View Answers");
        viewAns.setBounds(550, 270, 120, 30);
        viewAns.setBackground(new Color(30, 144, 255));
        viewAns.setForeground(Color.WHITE);
        viewAns.addActionListener(this);
        add(viewAns);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("Play Again")) {
            setVisible(false);
            new Login();
        } else if (ae.getActionCommand().equals("View Answers")) {
            setVisible(false);
            new ViewAnswers(name, score);
        }
    }

    public static void main(String[] args) {
        new Score("User", 0);
    }
}

class ViewAnswers extends JFrame {

    ViewAnswers(String name, int score) {
        
        setBounds(400, 150, 750, 600);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Correct Answers");
        heading.setBounds(300, 30, 200, 30);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 26));
        add(heading);

        String[][] questions = {
            {"What is the next number in the series 2, 6, 12, 20, 30, ...?", "42"},
            {" A shopkeeper buys 80 articles for ₹2400 and sells them for a profit of 16%. The selling price per article is:", "₹34.80"},
            {"Two pipes can fill a tank in 20 minutes and 30 minutes respectively. Both pipes are opened together. The tank will be full in:", "12 minutes"},
            {"Pointing to a man, a woman said, \"His mother is the only daughter of my mother.\" How is the woman related to the man?", "Mother"},
            {"If in a certain code, 'PEAK' is written as '3512' and 'DINE' is written as '6895', how is 'KIND' written in that code?", "2896"},
            {"Arrange the following words in a meaningful sequence: 1. Reading 2. Writing 3. Drawing 4. Seeing 5. Listening?", "4, 5, 1, 2, 3"},
            {"Choose the word which best expresses the meaning of the given word: 'EMBEZZLE'?", "Misappropriate"},
            {"Find the correctly spelt word?", "Government"},
            {"Choose the most appropriate word to fill in the blank: He succeeded in getting possession ____ the book?", "of"},
            {"A train running at the speed of 60 km/hr crosses a pole in 9 seconds. What is the length of the train?", "150 meters"}
        };

        JPanel answersPanel = new JPanel();
        answersPanel.setLayout(new BoxLayout(answersPanel, BoxLayout.Y_AXIS));
        answersPanel.setBackground(Color.WHITE);
        answersPanel.setBounds(50, 100, 650, 400);
        JScrollPane scrollPane = new JScrollPane(answersPanel);
        scrollPane.setBounds(50, 100, 650, 400);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        add(scrollPane);

        int i = 1;
        for (String[] ans : questions) {
            JLabel questionLabel = new JLabel(i + ". " + ans[0]);
            questionLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
            answersPanel.add(questionLabel);

            JLabel answerLabel = new JLabel("-> " + ans[1]);
            answerLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
            answerLabel.setForeground(Color.GREEN);
            answersPanel.add(answerLabel);

            i++;
        }

        JButton back = new JButton("Back");
        back.setBounds(300, 520, 120, 30);
        back.setBackground(new Color(30, 144, 255));
        back.setForeground(Color.WHITE);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Score(name, score);
            }
        });
        add(back);

        setVisible(true);
    }
}
