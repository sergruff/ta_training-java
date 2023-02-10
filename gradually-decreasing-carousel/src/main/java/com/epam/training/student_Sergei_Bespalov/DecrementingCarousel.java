package com.epam.training.student_Sergei_Bespalov;

public class DecrementingCarousel {
    boolean activeFlag = true;
    int[] elementContainer;
    int addIndex = 0;
    public DecrementingCarousel(int capacity) {
        this.elementContainer = new int[capacity];
    }

    public boolean addElement(int element){
        if(!activeFlag||element<=0||addIndex>=elementContainer.length) {return false;}
        elementContainer[addIndex] = element;
        addIndex++;
        return true;
    }
    public int getElement (int num){
        if (num<elementContainer.length) {
            return elementContainer[num];
        }
        else return -1;
    }
    public int getLength() {
        return elementContainer.length;
    }
    public void setElement (int num,int value){
        if(num>=0) {
            elementContainer[num] = value;
        }
    }
    public CarouselRun run(){
        if(!activeFlag) { return null;}
        activeFlag = false;
        return new CarouselRun(this);
    }
}
