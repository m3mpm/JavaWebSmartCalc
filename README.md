# JavaWebSmartCalc

Создание web-приложения _**SmartCalc**_ на языке Java.
Web-приложение разрабатывается с использование Spring MVC-фреймворка и REST контроллера.

## Запуск программы

### Запуск через терминал

- В терминале перейти в корневую папку проекта JavaWebSmartCalc/
- В данной папке находиться Makefile
- В терминале ввести команду **make app**
- Открыть браузер, в адресной строке ввести **localhost:8080** и пользоваться программой
- Для остановки программы необходимо в терминале нажать на сочетание кнопок Control + C(MacOs) или Ctrl + C

### Запуск через Docker

- Запустить Docker на ПК
- В терминале перейти в корневую папку проекта JavaWebSmartCalc/
- В данной папке находиться Makefile
- В терминале ввести команду **make start**, начнется сброка контейнера
- После сборки контейнера открыть браузер, в адресной строке ввести **localhost:80** и пользоваться программой
- Для остановки программы необходимо в терминале ввести команду **make stop**, контейнер остановиться, образы удалятся

## Описание JavaWebSmartCalc

- Программа разработана на языке Java, JavaScript, HTML, CSS
- На вход программы могут подаваться как целые числа, так и вещественные числа, записанные и через точку, и в экспоненциальной форме записи
- Вычисление производится после полного ввода вычисляемого выражения и нажатия на символ `=`
- Программа хранит историю операций, позволять загружать выражения из истории и очищать историю целиком
- Программа позволяет построить график функции, заданной с помощью выражения в инфиксной нотации с переменной _x_  (с координатными осями, отметкой используемого масштаба и сеткой с адаптивным шагом)
- JavaWebSmartCalc поддерживать следующие арифметические операции и математические функции:

    - **Арифметические операторы**:

      | Название оператора | Инфиксная нотация <br /> (Классическая) | Префиксная нотация <br /> (Польская нотация) |  Постфиксная нотация <br /> (Обратная польская нотация) |
      | ------ | ------ | ------ | ------ |
      | Скобки | (a + b) | (+ a b) | a b + |
      | Сложение | a + b | + a b | a b + |
      | Вычитание | a - b | - a b | a b - |
      | Умножение | a * b | * a b | a b * |
      | Деление | a / b | / a b | a b \ |
      | Возведение в степень | a ^ b | ^ a b | a b ^ |
      | Остаток от деления | a mod b | mod a b | a b mod |
      | Унарный плюс | +a | +a | a+ |
      | Унарный минус | -a | -a | a- |

    - **Функции**:

    | Описание функции | Функция |   
    | ---------------- | ------- |  
    | Вычисляет косинус | cos(x) |   
    | Вычисляет синус | sin(x) |  
    | Вычисляет тангенс | tan(x) |  
    | Вычисляет арккосинус | acos(x) | 
    | Вычисляет арксинус | asin(x) | 
    | Вычисляет арктангенс | atan(x) |
    | Вычисляет квадратный корень | sqrt(x) |
    | Вычисляет натуральный логарифм | ln(x) | 
    | Вычисляет десятичный логарифм | log(x) |

## Дополнение. Кредитный калькулятор

- Реализация кредитного калькулятора.
- На вход подается общая сумма кредита, срок, процентная ставка, тип (аннуитетный, дифференцированный).
- Результат: ежемесячный платеж, переплата по кредиту, общая выплата

## GIF анимация (загрузка занимает некоторое время)

![](https://github.com/m3mpm/JavaWebSmartCalc/blob/main/materials/screenshot.gif)
