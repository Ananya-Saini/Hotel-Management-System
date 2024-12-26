import java.awt.*;
import javax.swing.*;

public class Reception extends JFrame{
    Reception(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JButton newCustomer = new JButton("New Customer Form");
        newCustomer.setBounds(10, 30, 200, 30);
        newCustomer.setBackground(Color.BLACK);
        newCustomer.setForeground(Color.WHITE);
        add(newCustomer);

        JButton rooms = new JButton("Rooms");
        rooms.setBackground(Color.BLACK);
        rooms.setBounds(10, 70, 200, 30);
        rooms.setForeground(Color.WHITE);
        add(rooms);

        JButton department = new JButton("Department");
        department.setBackground(Color.BLACK);
        department.setBounds(10, 110, 200, 30);
        department.setForeground(Color.WHITE);
        add(department);

        JButton allEmployees = new JButton("All Employees");
        allEmployees.setBackground(Color.BLACK);
        allEmployees.setBounds(10, 150, 200, 30);
        allEmployees.setForeground(Color.WHITE);
        add(allEmployees);

        JButton customers = new JButton("Customer Info");
        customers.setBackground(Color.BLACK);
        customers.setBounds(10, 190, 200, 30);
        customers.setForeground(Color.WHITE);
        add(customers);

        JButton manager = new JButton("Manager Info");
        manager.setBackground(Color.BLACK);
        manager.setBounds(10, 230, 200, 30);
        manager.setForeground(Color.WHITE);
        add(manager);

        JButton checkout = new JButton("Checkout");
        checkout.setBackground(Color.BLACK);
        checkout.setBounds(10, 270, 200, 30);
        checkout.setForeground(Color.WHITE);
        add(checkout);

        JButton update = new JButton("Update Status");
        update.setBackground(Color.BLACK);
        update.setBounds(10, 310, 200, 30);
        update.setForeground(Color.WHITE);
        add(update);

        JButton roomStatus = new JButton("Update Room Status");
        roomStatus.setBackground(Color.BLACK);
        roomStatus.setBounds(10, 350, 200, 30);
        roomStatus.setForeground(Color.WHITE);
        add(roomStatus);

        JButton pickup = new JButton("Pickup Service");
        pickup.setBackground(Color.BLACK);
        pickup.setBounds(10, 390, 200, 30);
        pickup.setForeground(Color.WHITE);
        add(pickup);

        JButton searchRoom = new JButton("Search Room");
        searchRoom.setBackground(Color.BLACK);
        searchRoom.setBounds(10, 430, 200, 30);
        searchRoom.setForeground(Color.WHITE);
        add(searchRoom);

        JButton logout = new JButton("Logout");
        logout.setBackground(Color.BLACK);
        logout.setBounds(10, 30, 200, 30);
        logout.setForeground(Color.WHITE);
        add(logout);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(250, 30, 500, 470);
        add(image);

        setBounds(350, 200, 800, 570);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Reception();
    }
}
