# Max method

Цель задания – научить вас работать с массивами.

Примерное время выполнения задания: 20 минут.

### Описание
Перейдите в класс [`MaxMethod`](src/main/java/com/epam/training/student_Sergei_Bespalov/MaxMethod.java) и реализуйте метод `max`. 

Правильная реализация должна получить массив значений типа `int` и вернуть его максимальное значение.

Подробности:
- Входной массив гарантированно не будет пустым или `null`.
- Метод `max` не должен изменять массив.
- Входной массив может содержать любое значение типа `int` от `Integer.MIN_VALUE` до `Integer.MAX_VALUE`. 

### Пример
```java
int[] vals = new int[]{-2, 0, 10, 5};
int result = MaxMethod.max(vals);
System.out.println(result == 10); // true
```

