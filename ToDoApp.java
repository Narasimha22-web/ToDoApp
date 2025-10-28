import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ToDoApp extends JFrame {
    private DefaultListModel<String> taskListModel;
    private JList<String> taskList;
    private JTextField taskField;
    private JButton addButton, deleteButton;

    public ToDoApp() {
        // Frame settings
        setTitle("To-Do List App");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(10, 10));

        // Task list setup
        taskListModel = new DefaultListModel<>();
        taskList = new JList<>(taskListModel);
        JScrollPane scrollPane = new JScrollPane(taskList);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Input field and buttons
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        taskField = new JTextField(20);
        addButton = new JButton("Add Task");
        deleteButton = new JButton("Delete Task");

        inputPanel.add(taskField);
        inputPanel.add(addButton);
        inputPanel.add(deleteButton);

        panel.add(inputPanel, BorderLayout.SOUTH);

        // Add action listeners
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String task = taskField.getText().trim();
                if (!task.isEmpty()) {
                    taskListModel.addElement(task);
                    taskField.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a task!");
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = taskList.getSelectedIndex();
                if (selectedIndex != -1) {
                    taskListModel.remove(selectedIndex);
                } else {
                    JOptionPane.showMessageDialog(null, "Select a task to delete!");
                }
            }
        });

        // Add panel to frame
        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ToDoApp::new);
    }
}
