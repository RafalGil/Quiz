package com.company;
//klasa question, która jest odpowiedzialna za przechowywanie pytania
//pytanie ma opcjie tylko tak lub nie
public class Question {
    //treść pytania
    private String content;
    //czy tak jest poprawne
    private boolean isCorrect;
    //konstruktor 2 parametrowy
    public Question(String content, boolean isCorrect) {
        this.content = content;
        this.isCorrect = isCorrect;
    }
    //getter otrzymuje dane
    public String getContent() {
        return content;
    }
    //setter zmienie treść pytania
    public void setContent(String content) {
        this.content = content;
    }
    //getter booleana
    public boolean isCorrect() {
        return isCorrect;
    }
    //setter dla booleana
    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    @Override //odpowiedż dla kompilatora
    public String toString() {
        //wyświetla czytelną treść pytania
        return "com.company.Question{" +
                "content='" + content + '\'' +
                ", isCorrect=" + isCorrect +
                '}';
    }



}
