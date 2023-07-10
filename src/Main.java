import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class PASS_EXCEPTION extends Exception {
    PASS_EXCEPTION(String x)
    {
        super(x);
    }


}

class PASS_GENERATOR extends JFrame {
    JLabel l1, l2, l3, l4, l5;
    JTextField t1, t2, t3;
    JTextArea ta1;
    JButton b1, b2;
    JCheckBox c1, c2, c3, c4;
    JComboBox<String> cb1;

    String UPPERCASE = "QWERTYUIOPASDFGHJKLZXCVBNM";
    String LOWERCASE = "qwertyuiopasdfghjklzxcvbnm";
    String NUMBERS = "1234567890";
    String SPECIAL = "@#$%&*";
    int length1,count=0;
    String combination;
    String[] passwords = new String[5];

    void GENERATO_RFRAME() {
        l1 = new JLabel("PASSWORD GENERATOR");
        l1.setBounds(250, 10, 500, 80);
        l1.setFont(new Font("serif", Font.BOLD, 40));

        ta1 = new JTextArea("");
        ta1.setBounds(40, 100, 800, 190);
        ta1.setText("Read the following guidelines which help you to get a password:\n1. The user must select the options to generate  password\n2.Select the kind of characters should be in password\n3.Generate the passwords by clicking genarate button\n4.Select the desired password from combobox by clicking down arrow\n5.test the correctness and randomness of a selected password");
        ta1.setFont(new Font("serif", Font.PLAIN, 17));

        t1 = new JTextField();
        t1.setBounds(300, 310, 130, 30);

        l2 = new JLabel("Enter number of characters");
        l2.setBounds(30, 310, 250, 30);
        l2.setFont(new Font("serif",Font.PLAIN,18));

        c1 = new JCheckBox("LOWER CASE");
        c1.setBounds(30, 350, 120, 50);

        c2 = new JCheckBox("UPPER CASE");
        c2.setBounds(170, 350, 120, 50);

        c3 = new JCheckBox("SPECIAL CHARACTERS");
        c3.setBounds(290, 350, 150, 50);

        c4 = new JCheckBox("NUMBERS");
        c4.setBounds(470, 350, 150, 50);

        b1 = new JButton("GENERATE PASSWORD");
        b1.setBounds(40, 420, 220, 30);

        cb1 = new JComboBox<>(passwords);
        cb1.setBounds(280, 420, 150, 30);

        l3 = new JLabel("Test the password:");
        l3.setBounds(40, 510, 300, 30);
        l3.setFont(new Font("serif",Font.PLAIN,18));

        b2 = new JButton("TEST");
        b2.setBounds(40, 550, 80, 30);

        t2 = new JTextField(" ");
        t2.setBounds(150, 550, 150, 30);
        ta1.setEditable(false);

        l4=new JLabel("Enter queries or errors in generating password");
        l4.setBounds(40,600,400,30);
        l4.setFont(new Font("serif",Font.PLAIN,18));

        t3=new JTextField();
        t3.setBounds(450,600,280,30);

        l5=new JLabel("THANK YOU...");
        l5.setBounds(350,650,400,100);
        l5.setFont(new Font("SERIF",Font.BOLD,30));
        add(l1);add(ta1);add(l3);add(t1);add(c1);add(c2);add(c3);add(c4);add(b1);add(cb1);add(l2);add(b2);add(t2);add(l4);add(t3);add(l5);
        setLayout(null);
        setVisible(true);
        setSize(1000, 1000);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String d1 = t1.getText();
                length1 = Integer.parseInt(d1);
                try {
                    if (length1 <= 1) {
                        throw new PASS_EXCEPTION("PASSWORD LENGTH SHOULD BE MORE THAN 1");

                    }
                }
                catch(PASS_EXCEPTION obj)
                {
                    System.out.println("PASSWORD LENGTH SHOULD BE MORE THAN 1");
                    JOptionPane.showMessageDialog(null, "PASSWORD LENGTH SHOULD BE MORE THAN 1", "Password Generator Error", JOptionPane.ERROR_MESSAGE);
                }

                char[] pass = new char[length1];
                Random r = new Random();
                combination = "";

                if (c1.isSelected()) {
                    combination += LOWERCASE;
                    count++;
                }
                if (c2.isSelected()) {
                    combination += UPPERCASE;
                    count++;
                }
                if (c3.isSelected()) {
                    combination += SPECIAL;
                    count++;
                }
                if (c4.isSelected()) {
                    combination += NUMBERS;
                    count++;
                }
                cb1.removeAllItems();
                String x;
                for(int j=1;j<=5;j++) {
                    for (int i = 0; i < length1; i++) {
                        pass[i] = combination.charAt(r.nextInt(combination.length()));
                    }
                    x = String.valueOf(pass);
                    cb1.addItem(x);
                }

            }
        });
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(count==4)
                {
                    t2.setText("100%-STRONG");
                    count=0;
                }
                if(count==3)
                {
                    t2.setText("75%-STRONG");
                    count=0;
                }
                if(count==2)
                {
                    t2.setText("50%-STRONG");
                    count=0;
                }
                if(count==1){
                    t2.setText("week");
                    count=0;
                }

            }
        });
    }
}

class Main {
    public static void main(String[] arg) {
        PASS_GENERATOR obj = new PASS_GENERATOR();
        obj.GENERATO_RFRAME();
    }
}
