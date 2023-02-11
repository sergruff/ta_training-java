package com.epam.training.student_Sergei_Bespalov.Planes;

import com.epam.training.student_Sergei_Bespalov.models.ClassificationLevel;
import com.epam.training.student_Sergei_Bespalov.models.ExperimentalTypes;
import com.epam.training.student_Sergei_Bespalov.*;

public class ExperimentalPlane extends Plane{

    private final ExperimentalTypes type;
    private ClassificationLevel classificationLevel;

    public ExperimentalPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, ExperimentalTypes type, ClassificationLevel classificationLevel) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.type = type;
        this.classificationLevel = classificationLevel;
    }

    public ClassificationLevel getClassificationLevel(){
        return classificationLevel;
    }

    public void setClassificationLevel(ClassificationLevel classificationLevel){
        this.classificationLevel = classificationLevel;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "experimentalPlane{" +
                "model='" + super.getModel() + '\'' +
                '}';
    }
}
