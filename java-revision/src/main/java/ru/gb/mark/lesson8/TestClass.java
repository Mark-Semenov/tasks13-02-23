package ru.gb.mark.lesson8;

import java.util.Arrays;

public class TestClass {

    /*
    Алексей, благодарю Вас за вебинары. К сожалению, из-за моего часового пояса
    я не мог присуствовать онлайн, но в записи, честно говоря, даже лучше, тк
    считаю программу курса за bad practice:
    1) Слишком много времени тратится на ожидание ответов
    2) Домашние задания тривиальные и далеки от реальности
    3) Много непокрытых тем

    Не смотря на вышесказанное, Вы провели курс хорошо.
    Мне понравилось что вы делились своим опытом,
    что был код на экране, практические примеры
    и вопросы с подвохом (знание теориии не всегда делает вещи очевидными).

    Спасибо за комментарии на портале, у меня нет там возможности ответить,
    поэтому хочу ответить, что репозиторий в спринг буте работает без аннотации @Repository,
    достаточно расширить класс JpaRepository или др. и автоконфигурация сделает остальное.

    Не совсем понял что сдавать в виде ДЗ
    и поэтому сделал задачу, что была на уроке, немного по-своему))
    Еще раз спасибо и удачи Вам в сложном преподавательском деле!

     */

    public static void main(String[] args) {

        int[] arr = new int[]{-7, -5, -2, 0, 2, 3, 8, 9};
        int[] temp = new int[arr.length];

        //Fast way
        Arrays
                .stream(arr)
                .map(a -> a * a)
                .sorted()
                .forEach(System.out::println);

        //Long way
        int a = arr.length - 1;
        int b = temp.length - 1;
        int i = 0;

        do {

            arr[i] = module(arr[i]);

            if (exponentiation(arr[i]) < exponentiation(arr[a])) {
                temp[b] = exponentiation(arr[a]);
                a--;
            } else {
                temp[b] = exponentiation(arr[i]);
                i++;
            }

            b--;

        } while (b >= 0);

        System.out.println(Arrays.toString(temp));
    }


    //Instead of Math.pow()
    public static int exponentiation(int a) {
        return a * a;
    }

    //Instead of Math.abs()
    public static int module(int a) {
        return (a < 0) ? -a : a;
    }
}
