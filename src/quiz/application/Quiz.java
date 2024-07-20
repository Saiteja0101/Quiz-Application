package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Quiz extends JFrame implements ActionListener {
    
    String questions[][] = new String[10][5];
    String answers[][] = new String[10][2];
    String useranswers[][] = new String[10][1];
    JLabel qno, question;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup groupoptions;
    JButton next, submit, lifeline;
    
    public static int timer = 15;
    public static int ans_given = 0;
    public static int count = 0;
    public static int score = 0;
    
    String name;
    
    Quiz(String name) {
        this.name = name;
        
        setBounds(50, 0, 1440, 850);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/quiz.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1440, 392);
        add(image);
        
        qno = new JLabel();
        qno.setBounds(100, 450, 50, 30);
        qno.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(qno);
        
        question = new JLabel();
        question.setBounds(150, 450, 900, 30);
        question.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(question);
        
        questions[0][0] = "What is the next number in the series 2, 6, 12, 20, 30, ...?";
        questions[0][1] = "36";
        questions[0][2] = "42";
        questions[0][3] = "40";
        questions[0][4] = "48";

        questions[1][0] = "A shopkeeper buys 80 articles for ₹2400 and sells them for a profit of 16%. The selling price per article is:";
        questions[1][1] = "₹30";
        questions[1][2] = "₹32.50";
        questions[1][3] = "₹34.80";
        questions[1][4] = "₹35";

        questions[2][0] = " Two pipes can fill a tank in 20 minutes and 30 minutes respectively. Both pipes are opened together. The tank will be full in:";
        questions[2][1] = "12 minutes";
        questions[2][2] = "15 minutes";
        questions[2][3] = "25 minutes";
        questions[2][4] = "50 minutes";

        questions[3][0] = "Pointing to a man, a woman said, \"His mother is the only daughter of my mother.\" How is the woman related to the man?";
        questions[3][1] = "Mother";
        questions[3][2] = "Grandmother";
        questions[3][3] = "Sister";
        questions[3][4] = "Daughter";

        questions[4][0] = "If in a certain code, 'PEAK' is written as '3512' and 'DINE' is written as '6895', how is 'KIND' written in that code?";
        questions[4][1] = "2396";
        questions[4][2] = "2896";
        questions[4][3] = "2986";
        questions[4][4] = "2596";

        questions[5][0] = "Arrange the following words in a meaningful sequence: 1. Reading 2. Writing 3. Drawing 4. Seeing 5. Listening";
        questions[5][1] = "3, 4, 2, 1, 5";
        questions[5][2] = "4, 5, 1, 2, 3";
        questions[5][3] = "4, 2, 5, 1, 3";
        questions[5][4] = "1, 3, 5, 4, 2";

        questions[6][0] = " Choose the word which best expresses the meaning of the given word: 'EMBEZZLE'?";
        questions[6][1] = "Misappropriate";
        questions[6][2] = "Balance";
        questions[6][3] = "Remunerate";
        questions[6][4] = "Clear";

        questions[7][0] = "Find the correctly spelt word.?";
        questions[7][1] = "Goverment";
        questions[7][2] = "Government";
        questions[7][3] = "Govermant";
        questions[7][4] = "Governamnt";

        questions[8][0] = "Choose the most appropriate word to fill in the blank: He succeeded in getting possession ____ the book.?";
        questions[8][1] = "of";
        questions[8][2] = "in";
        questions[8][3] = "on";
        questions[8][4] = "for";

        questions[9][0] = " A train running at the speed of 60 km/hr crosses a pole in 9 seconds. What is the length of the train?";
        questions[9][1] = "120 meters";
        questions[9][2] = "180 meters";
        questions[9][3] = "150 meters";
        questions[9][4] = "100 meters";
        
        answers[0][1] = "42";
        answers[1][1] = "₹34.80";
        answers[2][1] = "12 minutes";
        answers[3][1] = " Mother";
        answers[4][1] = "2896";
        answers[5][1] = " 4, 5, 1, 2, 3";
        answers[6][1] = "Misappropriate";
        answers[7][1] = "Government";
        answers[8][1] = "of";
        answers[9][1] = "150 meters";
        
        opt1 = new JRadioButton();
        opt1.setBounds(170, 520, 700, 30);
        opt1.setBackground(Color.WHITE);
        opt1.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt1);
        
        opt2 = new JRadioButton();
        opt2.setBounds(170, 560, 700, 30);
        opt2.setBackground(Color.WHITE);
        opt2.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt2);
        
        opt3 = new JRadioButton();
        opt3.setBounds(170, 600, 700, 30);
        opt3.setBackground(Color.WHITE);
        opt3.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt3);
        
        opt4 = new JRadioButton();
        opt4.setBounds(170, 640, 700, 30);
        opt4.setBackground(Color.WHITE);
        opt4.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt4);
        
        groupoptions = new ButtonGroup();
        groupoptions.add(opt1);
        groupoptions.add(opt2);
        groupoptions.add(opt3);
        groupoptions.add(opt4);
        
        next = new JButton("Next");
        next.setBounds(1100, 550, 200, 40);
        next.setFont(new Font("Tahoma", Font.PLAIN, 22));
        next.setBackground(new Color(30, 144, 255));
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);
        
        lifeline = new JButton("50-50 Lifeline");
        lifeline.setBounds(1100, 630, 200, 40);
        lifeline.setFont(new Font("Tahoma", Font.PLAIN, 22));
        lifeline.setBackground(new Color(30, 144, 255));
        lifeline.setForeground(Color.WHITE);
        lifeline.addActionListener(this);
        add(lifeline);
        
        submit = new JButton("Submit");
        submit.setBounds(1100, 710, 200, 40);
        submit.setFont(new Font("Tahoma", Font.PLAIN, 22));
        submit.setBackground(new Color(30, 144, 255));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);
        
        start(count);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            repaint();
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);
            
            ans_given = 1;
            if (groupoptions.getSelection() == null) {
               useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }
            
            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            
            count++;
            start(count);
        } else if (ae.getSource() == lifeline) {
            if (count == 2 || count == 4 || count == 6 || count == 8 || count == 9) {
                opt2.setEnabled(false);
                opt3.setEnabled(false);
            } else {
                opt1.setEnabled(false);
                opt4.setEnabled(false);
            }
            lifeline.setEnabled(false);
        } else if (ae.getSource() == submit) {
            ans_given = 1;
            if (groupoptions.getSelection() == null) {
                useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }

            for (int i = 0; i < useranswers.length; i++) {
                if (useranswers[i][0].equals(answers[i][1])) {
                    score += 10;
                } else {
                    score += 0;
                }
            }
            setVisible(false);
            new Score(name, score);
        }
    }
    
    public void paint(Graphics g) {
        super.paint(g);
        
        String time = "Time left - " + timer + " seconds"; // 15
        g.setColor(Color.RED);
        g.setFont(new Font("Tahoma", Font.BOLD, 25));
        
        if (timer > 0) { 
            g.drawString(time, 1100, 500);
        } else {
            g.drawString("Times up!!", 1100, 500);
        }
        
        timer--; // 14
        
        try {
            Thread.sleep(1000);
            repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        if (ans_given == 1) {
            ans_given = 0;
            timer = 15;
        } else if (timer < 0) {
            timer = 15;
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);
            
            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if (count == 9) { // submit button
                if (groupoptions.getSelection() == null) {
                   useranswers[count][0] = "";
                } else {
                    useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                }
                
                for (int i = 0; i < useranswers.length; i++) {
                    if (useranswers[i][0].equals(answers[i][1])) {
                        score += 10;
                    } else {
                        score += 0;
                    }
                }
                setVisible(false);
                new Score(name, score);
            } else { // next button
                if (groupoptions.getSelection() == null) {
                   useranswers[count][0] = "";
                } else {
                    useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                }
                count++; // 0 // 1
                start(count);
            }
        }
        
    }
    
    public void start(int count) {
        qno.setText("" + (count + 1) + ". ");
        question.setText(questions[count][0]);
        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);
        
        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);
        
        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);
        
        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);
        
        groupoptions.clearSelection();
    }
    
    public static void main(String[] args) {
        new Quiz("User");
    }
}
