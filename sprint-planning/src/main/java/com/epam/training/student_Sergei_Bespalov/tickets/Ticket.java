package com.epam.training.student_Sergei_Bespalov.tickets;

public class Ticket {
    private int id; //индентификатор
    private String name; // Имя
    private int estimate; //время для выполнения

    private boolean comp = false;
    public Ticket(int id, String name, int estimate) {
        this.id = id;
        this.name = name;
        this.estimate = estimate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isCompleted() {
        return comp;
    }

    public void complete() {
        comp = true;
    }

    public int getEstimate() {
        return estimate;
    }
}
