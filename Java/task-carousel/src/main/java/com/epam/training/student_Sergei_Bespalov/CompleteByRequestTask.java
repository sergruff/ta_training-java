package com.epam.training.student_Sergei_Bespalov;

public class CompleteByRequestTask implements Task {
    boolean complete = false;
    boolean finished = false;
    @Override
    public void execute() {
        if (complete) {finished = true;}
    }
    @Override
    public boolean isFinished() {
        return finished;
    }
    public void complete() {
        complete = true;
    }
}
