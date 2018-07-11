package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main extends JFrame {

    //program ma zawierać pytanie
    //i  ma zawierać 2 przysiski tak i nie
    private JButton buttonYes;
    private JButton buttonNo;
    private JLabel labelQuestion;



    public Main (){
        super ("Milionerzy"); //ustawia tytuł okna
        setSize(500,500); // ustawia wielkość okna
        setDefaultCloseOperation(1); // sprawia, że działa przycisk exit
        setVisible(true);   // sprawia że okno jest widoczne
        buttonYes = new JButton("Tak");
        buttonNo = new JButton("Nie");
        labelQuestion = new JLabel("Czy Polska leży w Europie",0);
        add(labelQuestion);
        add(buttonYes);
        add(buttonNo);

        setLayout(new GridLayout(3,1));

     }
    public static void main(String[] args) {
	// write your code here

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Main main = new Main ();
            }
        });

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
