package com.clg.offlinequizplay;
import java.util.ArrayList;
import java.util.List;


import java.util.ArrayList;
import java.util.List;

public class QuestionBank {

    public static List<QuestionsList> javaQuestions() {
        final List<QuestionsList> questionsLists = new ArrayList<>();

        // Create objects of QuestionsList class and pass questions along with options and answers
        final QuestionsList question1 = new QuestionsList(
                "What is the size of int variable?",
                "16 bit", "8 bit", "32 bit", "64 bit",
                "32 bit", ""
        );

        final QuestionsList question2 = new QuestionsList(
                "What is the default value of Boolean variable?",
                "true", "false", "null", "undefined",
                "false", ""
        );

        final QuestionsList question3 = new QuestionsList(
                "What of the following is the default value of an instance variable?",
                "0", "null", "Depends upon the type of variable", "Not assigned",
                "Depends upon the type of variable", ""
        );

        final QuestionsList question4 = new QuestionsList(
                "Which is a reserved word in the Java programming language?",
                "methoda", "native", "reference", "goto",
                "native", ""
        );

        final QuestionsList question5 = new QuestionsList(
                "Which of the following is NOT a keyword or reserved word in Java?",
                "if", "then", "goto", "while",
                "then", ""
        );

        final QuestionsList question6 = new QuestionsList(
                "Which is the valid declaration within an interface definition?",
                "public double methoda();", "public final double methoda();", "static void methoda(double d1);", "protected void methoda(double d1);",
                "public double methoda();", ""
        );

        // Add all questions to List<QuestionsList>
        questionsLists.add(question1);
        questionsLists.add(question2);
        questionsLists.add(question3);
        questionsLists.add(question4);
        questionsLists.add(question5);
        questionsLists.add(question6);

        return questionsLists;
    }
}
