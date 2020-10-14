package ru.job4j.tracker;

import java.util.List;

public class StubInput implements Input {
    //private String[] answers;                                                                         replace to List
    private List<String> answers;
    private int position = 0;

   // public StubInput(String[] answers) {                                                              replace to List
        public StubInput(List<String> answers) {
        this.answers = answers;
    }

    @Override
    public String askStr(String question) {
        //return answers[position++];                                                                   replace to List
        return answers.get(position++);
    }

    @Override
    public int askInt(String question) {
        return Integer.parseInt(askStr(question));
    }
}