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
            {"Which is used to find and fix bugs in the Java programs.?", "JDB"},
            {"What is the return type of the hashCode() method in the Object class?", "int"},
            {"Which package contains the Random class?", "java.util package"},
            {"An interface with no fields or methods is known as?", "Marker Interface"},
            {"In which memory a String is stored, when we create a string using new operator?", "Heap memory"},
            {"Which of the following is a marker interface?", "Remote interface"},
            {"Which keyword is used for accessing the features of a package?", "import"},
            {"In java, jar stands for?", "Java Archive"},
            {"Which of the following is a mutable class in java?", "java.lang.StringBuilder"},
            {"Which of the following option leads to the portability and security of Java?", "Bytecode is executed by JVM"}
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
