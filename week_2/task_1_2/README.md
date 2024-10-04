# Задание 1.2: Расчеты и методы
***
1. Создайте класс `Octagon`, который будет иметь атрибут `innerRadius`;
2. Реализуйте методы для установки значений этих атрибутов и метод `calculateArea()` и `calculatePerimeter()`, которые будут возвращать площадь и периметр восьмиугольника.
***
**Описание**:
***
Main class:
***
В начале программы создается объект Scanner, с помощью которого пользователь вводит радиус вписанной окружности восьмиугольника.
Программа выводит рассчитанные значения площади и периметра восьмиугольника в консоль.
***
Octagon class:
***
В классе Octagon реализованы методы:
CalculateArea() — вычисляет площадь восьмиугольника по формуле: 8×(sqrt(2)−1)×r^2
CalculatePerimeter() — вычисляет периметр восьмиугольника, исходя из длины стороны, которая определяется через радиус вписанной окружности.