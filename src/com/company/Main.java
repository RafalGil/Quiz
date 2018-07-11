package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        List<Question> questionList = new ArrayList<>();


        questionList.add(new Question( "czy Polska leży w Europie",true));
        questionList.add(new Question( "czy 2+2 = 5", false));
        questionList.add(new Question( "czy 2 * 10 = 10000", false));
        questionList.add(new Question( "czy Chopin urodził się w Warszawie?",false));

        int numberOfPoints = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("milionerze, odpowiadaj tak bądż nie na pytania");
         for (Question question : questionList){
             System.out.println(question.getContent());
             String answer = scanner.next();

             if ( (answer.equals("tak" ) && question.isCorrect())
                     || (answer.equals("nie" ) && !question.isCorrect())


                     ){
                 numberOfPoints++;
             }
         }

        System.out.println("zdobyłeś "+ numberOfPoints+ " punktów");

    }
}
