package com.company;

import java.util.ArrayList;
import java.util.List;
/*
   klasa która implementuje interface
   dzięki temu może być traktowana jako typ SimpleQuestionGenerator
   ale też jako typ QuestionGenerator
 */
public class SimpleQuestionGenerator implements QuestionGenerator {
     //implementacja tej metody
    @Override
    public List<Question> generatorQuestion(){
        List<Question> questionList = new ArrayList<>();

        questionList.add(new Question( "czy Polska leży w Europie",true));
        questionList.add(new Question( "czy 2+2 = 5", false));
        questionList.add(new Question( "czy 2 * 10 = 10000", false));
        questionList.add(new Question( "czy Chopin urodził się w Warszawie?",false));
        return questionList;


    }
}
