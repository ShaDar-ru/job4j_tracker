package ru.job4j.calc;

import ru.job4j.calc.acts.Addition;
import ru.job4j.calc.acts.Division;
import ru.job4j.calc.acts.Multiplication;
import ru.job4j.calc.acts.Subtraction;

import java.util.HashMap;
import java.util.Map;

public class Calc {
    private Map<String, Action> actions;
    private String inputText;

    public Calc() {
        fillMap();
    }

    private void init() {
        Input input = new Input();
        Output output = new Output();
        Action action = null;
        ValidateNum vFirst = null;
        ValidateNum vSecond = null;
        boolean run = true;
        while (run) {
            try {
                inputText = input.getText();
                String[] numbers = getNums();
                vFirst = new ValidateNum(numbers[0]);
                vSecond = new ValidateNum(numbers[1]);
                if (vFirst.getNumber().isArabic() != vSecond.getNumber().isArabic()) {
                    throw new InputErrorException();
                }
                action = getAction();
            } catch (InputErrorException e) {
                System.out.println("Не корректный ввод");
                continue;
            }
            run = false;
        }
        Number out = action.execute(vFirst.getNumber(), vSecond.getNumber());
        output.print(out);
    }

    private void fillMap() {
        actions = new HashMap<>();
        actions.put("+", new Addition());
        actions.put("-", new Subtraction());
        actions.put("*", new Multiplication());
        actions.put("/", new Division());
    }

    private String[] getNums() throws InputErrorException {
        String[] rsl = inputText.split("\\p{Punct}");
        if (rsl.length != 2) {
            throw new InputErrorException();
        }
        return rsl;
    }

    private Action getAction() {
        String s = null;
        ValidateAct v = new ValidateAct(inputText);
        try {
            s = v.getValidAct();
        } catch (InputErrorException e) {
            System.out.println("Не корректный ввод");
        }
        return actions.get(s);
    }

    public static void main(String[] args) {
        Calc calc = new Calc();
        calc.init();
    }
}
