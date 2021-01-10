package ru.job4j.oop;

public class BallStory {
    public static void main(String[] args) {
        Ball ball = new Ball();
        Hare hare = new Hare();
        Wolf wolf = new Wolf();
        Fox fox = new Fox();

        boolean escaped;

        /**
         * Если делать идентично тому, что в задании.
         */
        hare.eat(ball);
        ball.run(hare);
        wolf.eat(ball);
        ball.run(wolf);
        fox.eat(ball);
        ball.run(fox);


        /**
         * Если добавить немного фантазии
         */
        hare.eat(ball);
        escaped = ball.run(hare);
        System.out.println("ball escaped hare: " + escaped);
        wolf.eat(ball);
        escaped = ball.run(wolf);
        System.out.println("ball escaped wolf: " + escaped);
        fox.eat(ball);
        escaped = ball.run(fox);
        System.out.println("ball escaped fox: " + escaped);
    }
}
