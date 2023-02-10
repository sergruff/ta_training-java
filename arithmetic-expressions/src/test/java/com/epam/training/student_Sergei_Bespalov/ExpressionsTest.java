package com.epam.training.student_Sergei_Bespalov;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExpressionsTest {

    @Test
    void testRegularPositiveCase() {
        Expression expression = Expressions.fraction(
                Expressions.product(
                        Expressions.var("a", 5),
                        Expressions.sum(
                                Expressions.val(8),
                                Expressions.var("b", 22)
                        )
                ),
                Expressions.difference(
                        Expressions.val(100),
                        Expressions.var("c", 98)
                )
        );

        assertAll(
                () -> assertEquals("((a * (8 + b)) / (100 - c))", expression.toExpressionString()),
                () -> assertEquals(75, expression.evaluate())
        );
    }

    @Test
    void testRegularPositiveCaseChangeVars() {
        Variable a = Expressions.var("a", 5);
        Variable b = Expressions.var("b", 22);
        Variable c = Expressions.var("c", 98);

        Expression expression = Expressions.fraction(
                Expressions.product(
                        a,
                        Expressions.sum(
                                Expressions.val(8),
                                b
                        )
                ),
                Expressions.difference(
                        Expressions.val(100),
                        c
                )
        );

        assertAll(
                () -> assertEquals("((a * (8 + b)) / (100 - c))", expression.toExpressionString()),
                () -> assertEquals(75, expression.evaluate())
        );

        a.setValue(4);
        b.setValue(-2);
        c.setValue(88);

        assertAll(
                () -> assertEquals("((a * (8 + b)) / (100 - c))", expression.toExpressionString()),
                () -> assertEquals(2, expression.evaluate())
        );
    }

    @Test
    void testVal() {
        Expression val;

        val = Expressions.val(789);

        assertEquals(789, val.evaluate());
        assertEquals("789", val.toExpressionString());

        val = Expressions.val(-951);

        assertEquals(-951, val.evaluate());
        assertEquals("(-951)", val.toExpressionString());
    }

    @Test
    void testSimpleSum() {
        Expression sum;

        sum = Expressions.sum(Expressions.var("a", 7), Expressions.val(9));

        assertEquals("(a + 9)", sum.toExpressionString());
        assertEquals(16, sum.evaluate());

        sum = Expressions.sum(Expressions.var("a", -7), Expressions.val(-2), Expressions.var("alpha", 789));

        assertEquals("(a + (-2) + alpha)", sum.toExpressionString());
        assertEquals(780, sum.evaluate());

        sum = Expressions.sum(Expressions.val(1), Expressions.val(2), Expressions.val(3), Expressions.val(4), Expressions.val(5), Expressions.val(6));

        assertEquals("(1 + 2 + 3 + 4 + 5 + 6)", sum.toExpressionString());
        assertEquals(21, sum.evaluate());

        Variable x1 = Expressions.var("x1", 7);
        Variable x2 = Expressions.var("x2", 7);
        Variable x3 = Expressions.var("x3", 7);
        sum = Expressions.sum(x1, x2, x3);

        assertEquals("(x1 + x2 + x3)", sum.toExpressionString());
        assertEquals(21, sum.evaluate());

        x1.setValue(159);
        x2.setValue(753);
        x3.setValue(-1000);

        assertEquals("(x1 + x2 + x3)", sum.toExpressionString());
        assertEquals(-88, sum.evaluate());
    }

    @Test
    void testSimpleProduct() {
        Expression prod;

        prod = Expressions.product(Expressions.var("a", 7), Expressions.val(9));

        assertEquals("(a * 9)", prod.toExpressionString());
        assertEquals(63, prod.evaluate());

        prod = Expressions.product(Expressions.var("a", -7), Expressions.val(-2), Expressions.var("alpha", 789));

        assertEquals("(a * (-2) * alpha)", prod.toExpressionString());
        assertEquals(11046, prod.evaluate());

        prod = Expressions.product(Expressions.val(1), Expressions.val(2), Expressions.val(3), Expressions.val(4), Expressions.val(5), Expressions.val(6));

        assertEquals("(1 * 2 * 3 * 4 * 5 * 6)", prod.toExpressionString());
        assertEquals(720, prod.evaluate());

        Variable x1 = Expressions.var("x1", 7);
        Variable x2 = Expressions.var("x2", 7);
        Variable x3 = Expressions.var("x3", 7);
        prod = Expressions.product(x1, x2, x3);

        assertEquals("(x1 * x2 * x3)", prod.toExpressionString());
        assertEquals(343, prod.evaluate());

        x1.setValue(159);
        x2.setValue(753);
        x3.setValue(-1000);

        assertEquals("(x1 * x2 * x3)", prod.toExpressionString());
        assertEquals(-119_727_000, prod.evaluate());
    }

    @Test
    void testSimpleDifference() {
        Expression diff;

        diff = Expressions.difference(Expressions.var("a", 72), Expressions.val(9));

        assertEquals("(a - 9)", diff.toExpressionString());
        assertEquals(63, diff.evaluate());

        diff = Expressions.difference(Expressions.var("a", -77), Expressions.val(-11));

        assertEquals("(a - (-11))", diff.toExpressionString());
        assertEquals(-66, diff.evaluate());

        Variable x1 = Expressions.var("x1", 7);
        Variable x2 = Expressions.var("x2", 7);
        diff = Expressions.difference(x1, x2);

        assertEquals("(x1 - x2)", diff.toExpressionString());
        assertEquals(0, diff.evaluate());

        x1.setValue(343);
        x2.setValue(-7);

        assertEquals("(x1 - x2)", diff.toExpressionString());
        assertEquals(350, diff.evaluate());
    }

    @Test
    void testSimpleFraction() {
        Expression fraction;

        fraction = Expressions.fraction(Expressions.var("a", 72), Expressions.val(9));

        assertEquals("(a / 9)", fraction.toExpressionString());
        assertEquals(8, fraction.evaluate());

        fraction = Expressions.fraction(Expressions.var("a", -77), Expressions.val(-11));

        assertEquals("(a / (-11))", fraction.toExpressionString());
        assertEquals(7, fraction.evaluate());

        Variable x1 = Expressions.var("x1", 7);
        Variable x2 = Expressions.var("x2", 7);
        fraction = Expressions.fraction(x1, x2);

        assertEquals("(x1 / x2)", fraction.toExpressionString());
        assertEquals(1, fraction.evaluate());

        x1.setValue(343);
        x2.setValue(-7);

        assertEquals("(x1 / x2)", fraction.toExpressionString());
        assertEquals(-49, fraction.evaluate());
    }

    @Test
    void testDeepSum() {
        Expression expression =
                Expressions.sum(
                        Expressions.val(1),
                        Expressions.sum(
                                Expressions.val(2),
                                Expressions.sum(
                                        Expressions.val(3),
                                        Expressions.sum(
                                                Expressions.val(4),
                                                Expressions.val(5)
                                        )
                                )
                        )
                );

        assertEquals("(1 + (2 + (3 + (4 + 5))))", expression.toExpressionString());
        assertEquals(15, expression.evaluate());
    }

    @Test
    void testDeepProduct() {
        Expression expression =
                Expressions.product(
                        Expressions.val(1),
                        Expressions.product(
                                Expressions.val(2),
                                Expressions.product(
                                        Expressions.val(3),
                                        Expressions.product(
                                                Expressions.val(4),
                                                Expressions.val(5)
                                        )
                                )
                        )
                );

        assertEquals("(1 * (2 * (3 * (4 * 5))))", expression.toExpressionString());
        assertEquals(120, expression.evaluate());
    }

    @Test
    void testDeepFraction() {
        Expression expression =
                Expressions.fraction(
                        Expressions.val(999_999),
                        Expressions.fraction(
                                Expressions.val(81),
                                Expressions.fraction(
                                        Expressions.val(27),
                                        Expressions.fraction(
                                                Expressions.val(9),
                                                Expressions.val(3)
                                        )
                                )
                        )
                );

        assertEquals("(999999 / (81 / (27 / (9 / 3))))", expression.toExpressionString());
        assertEquals(111_111, expression.evaluate());
    }

    @Test
    void testDeepDifference() {
        Expression expression =
                Expressions.difference(
                        Expressions.val(999_999),
                        Expressions.difference(
                                Expressions.val(81),
                                Expressions.difference(
                                        Expressions.val(27),
                                        Expressions.difference(
                                                Expressions.val(9),
                                                Expressions.val(3)
                                        )
                                )
                        )
                );

        assertEquals("(999999 - (81 - (27 - (9 - 3))))", expression.toExpressionString());
        assertEquals(999_939, expression.evaluate());
    }


}