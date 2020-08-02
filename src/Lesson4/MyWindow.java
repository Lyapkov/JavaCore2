package Lesson4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MyWindow extends JFrame {
    private JButton button = new JButton("Отправить");
        private JTextField input = new JTextField();
    private JTextArea output = new JTextArea();

    public MyWindow() {
        super("Чатик");
        this.setBounds(560,240,800,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        output.setEnabled(false);
        Container container = this.getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        output.setLineWrap(true);
        constraints.weighty   = 1;
        constraints.gridwidth = 4;
        constraints.gridy = 0;
        constraints.ipady = 450;
        constraints.ipadx = 730;
        output.setMinimumSize(new Dimension(11, 7));
        output.setMaximumSize(new Dimension(11, 7));
        container.add(output, constraints);
        constraints.weighty   = 1;
        constraints.gridy = 1;
        constraints.gridx = 0;
        constraints.gridwidth = 3;
        constraints.ipady = 15;
        constraints.ipadx = 450;
        input.setMinimumSize(new Dimension(80, 15));
        input.setMaximumSize(new Dimension(80, 15));
        container.add(input, constraints);
        constraints.gridx = 3;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.ipady = 10;
        constraints.ipadx = 100;
        container.add(button, constraints);
        button.addActionListener(this::print);
        input.addActionListener(this::print);
    }

    private void print(ActionEvent e){
        output.append(input.getText() + "\n");
        input.setText("");
    }

}
