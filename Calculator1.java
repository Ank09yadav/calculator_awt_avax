import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator1 implements ActionListener {
    //taking frane and buttons 
    JFrame frame;
    JButton[] NumberButtons = new JButton[10];
    JTextField textfield;
    JButton[] fucctiButtons = new JButton[9];
    JButton addButton, subButton, multButton, divButton, decButton, equButton, delButton, clrButton, negButton;
    JPanel panel;
    JLabel name = new JLabel("ANK");

    //Taking variable to calculation.
    double num1 = 0, num2 = 0, res = 0;
    char operator;

    // Font and Color settings
    Font buttonFont = new Font("Arial", Font.BOLD, 20);
    Font textfieldFont = new Font("Consolas", Font.PLAIN, 24);
    Color buttonTextColor = Color.WHITE;
    Color buttonBackgroundColor = new Color(50, 50, 50); // Dark gray
    Color textfieldTextColor = Color.BLACK;
    Color textfieldBackgroundColor = new Color(220, 220, 220); // Light gray

    Calculator1() {

        frame = new JFrame("Simple Calculator...");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(420, 550);
        frame.setLayout(null);

        ImageIcon icon = new ImageIcon("\\resources\\logo.png");
        Image image = icon.getImage();
        frame.setIconImage(image);

        name.setBounds(2,3,70,10);
        frame.add(name);
        textfield = new JTextField();
        textfield.setBounds(50, 25, 300, 50);
        textfield.setEditable(false);
        textfield.setFont(textfieldFont);
        textfield.setForeground(textfieldTextColor);
        textfield.setBackground(textfieldBackgroundColor);
        frame.add(textfield);

        addButton = new JButton("+");
        subButton = new JButton("-");
        multButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("DEL");
        clrButton = new JButton("CLR");
        negButton = new JButton("(-)");

        fucctiButtons[0] = addButton;
        fucctiButtons[1] = subButton;
        fucctiButtons[2] = multButton;
        fucctiButtons[3] = divButton;
        fucctiButtons[4] = decButton;
        fucctiButtons[5] = equButton;
        fucctiButtons[6] = delButton;
        fucctiButtons[7] = clrButton;
        fucctiButtons[8] = negButton;

        for (int i = 0; i < 9; i++) {
            fucctiButtons[i].addActionListener(this);
            fucctiButtons[i].setFocusable(false);
            fucctiButtons[i].setFont(buttonFont);
            fucctiButtons[i].setForeground(buttonTextColor);
            fucctiButtons[i].setBackground(buttonBackgroundColor);
        }

        for (int i = 0; i < 10; i++) {
            NumberButtons[i] = new JButton(String.valueOf(i));
            NumberButtons[i].addActionListener(this);
            NumberButtons[i].setFocusable(false);
            NumberButtons[i].setFont(buttonFont);
            NumberButtons[i].setForeground(buttonTextColor);
            NumberButtons[i].setBackground(buttonBackgroundColor);
        }

        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        panel.setBounds(50, 100, 300, 300);
        panel.setBackground(new Color(240, 240, 240)); // Optional panel background
        frame.add(panel);

        panel.add(NumberButtons[1]);
        panel.add(NumberButtons[2]);
        panel.add(NumberButtons[3]);
        panel.add(addButton);

        panel.add(NumberButtons[4]);
        panel.add(NumberButtons[5]);
        panel.add(NumberButtons[6]);
        panel.add(subButton);

        panel.add(NumberButtons[7]);
        panel.add(NumberButtons[8]);
        panel.add(NumberButtons[9]);
        panel.add(multButton);

        panel.add(decButton);
        panel.add(NumberButtons[0]);
        panel.add(divButton);
        panel.add(equButton);

        clrButton.setBounds(150, 430, 100, 50);
        delButton.setBounds(50, 430, 100, 50);
        negButton.setBounds(250, 430, 100, 50);

        delButton.setFont(buttonFont);
        delButton.setForeground(buttonTextColor);
        delButton.setBackground(new Color(150, 50, 50)); // Different color for DEL

        clrButton.setFont(buttonFont);
        clrButton.setForeground(buttonTextColor);
        clrButton.setBackground(new Color(150, 50, 50)); // Different color for CLR

        negButton.setFont(buttonFont);
        negButton.setForeground(buttonTextColor);
        negButton.setBackground(buttonBackgroundColor);

        frame.add(delButton);
        frame.add(clrButton);
        frame.add(negButton);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Calculator1 calcu = new Calculator1();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == NumberButtons[i]) {
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decButton) {
            textfield.setText(textfield.getText().concat("."));
        }
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '+';
            textfield.setText("");
        }
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '-';
            textfield.setText("");
        }
        if (e.getSource() == multButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '*';
            textfield.setText("");
        }
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '/';
            textfield.setText("");
        }
        if (e.getSource() == negButton) {
            Double temp = Double.parseDouble(textfield.getText());
            temp *= -1;
            textfield.setText(String.valueOf(temp));
        }

        if (e.getSource() == equButton) {
            num2 = Double.parseDouble(textfield.getText());
            textfield.setText("");
            switch (operator) {
                case '+':
                    res = num1 + num2;
                    break;
                case '-':
                    res = num1 - num2;
                    break;
                case '*':
                    res = num1 * num2;
                    break;
                case '/':
                    if (num2 != 0) {
                        res = num1 / num2;
                    } else {
                        textfield.setText("Error"); // Handle division by zero
                        return;
                    }
                    break;
            }
            textfield.setText(String.valueOf(res));
            num1 = res;
        }
        if (e.getSource() == delButton) {
            String string = textfield.getText();
            textfield.setText("");
            for (int i = 0; i < string.length() - 1; i++) {
                textfield.setText(textfield.getText() + string.charAt(i));
            }
        }
        if (e.getSource() == clrButton) {
            textfield.setText("");
            num1 = 0;
            num2 = 0;
        }
    }
}