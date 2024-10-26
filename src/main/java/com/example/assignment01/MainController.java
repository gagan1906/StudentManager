package com.example.assignment01;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

@SuppressWarnings("unused")
public class MainController {

    @FXML
    private TableColumn<Student, Integer> idColumn;

    @FXML
    private TableColumn<Student, String> nameColumn;

    @FXML
    private TableColumn<Student, String> emailColumn;

    @FXML
    private TableColumn<Student, String> majorColumn;

    @FXML
    private TableView<Student> tableView;

    @FXML
    private Label welcomeText;

    ObservableList<Student> studentData = FXCollections.observableArrayList(
            new Student(1, 200574624, "Gagandeep", "Computer programming"),
            new Student(2, 200574625, "Abhimanyu dadwal", "Computer programming"),
            new Student(3, 200572470, "Jashan", "Computer programming"),
            new Student(4, 200573209, "Harshpreet", "Computer programming")
    );

    public ObservableList<Student> getStudentData() {
        return studentData;
    }

    public void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<Student, Integer>("studentID"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("studentName"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("studentEmail"));
        majorColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("studentMajor"));
        tableView.setItems(studentData);
    }

    @FXML
    private TextField ID;

    @FXML
    private TextField Name;

    @FXML
    private TextField major;

    @FXML
    private Button add;

    @FXML
    private Button delete;

    @FXML
    private Button update;

    @FXML
    void addStudent(ActionEvent event) {
        Student student1 = new Student(Integer.parseInt(ID.getText()), Name.getText(), major.getText());
        studentData.add(student1);
        tableView.refresh();
        clearTextFields();
    }

    @FXML
    void deleteStudent(ActionEvent event) {
        Student student = tableView.getSelectionModel().getSelectedItem();
        studentData.remove(student);
        tableView.refresh();
        clearTextFields();
    }

    @FXML
    void updateStudent(ActionEvent event) {
        int currentStudentID = Integer.parseInt(ID.getText());
        ObservableList<Student> currentData = getStudentData();

        for (Student student : currentData) {
            if (student.getStudentID() == currentStudentID) {
                student.setStudentName(Name.getText());
                student.setStudentMajor(major.getText());

                tableView.refresh();
                clearTextFields();
                break;
            }
        }
    }

    @FXML
    void rowClicked(MouseEvent event) {
        Student student = tableView.getSelectionModel().getSelectedItem();
        ID.setText(String.valueOf(student.getStudentID()));
        Name.setText(student.getStudentName());
        major.setText(student.getStudentMajor());
    }

    public Integer getID() {
        try {
            return Integer.parseInt(ID.getText());
        } catch (NumberFormatException e) {
            showAlert("Invalid Student ID", "Please enter a valid student ID!");
            return null;
        }
    }

    public String getName() {
        return Name.getText();
    }

    public String getMajor() {
        return major.getText();
    }

    public void clearTextFields() {
        ID.clear();
        Name.clear();
        major.clear();
    }

    @FXML
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR); // Creating the alert
        alert.setTitle(title); // Setting the title of the alert that will be given in the catch block of the code
        alert.setHeaderText(null);
        alert.setContentText(message); // Setting the message of the alert that will be given in the catch block
        alert.showAndWait();
    }
}