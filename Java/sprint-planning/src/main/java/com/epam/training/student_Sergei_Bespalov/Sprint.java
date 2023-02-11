package com.epam.training.student_Sergei_Bespalov;

import com.epam.training.student_Sergei_Bespalov.tickets.Bug;
import com.epam.training.student_Sergei_Bespalov.tickets.Ticket;
import com.epam.training.student_Sergei_Bespalov.tickets.UserStory;

public class Sprint {
    Ticket[] ticketBank;
    private int capacity;
    private int ticketsLimit;
    private int numberOfTickets=0;
    private int currentCapacity = 0;
    public Sprint(int capacity, int ticketsLimit) {
        this.capacity = capacity;
        this.ticketsLimit = ticketsLimit;
        this.ticketBank = new Ticket[0];
    }

    public boolean addUserStory(UserStory userStory) {
        if (userStory==null) {return false;}
        if (numberOfTickets<ticketsLimit&&(capacity-currentCapacity-userStory.getEstimate()>=0)&&!userStory.isCompleted()) {
            if (0 != userStory.getDependencies().length){
                if (ticketBank.length == 0) {
                    return false;
                }
                for (int i=0;i<userStory.getDependencies().length;i++)
                {
                    for (int j=0;j<ticketBank.length; j++) {
                        if (userStory.getDependencies()[i] == ticketBank[j]) {
                            break;
                        }
                        if (j == ticketBank.length-1){
                            return false;
                        }
                    }
                }
            }
            numberOfTickets++;
            Ticket[] newTicketBank = new Ticket[numberOfTickets];
            System.arraycopy(ticketBank,0, newTicketBank, 0, ticketBank.length);
            ticketBank = newTicketBank;
            ticketBank[numberOfTickets-1] = userStory;
            currentCapacity+=userStory.getEstimate();
            return true;
        } else return false;
    }

    public boolean addBug(Bug bugReport) {
        if (bugReport==null) {
            return false;
        }
        if (bugReport.isCompleted()) {
            return false;
        }
        if (numberOfTickets<ticketsLimit&&(capacity-currentCapacity-bugReport.getEstimate()>=0)) {
            numberOfTickets++;
            Ticket[] newTicketBank = new Ticket[numberOfTickets];
            System.arraycopy(ticketBank,0, newTicketBank, 0, ticketBank.length);
            ticketBank = newTicketBank;
            ticketBank[numberOfTickets-1] = bugReport;
            currentCapacity+=bugReport.getEstimate();
            return true;
        }
        return false;
    }

    public Ticket[] getTickets() {
        return ticketBank.clone();
    }

    public int getTotalEstimate() {
        return currentCapacity;
    }
}
