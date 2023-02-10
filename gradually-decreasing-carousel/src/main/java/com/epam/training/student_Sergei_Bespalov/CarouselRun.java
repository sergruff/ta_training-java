package com.epam.training.student_Sergei_Bespalov;

public class CarouselRun {
    DecrementingCarousel target;
    int id = 0;
    int decrisor = 1;
    public CarouselRun (DecrementingCarousel obj) {
       this.target = obj;
    }
    public int next() {
        if (target.getClass()==DecrementingCarousel.class) {
            for (int i=0;i<=target.getLength();i++){
                int valueToDecrement = target.getElement(id);
                if (target.getElement(id)>0) {
                    target.setElement(id, target.getElement(id) -1);
                    id++;
                    return valueToDecrement;
                }
                id++;
                if (id>target.getLength()) {id=0;}
            }
            return -1;
        }
        else if (target.getClass()== GraduallyDecreasingCarousel.class)
        {
            for (int i=0;i<=target.getLength();i++){
                int valueToDecrement = target.getElement(id);
                if (target.getElement(id)>0) {
                    target.setElement(id, target.getElement(id) -decrisor);
                    id++;
                    return valueToDecrement;
                }
                id++;
                if (id>target.getLength()) {
                    id=0;
                    decrisor++;
                }
            }
            return -1;
        }
        throw new UnsupportedOperationException();
    }

    public boolean isFinished() {
        for (int i=0;i<target.getLength();i++){
            if (target.getElement(i)>0) {return false;}
        }
        return true;
    }

}
