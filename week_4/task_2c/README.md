# Задание 2c
Напишите регулярное выражение, которое бы находило символы, повторяющиеся ≥ трёх раз, и заменяло их на один. Реализуйте приложение демонстрирующее работоспособность регулярного выражения.
***
**Описание**:
***
Вводится строка, в которой могут находиться символы, повторяющиеся три и более раз.
***
Регулярное выражение:
Используется регулярное выражение "(.)\\1{2,}", чтобы найти символы, которые повторяются три и более раз.
(.) — захватывает любой символ.
\\1 — ссылается на этот символ и проверяет, что он повторяется минимум дважды подряд (всего три и более).
Метод replaceAll заменяет все найденные группы повторяющихся символов на один экземпляр этого символа. Например, "аааа" становится "а".
***
Выводится строка, в которой все последовательности символов, повторяющихся три и более раз, заменены на один символ.