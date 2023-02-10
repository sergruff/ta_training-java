package com.epam.training.student_Sergei_Bespalov;

public class CountDownTask implements Task{
    private int countDown;
    public CountDownTask(int value) {
        if (value>=0) {
            countDown = value;
        }
    }
    public int getValue() {
        return countDown;
    }
    @Override
    public void execute() {
        if (!this.isFinished()) {
            countDown--;
        }
    }
    @Override
    public boolean isFinished() {
        return (countDown==0);
    }
}
