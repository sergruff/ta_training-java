package com.epam.training.student_Sergei_Bespalov;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TaskCarousel {
    private final int  capacity;
    private Task[] taskBank;
    private int current=0;
    private int id = 0;
    public TaskCarousel(int capacity) {
        if (capacity>0) {
            this.capacity = capacity;
            taskBank = new Task[capacity];
        } else {
            this.capacity  = 0;
            taskBank = null;
        }
    }
    public boolean addTask(Task task) {
        if (task==null||this.isFull()||task.isFinished()){
            return false;
        } else {
            taskBank[current] = task;
            current++;
            return true;
        }
    }
    public boolean execute() {
        if (this.isEmpty()) {
            return false;
        }
        taskBank[id].execute();
        if (taskBank[id].isFinished()) {
            List<Task> temp = new ArrayList<>(Arrays.asList(taskBank));
            temp.remove(id);
            taskBank = temp.toArray(new Task[capacity]);
            current--;
            id--;
        }
        if (id<current-1){id++;} else id = 0;
        return true;
    }
    public boolean isFull() {
        return (current == capacity);
    }
    public boolean isEmpty() {
            return current == 0;
    }
}
