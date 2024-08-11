import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class signUpPage {

    private  static  final String url = "jdbc:mysql://localhost:3306/student_management_system";
    private  static  final String username = "root";
    private static final String password = "root";

    Statement statement;
    Connection connection;

    signUpPage() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            connection = DriverManager.getConnection(url, username, password);

            statement = connection.createStatement();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        JFrame frame = new JFrame("EduRank");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 800);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setLayout(new GridLayout());

        ImageIcon titleLogo = new ImageIcon("Title Logo.png");
        Image image = titleLogo.getImage();
        frame.setIconImage(image);


        JPanel signUpPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon icon = new ImageIcon("F:\\Programming\\Java\\Please finish this one\\Images\\SignUp Page Cover.png");
                g.drawImage(icon.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        signUpPanel.setLayout(null);

        JPanel whitePanel = new JPanel();
        whitePanel.setBackground(Color.white);
        whitePanel.setLayout(null);
        whitePanel.setBounds(0,0,500,800);
        signUpPanel.add(whitePanel);

        JLabel signUpTextLabel = new JLabel("Sign Up");
        signUpTextLabel.setBounds(70, 80, 200,100);
        signUpTextLabel.setFont(new Font("Times New Roman", Font.BOLD, 45));
        signUpTextLabel.setForeground(new Color(102,178,255));


        JLabel welcomeTextLabel = new JLabel("Welcome to EduRank !");
        welcomeTextLabel.setBounds(70, 137, 300,100);
        welcomeTextLabel.setFont(new Font("Ariel", Font.BOLD, 17));
        welcomeTextLabel.setForeground(new Color(102,0,0));


        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(70, 190, 100,100);
        usernameLabel.setFont(new Font("Ariel", Font.BOLD, 15));
        usernameLabel.setForeground(Color.BLACK);


        JTextField usernameTextField = new JTextField();
        usernameTextField.setBounds(70, 260, 250, 35);
        usernameTextField.setFont(new Font("Ariel", Font.BOLD, 13));
        usernameTextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                usernameTextField.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (usernameTextField.getText().isEmpty()) {
                    usernameTextField.setText("Please enter your Username");
                }
            }
        });

        JLabel emailLabel = new JLabel("Email");
        emailLabel.setBounds(70, 280, 100,100);
        emailLabel.setFont(new Font("Ariel", Font.BOLD, 15));
        emailLabel.setForeground(Color.black);

        JTextField emailTextField = new JTextField();
        emailTextField.setBounds(70, 350, 250, 35);
        emailTextField.setFont(new Font("Ariel", Font.BOLD, 13));
        emailTextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                emailTextField.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (emailTextField.getText().isEmpty()) {
                    emailTextField.setText("Please enter your Email");
                }
            }
        });

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(70, 370, 100,100);
        passwordLabel.setFont(new Font("Ariel", Font.BOLD, 15));
        passwordLabel.setForeground(Color.black);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(70, 440, 250, 35);
        passwordField.setFont(new Font("Ariel", Font.BOLD, 13));
        passwordField.setEchoChar('*');


        JButton signUpButton = new JButton("Sign In");
        signUpButton.setBounds(93,520,200,35);
        signUpButton.setFont(new Font("Ariel", Font.BOLD, 15));
        signUpButton.setForeground(Color.black);
        signUpButton.setBackground(new Color(102,178,255));
        signUpButton.setFocusable(false);
        ActionListener actionListener = e -> {
            if(e.getSource() == signUpButton) {
                try {
                    statement = connection.createStatement();
                    String query = String.format("INSERT INTO personal_details(USERNAME, PASSWORD, EMAIL) VALUES('%s', '%s', '%s')",usernameTextField.getText(), new String(passwordField.getPassword()), emailTextField.getText());

                    if(usernameTextField.getText().isEmpty() || emailTextField.getText().isEmpty() || (new String(passwordField.getPassword())).isEmpty()) {
                        JOptionPane.showMessageDialog(null,"Information blank.",
                                "ERROR", JOptionPane.WARNING_MESSAGE);
                    } else {
                        statement.executeUpdate(query);

                        int result = JOptionPane.showOptionDialog(
                                null,
                                "Sign in Successful ! Please Login.",
                                "Confirmation",
                                JOptionPane.DEFAULT_OPTION,
                                JOptionPane.PLAIN_MESSAGE,
                                null,
                                null,
                                0);
                        System.out.println(result);
                        if(result == 0) new loginPage();
                    }

                } catch (SQLException exception) {
                    System.out.println(exception.getMessage());
                }
            }
        };
        signUpButton.addActionListener(actionListener);

        JLabel NoAccountLabel = new JLabel("Already have an account ?");
        NoAccountLabel.setBounds(78, 550, 300,100);
        NoAccountLabel.setFont(new Font("Ariel", Font.BOLD, 14));
        NoAccountLabel.setForeground(Color.BLACK);

        JLabel loginLabel = new JLabel("<html><u>Login</u></html>");
        loginLabel.setBounds(268, 550, 300,100);
        loginLabel.setFont(new Font("Ariel", Font.BOLD, 14));
        loginLabel.setForeground(new Color(204,0,0));
        loginLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new loginPage();
            }
        });

        whitePanel.add(usernameLabel);
        whitePanel.add(passwordLabel);
        whitePanel.add(emailLabel);
        whitePanel.add(signUpTextLabel);
        whitePanel.add(welcomeTextLabel);
        whitePanel.add(usernameTextField);
        whitePanel.add(passwordField);
        whitePanel.add(emailTextField);
        whitePanel.add(signUpButton);
        whitePanel.add(NoAccountLabel);
        whitePanel.add(loginLabel);

        frame.add(signUpPanel);

        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new signUpPage();
    }
}



