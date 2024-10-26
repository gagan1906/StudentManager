package com.example.assignment01;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Student {
    private final IntegerProperty recordNumber = new SimpleIntegerProperty();
    private final IntegerProperty studentID = new SimpleIntegerProperty();
    private final StringProperty studentName = new SimpleStringProperty();
    private final StringProperty studentMajor = new SimpleStringProperty();

    public Student(int recordNumber, int studentID, String studentName, String studentMajor) {
        this.recordNumber.set(recordNumber);
        this.studentID.set(studentID);
        this.studentName.set(studentName);
        this.studentMajor.set(studentMajor);
    }

    public Student(int recordNumber, String text, String text1) {
    }

    public int getRecordNumber() {
        return recordNumber.get();
    }

    public void setRecordNumber(int recordNumber) {
        this.recordNumber.set(recordNumber);
    }

    public IntegerProperty recordNumberProperty() {
        return recordNumber;
    }

    public int getStudentID() {
        return studentID.get();
    }

    public void setStudentID(int studentID) {
        this.studentID.set(studentID);
    }

    public IntegerProperty studentIDProperty() {
        return studentID;
    }

    public String getStudentName() {
        return studentName.get();
    }

    public void setStudentName(String studentName) {
        this.studentName.set(studentName);
    }

    public StringProperty studentNameProperty() {
        return studentName;
    }

    public String getStudentMajor() {
        return studentMajor.get();
    }

    public void setStudentMajor(String studentMajor) {
        this.studentMajor.set(studentMajor);
    }

    public StringProperty studentMajorProperty() {
        return studentMajor;
    }
}