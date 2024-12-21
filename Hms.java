import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class Hms extends JFrame implements ActionListener{

    Hms(){
        setSize(1366, 565);
        setLocation(0, 100);
        // setBounds(100, 100, 1366, 565);
        setLayout(null);

        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        JLabel image = new JLabel(i);
        image.setBounds(0, 0, 1366, 565);
        add(image);

        JLabel text = new JLabel("HOTEL MANAGEMENT SYSTEM");
        text.setBounds(20, 430, 1000, 100);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("serif", Font.PLAIN, 50));
        image.add(text);

        JButton next = new JButton("Next");
        next.setBounds(1150, 450, 150, 50);
        next.setBackground(Color.WHITE);
        next.setFont(new Font("serif", Font.PLAIN, 20));
        next.addActionListener(this);
        image.add(next);

        setVisible(true);

        while (true) { 
            text.setVisible(false);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
            text.setVisible(true);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Hms();
    }

    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Login();
    }
} 