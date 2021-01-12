package ru.job4j.oop;

public class BallStory {
    public static void main(String[] args) {
        Ball ball = new Ball();
        Hare hare = new Hare();
        Wolf wolf = new Wolf();
        Fox fox = new Fox();

        boolean escaped;

        escaped = hare.eat(ball);
        escaped = ball.run(escaped);
        System.out.println("ball escaped hare: " + escaped);
        escaped = wolf.eat(ball);
        escaped = ball.run(escaped);
        System.out.println("ball escaped wolf: " + escaped);
        escaped = fox.eat(ball);
        escaped = ball.run(escaped);
        System.out.println("ball escaped fox: " + escaped);
    }
}
