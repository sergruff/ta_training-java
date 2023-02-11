package com.epam.training.student_Sergei_Bespalov.tickets;

public class Bug extends Ticket {
    UserStory userStory;
    public static Bug createBug(int id, String name, int estimate, UserStory userStory) {
        if (userStory==null) {return null;}
        if (userStory.isCompleted()) {
            return new Bug(id,name,estimate,userStory);
        }
        return null;
    }

    private Bug(int id, String name, int estimate, UserStory userStory) {
        super(id, name, estimate);
        this.userStory = userStory;
    }

    @Override
    public String toString() {
        return "[Bug "+super.getId()+"] " + userStory.getName() +": " + super.getName();
    }
}
