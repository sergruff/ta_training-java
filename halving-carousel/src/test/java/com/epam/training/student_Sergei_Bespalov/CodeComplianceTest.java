package com.epam.training.student_Sergei_Bespalov;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CodeComplianceTest {

    @Test
    void testInheritance() {
        assertEquals(DecrementingCarousel.class, HalvingCarousel.class.getSuperclass());
    }
}
