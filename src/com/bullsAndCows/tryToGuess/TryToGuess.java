package com.bullsAndCows.tryToGuess;

import com.bullsAndCows.complexityOfGame.ComplexityOfGame;
import com.bullsAndCows.print.Print;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 3) После этого пользователю предлагает ввести свою отгадку последовательности.
 * Валидной попыткой считается последовательность различных цифр правильной длины
 * (например, 1234). Невалидные попытки отклоняются.
 * 4) Для валидной попытки программа должна выдать пользователю
 * результат совпадения – 2 числа:
 * ✓ 1 число – «коровы» – число угаданных цифр,которые находятся на неправильных позициях;
 * ✓ 2 число – «быки» - число угаданных цифр, которые находятся на правильных позициях;
 * 5) Если после попытки пользователь полностью правильно угадал загаданную последовательность,
 * то ему выводится сообщение об успехе, значение загаданной последовательности и количество попыток.
 * Игра завершается.
 * 6) Если после попытки пользователь не угадал последовательность,
 * то ему предлагается сделать следующую попытку.
 * 7) В качестве попытки пользователь может напечатать «сдаюсь».
 * Тогда ему будет выведена загаданная последовательность и игра завершится.
 *
 *
 * Здесь я считываем отгадку с помощью Scanner в String
 * (если делать через int то при вводе допустим 028 при приобразовании
 * в масив сохраниться 28 работа будет несовсем корректна)
 * Если на вход буде слово "сдаюсь" то мы прерываем цикл и
 * возвращаем массив чар "сдаюсь" для дальнейшей обработки;
 * <p>
 * Далее привел int[] array к String numArrayComp - для сравнения длинны
 * загаданного компьютером значения с входными данными String numSt
 * <p>
 * Нужно вернуть значения в char[] для дальнейшего удобства сравнения результатов
 * для этого я сооздал массив char[] toChar с символами из входного String numSt
 * <p>
 * Если длина загаданного компьютером значения с входными данными String numSt равна, то
 * возврасщаем char[] toChar который хранит в себе входное значение
 * <p>
 * Иначе выводим сообщение.
 * Все это запускаем в while
 *
 * перед блоком if
 * int numInt = Integer.parseInt(numSt); без этой записии на вход спокойно принемает "ааа"
 * при заданой длине 3 (работает как блокатор стринга на вход)
 *
 * Еще создал две переменные быки и коровы .
 * В метод result мы передаем два масива arrayСomp and arrayUser
 * С помощью for перебираем arrayComp
 * Если есть совпадения (значения по ячейкам) c arrayUser то bulls++
 * Иначе открываем второй цикл и смотрим совпадения на неправильных позициях
 * Счетчик int score
 * Если у нас полное совпадение то мы выводим сообщение-поздравление=)
 * Проверяем нехранит ли наш char[] arrayUser значение "сдаюсь"
 * Если тру то выводим спец сообщение и ставим влаг true тем саммым завершая программу
 */

public class TryToGuess  {
    Print print = new Print();

    ComplexityOfGame complexityOfGame = new ComplexityOfGame();

    private int[] arrayComp = complexityOfGame.getArrayComp();

    private char[] arrayUserCh;
    private char[] arrayCompCh;

    // public boolean result = result(arrayUserCh,arrayCompCh);

    public char[] validNumGuess(int[] array) {

        Scanner scanner = new Scanner(System.in);
        String no = "сдаюсь";
        char[] surrender = no.toCharArray();

        while (true) {
            try {
                String numSt = scanner.nextLine();
                char first = numSt.charAt(0);
                if(numSt.equalsIgnoreCase("сдаюсь")){
                    break;
                } else if (first == '-'){
                    numSt = numSt + "xxxx";
                }

                String numArrayComp = "";
                for (int j = 0; j < array.length; j++) {
                    numArrayComp += Integer.toString(array[j]);
                }

                char[] toChar = numSt.toCharArray();
                int numInt = Integer.parseInt(numSt);
                if (numArrayComp.length() == numSt.length()) {
                    return toChar;
                } else {
                    System.out.println("Длинна отгадки больше или меньше длины загадки.");
                    System.out.println("Введите снова:");
                }
            } catch (NumberFormatException e) {
                System.out.println("Некоректный ввод\nВведите снова:");
            }

        }
        return surrender;
    }

    /**
     * Трансформация Массива типа инт в Массив типа Чар
     */
    public char[] convertingArrToChar(int[] array){
        String numArrayComp = "";
        for (int j = 0; j < array.length; j++) {
            numArrayComp += Integer.toString(array[j]);
        }
        char[] arrayCh = numArrayComp.toCharArray();
        return arrayCh;
    }


    private int score = 0;
    private int cows = 0;
    private int bulls = 0;


    public boolean result(char[] arrayComp, char[] arrayUser) {
        score++;
        for (int i = 0; i < arrayComp.length; i++) {
            if (arrayComp[i] == arrayUser[i]) {
                bulls++;
            } else {
                for (int j = 0; j < arrayComp.length; j++) {
                    if (arrayComp[i] == arrayUser[j]) {
                        cows++;
                        break;
                    }
                }
            }

            if (Arrays.equals(arrayComp,arrayUser)) {
                System.out.println("Успех!!!\nПоздравляю вы угадали");
                System.out.println("Количество попыток: " + score);
                System.out.print("Значение загаданной последовательности: ");
                this.bulls = arrayComp.length;
                System.out.println(arrayComp);
                return true;
            }

        }

        String surrender = "сдаюсь";
        String a = new String(arrayUser);
        if (surrender.equalsIgnoreCase(a)){
            System.out.println("Вы сдались");
            print.print(arrayComp);
            return true;
        }
        return false;
    }


    public void startGame () {
        System.out.println("Ввести свою отгадку последовательности согласно уровню сложности\n" +
                "(например: 0474)\n" + "В качестве попытки введите \"сдаюсь\", игра завершится\n" + "Ввод: ");
        boolean success = false;
        while (!success) {
            arrayUserCh = validNumGuess(arrayComp);
            arrayCompCh = convertingArrToChar(arrayComp);

            success = result(arrayCompCh,arrayUserCh);

            print.printResult(cows, bulls, score);
            this.cows = 0;
            this.bulls = 0;
            if (!success) {
                System.out.println("___________ Ещё :");
            }

        }
    }

}

