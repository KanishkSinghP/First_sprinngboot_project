package com.first.springboot.restapi.survey;

import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Service
public class SurveyService {

    private static List<Survey> surveys=new ArrayList<>();




  static{
      Question question1 =new Question("Question1","Who is known as Goat of football?", Arrays.asList("Ronaldo" ,"Messi","Neymar","Mbappe"),"Ronaldo");
      Question question2 =new Question("Question2","Who is known as Goat of cricket?", Arrays.asList("sachin" ,"Messi","Neymar","Mbappe"),"sachin");

      List<Question> questions = new ArrayList<>(Arrays.asList(question1,question2));
      Survey survey=new Survey("Survey1", "My facourite Survey","Do you know the goat of football",questions);
      surveys.add(survey);
        }


    public List<Survey> retrieveAllSurveys() {
      return surveys;
    }

    public Survey retrieveSurveyById(String id) {
        Predicate<? super Survey> predicate=
                survey->survey.getId().equals(id);
        Optional<Survey> optionalSurvey= surveys.stream().filter(predicate).findFirst();
        if(optionalSurvey.isEmpty())
            return null;
        return optionalSurvey.get();

    }

    public List<Question> retrieveSurveyQuestionsById(String id) {
        Survey survey =retrieveSurveyById(id);
        if(survey==null)
            return null;

        return survey.getQuestions();
    }

    public Question retretrieveSurveyQuestionByIds(String surveyId, String queryId) {
        Survey survey =retrieveSurveyById(surveyId);
        if(survey==null)
            return null;
        List<Question> questions =survey.getQuestions();
        Predicate<? super Question> predicate=
                question->question.getId().equals(queryId);
        Optional<Question> optionalSurvey = questions.stream().filter(predicate).findFirst();
        if(optionalSurvey.isEmpty())
            return null;
        return optionalSurvey.get();

    }

    public void addNewSurveyQuestionsById(String id, Question question) {
        List<Question> questions= retrieveSurveyQuestionsById(id);
        questions.add(question);

    }
}
