package com.epam.training.student_Sergei_Bespalov.tickets;

public class UserStory extends Ticket {
    UserStory[] storyBank;
    public UserStory(int id, String name, int estimate, UserStory... dependsOn) {
        super(id, name, estimate);
        this.storyBank = dependsOn;
    }

    @Override
    public void complete() {
        for (int i=0; i<storyBank.length; i++) {
            if (!storyBank[i].isCompleted()) {
                return;
            }
        }
        super.complete();
    }

    public UserStory[] getDependencies() {
        return storyBank.clone();
    }

    @Override
    public String toString() {
        return "[US " + super.getId()+"] "+ super.getName();
    }
}
