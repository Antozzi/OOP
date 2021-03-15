package ad.geekbrains.gui.calc2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class CalculatorFrame2 extends JFrame implements ActionListener {

    private JMenu jMenuFile, jMenuHelp, jMenuExit;
    private final JLabel jLabelOuput;
    private boolean firstInput = true;
    private String numStr1 = "";
    private String numStr2 = "";
    Font f12 = new Font("Times New Roman", 0, 12);
    Font f121 = new Font("Times New Roman", 1, 12);
    private char op;

    public CalculatorFrame2() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 700, 500);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        // frame component
        JPanel jMaster = new JPanel();
        jLabelOuput = new JLabel("");

        // add our component to frame
        getContentPane().add(jLabelOuput, BorderLayout.NORTH);
        JButton[] jbnButtons = new JButton[32];

        for (int i = 0; i <= 9; i++) {
            jbnButtons[i] = new JButton(String.valueOf(i));
        }


        // Create operator Jbuttons
        jbnButtons[10] = new JButton("+/-");
        jbnButtons[11] = new JButton(".");
        jbnButtons[12] = new JButton("=");
        jbnButtons[13] = new JButton("/");
        jbnButtons[14] = new JButton("*");
        jbnButtons[15] = new JButton("-");
        jbnButtons[16] = new JButton("+");
        jbnButtons[17] = new JButton("--");
        jbnButtons[18] = new JButton("1/x");
        jbnButtons[19] = new JButton("%");
        JPanel jplBackSpace = new JPanel();
        jplBackSpace.setLayout(new GridLayout(1, 1, 1, 1));
        jbnButtons[20] = new JButton("Backspace");
        jplBackSpace.add(jbnButtons[20]);
        JPanel jplControl = new JPanel();
        jplControl.setLayout(new GridLayout(1, 8, 1, 1));
        jbnButtons[21] = new JButton(" CE ");
        jbnButtons[22] = new JButton("C");
        jbnButtons[23] = new JButton("sqrt");
        jbnButtons[24] = new JButton("cosh");
        jbnButtons[25] = new JButton("tan");
        jbnButtons[26] = new JButton("ln");
        jbnButtons[27] = new JButton("exp");
        jbnButtons[28] = new JButton("abs");
        jbnButtons[29] = new JButton("hex");
        jbnButtons[30] = new JButton("bin");
        jbnButtons[31] = new JButton("%");
        jplControl.add(jbnButtons[23]);
        jplControl.add(jbnButtons[21]);
        jplControl.add(jbnButtons[22]);
        jplControl.add(jbnButtons[23]);
        jplControl.add(jbnButtons[24]);
        jplControl.add(jbnButtons[25]);
        jplControl.add(jbnButtons[26]);
        jplControl.add(jbnButtons[27]);
        jplControl.add(jbnButtons[28]);
        jplControl.add(jbnButtons[29]);
        jplControl.add(jbnButtons[30]);
        jplControl.add(jbnButtons[31]);

        //Setting all Numbered JButton's to Blue. The rest to Red
        for (int i = 0; i < jbnButtons.length; i++) {
            jbnButtons[i].setFont(f12);
            if (i < 10)
                jbnButtons[i].setForeground(Color.blue);
            else
                jbnButtons[i].setForeground(Color.red);
        }

        JPanel jPLButtons = new JPanel();
        jPLButtons.setLayout(new GridLayout(4, 5, 2, 2));

        // add button to the jPLButtons
        for (int i = 7; i <= 9; i++) {
            jPLButtons.add(jbnButtons[i]);
        }
        // add button / and sqrt
        jPLButtons.add(jbnButtons[13]);
        jPLButtons.add(jbnButtons[17]);
        // Second row
        for (int i = 4; i <= 6; i++) {
            jPLButtons.add(jbnButtons[i]);
        }
        // add button * and x^2
        jPLButtons.add(jbnButtons[14]);
        jPLButtons.add(jbnButtons[18]);
        // Third row
        for (int i = 1; i <= 3; i++) {
            jPLButtons.add(jbnButtons[i]);
        }
        //adds button - and %
        jPLButtons.add(jbnButtons[15]);
        jPLButtons.add(jbnButtons[19]);
        //Fourth Row
        // add 0, +/-, ., +, and =
        jPLButtons.add(jbnButtons[0]);
        jPLButtons.add(jbnButtons[10]);
        jPLButtons.add(jbnButtons[11]);
        jPLButtons.add(jbnButtons[16]);
        jPLButtons.add(jbnButtons[12]);

        jMaster.setLayout(new BorderLayout());
        jMaster.add(jPLButtons, BorderLayout.SOUTH);
        jMaster.add(jplBackSpace, BorderLayout.WEST);
        jMaster.add(jplControl, BorderLayout.EAST);
        getContentPane().add(jMaster, BorderLayout.SOUTH);
        requestFocus();

        for (JButton jbnButton : jbnButtons) {
            jbnButton.addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String resultStr;
        String str = String.valueOf(e.getActionCommand());
        char ch = str.charAt(0);

        if (str.equals("hex") || str.equals("ln") || str.equals("e") || str.equals("cosh") || str.equals("sqrt") || str.equals("tan") || str.equals("abs") || str.equals("bin")) {
            jLabelOuput.setText(e.getActionCommand() + "(" + numStr1 + ")");
            op = e.getActionCommand().charAt(0);
        }
        switch (ch) {
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
            case '.':
                if (firstInput) {
                    numStr1 = numStr1 + ch;
                    jLabelOuput.setText(numStr1);
                } else {
                    numStr2 = numStr2 + ch;
                    jLabelOuput.setText(numStr2);
                }
                break;
            case '+':
            case '-':
            case '*':
            case '/':
            case '%':
                op = ch;
                firstInput = false;
                break;
            case '=':
                resultStr = evaluate();
                jLabelOuput.setText(resultStr);
                numStr1 = resultStr;
                numStr2 = "";
                firstInput = false;
                break;
            case 'C':
                jLabelOuput.setText("");
                numStr1 = "";
                numStr2 = "";
                firstInput = true;
        }
    }

    private String evaluate() {
        double resultat = 0;
        switch (op) {
            case '+':
                try {
                    resultat = Integer.parseInt(numStr1) + Integer.parseInt(numStr2);
                } catch (NumberFormatException e) {
                    resultat = Float.parseFloat(numStr1) + Float.parseFloat(numStr2);
                }
                break;
            case '-':
                try {
                    resultat = Integer.parseInt(numStr1) - Integer.parseInt(numStr2);
                } catch (NumberFormatException e) {
                    resultat = Float.parseFloat(numStr1) - Float.parseFloat(numStr2);
                }
                break;
            case '*':
                try {
                    resultat = Integer.parseInt(numStr1) * Integer.parseInt(numStr2);
                } catch (NumberFormatException e) {
                    resultat = Float.parseFloat(numStr1) * Float.parseFloat(numStr2);
                }
                break;
            case 'h':
                resultat = Integer.parseInt(numStr1, 16);
                break;
            case 'b':
                resultat = Integer.parseInt(numStr1, 2);
                break;
            case 'e':
                resultat = Math.exp(Double.parseDouble(numStr1));
                break;
            case 'l':
                resultat = Math.log(Double.parseDouble(numStr1));
                break;
            case 's':
                resultat = Math.sqrt(Double.parseDouble(numStr1));
                break;
            case 'c':
                resultat = Math.cosh(Double.parseDouble(numStr1));
                break;
            case 't':
                resultat = Math.tan(Double.parseDouble(numStr1));
                break;
            case 'a':
                resultat = Math.abs(Double.parseDouble(numStr1));
                break;
            case '/':
                try {
                    resultat = Integer.parseInt(numStr1) / Integer.parseInt(numStr2);
                } catch (NumberFormatException e) {
                    resultat = Float.parseFloat(numStr1) / Float.parseFloat(numStr2);
                }
                break;
            case '%':
                try {
                    resultat = Integer.parseInt(numStr1) % Integer.parseInt(numStr2);
                } catch (NumberFormatException e) {
                    resultat = Float.parseFloat(numStr1) % Float.parseFloat(numStr2);
                }
                break;
        }

        return String.valueOf(resultat);
    }


}
