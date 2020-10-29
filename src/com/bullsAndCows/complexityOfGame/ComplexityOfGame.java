package com.bullsAndCows.complexityOfGame;

import com.bullsAndCows.print.Print;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * 1) Вначале пользователю предлагается ввести сложность игры – 3, 4 или 5.
 * Сложность игры – длина загадываемой программой последовательности цифр (0-9).
 * При вводе некоректной сложности игра завершается.
 *
 * Заполняем массив по уровню сложности т.е. только длинна
 * Делаю проверку на ввод (только числа от 3 до 5).
 * Если числа коректны, создаю массив
 * Иначе выводим соответсвующее сообщение сообщение и просим ввести снова.
 *
 2) После определения сложности игры,
 * программа генерирует случайную последовательность цифр,
 * при чем все цифры должны быть разными(например, 0247).
 *
 * Заполняем массив случайными, уникальными числами от 0 до 9;
 * Создал два булева значения и цикл wile т.к.
 * без него после проверки на повтор значения, random может выдать еще раз тоже число
 * и будет повтор значения.
 */

public class ComplexityOfGame {

    Print p = new Print();

    private int [] array = createArray();
    private int[] arrayComp = packArrayRandom(array);

    public int[] getArrayComp() {
        return arrayComp;
    }

    public int[] createArray () {
        System.out.println("Введите сложность игры – 3, 4 или 5:");
        while (true) {
            try {

                Scanner scanner = new Scanner(System.in);
                int scannerRes = scanner.nextInt();

                if (scannerRes >= 3 && scannerRes <= 5) {
                    int[] array = new int[scannerRes];
                    return array;
                } else {
                    System.out.println("Некоректный ввод.\nВвести сложность игры – 3, 4 или 5.");
                }

            } catch (InputMismatchException e){
                System.out.println("Это не число.\nВвести сложность игры – 3, 4 или 5.");
            }
        }

    }

    public int[] packArrayRandom (int [] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            int value = random.nextInt(10);
            boolean repeated = true;
            while (repeated) {
                boolean again = false;
                for (int j = 0; j < i; j++) {
                    if (value != array[j]) {
                        continue;
                    } else {
                        value = random.nextInt(10);
                        again = true;
                        break;
                    }
                }
                if (!again) {
                    repeated = false;
                    array[i] = value;
                }

            }

        }
        //  p.print(array);  //cheat        -----------------------------------------------------------
        return array;
    }

}

