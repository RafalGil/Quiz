package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.List;


public class Main extends JFrame implements ActionListener {

    //program ma zawierać pytanie
    //i  ma zawierać 2 przyciski tak i nie
    private JButton buttonYes;
    private JButton buttonNo;
    private JLabel labelQuestion;

    //znienna która jest typu interfejsowego
    //co oznacza że musi to tej zmiennej przekazać klasę
    //która bedzie implementowała interface QuestionGenerator
    //mówimy ogólnie o typie, ale nie mówimy konktetnie o klasie
    //podajemy kategorie do której będzie należała klasa
    private QuestionGenerator questionGenerator;
    private int currentQuestion =0;
    private int numberOfPoints = 0;


    //lista pytań
    private List<Question> questionList = new ArrayList<>();


    public void setQuestionGenerator(QuestionGenerator questionGenerator) {
        //ustalamy zmienną z 21 linijki na ta która podana jest w argumencie metody
        this.questionGenerator = questionGenerator;

        //tutaj zakładamy, że już mamy obiekt jakiejś klasy
        //na etapie pisania kodu nie wiemy kompletnie jaka to bedzie klasa
        //tylko wiemy ze musi implementować interface Questiongzenerator
        //wypełniany listę pytaniami które są generowane za pomocą metody generatorQuestion
        questionList = questionGenerator.generatorQuestion();
    }

    public Main (){
        super ("Milionerzy"); //ustawia tytuł okna
        createDefaultComponents();
        //this wskazuje na obiekt w którym jest
        //na rzecz którego w tym momencie wołany jest konstruktor
        //Listener ma być obiekt Main, czyli okno

        labelQuestion = new JLabel(questionList.get(0).getContent(),0);
        add(labelQuestion);
        add(buttonYes);
        add(buttonNo);

        setLayout(new GridLayout(3,1));

     }

    private void createDefaultComponents() {
        setSize(500,500); // ustawia wielkość okna
        setDefaultCloseOperation(1); // sprawia, że działa przycisk exit
        setVisible(true);   // sprawia że okno jest widoczne
        setQuestionGenerator(new SimpleQuestionGenerator());
        //


        buttonYes = new JButton("Tak");
        buttonNo = new JButton("nie");
        buttonYes.addActionListener(this);
        buttonNo.addActionListener(this);
    }

    public static void main(String[] args) {
	// write your code here


        //odpalenie wątku
        SwingUtilities.invokeLater(new Runnable() {
            @Override

            public void run() {
                //stworzenie nowej zmiennej typu Main = nowego okna
                Main main = new Main ();
            }
        });

    }

    //ta metoda jest wywołana gdy klikniemy na przycisk albo Tak albo Nie
    @Override

    public void actionPerformed(ActionEvent e) {

        // kolejne pytanie musi się miesić w liście

        if (currentQuestion < questionList.size()) {

            JButton clikedButton = (JButton) e.getSource();

            Question currentQuestion = questionList.get(this.currentQuestion);

            if (clikedButton == buttonYes

                    && currentQuestion.isCorrect()

                    ) {

                numberOfPoints++;

            }

            if (clikedButton == buttonNo

                    && !currentQuestion.isCorrect()

                    ) {

                numberOfPoints++;

            }

        }

        if (currentQuestion + 1 < questionList.size()) {

            labelQuestion.setText(questionList.get(++currentQuestion).getContent());

        } else {

            JOptionPane.showMessageDialog(this, "Koniec quizu zdobyłeś" + numberOfPoints + " punkty");

            buttonNo.setEnabled(false);

            buttonYes.setEnabled(false);

        }

    }
}
