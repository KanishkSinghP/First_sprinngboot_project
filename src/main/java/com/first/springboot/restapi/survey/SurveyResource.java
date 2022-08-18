package com.first.springboot.restapi.survey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@RestController
public class SurveyResource {
    @Autowired
    private SurveyService surveyService;




    @RequestMapping("/surveys")
    public List<Survey> retrieveAllSurveys(){

        return surveyService.retrieveAllSurveys();

    }
    @RequestMapping("/surveys/{Id}")
    public Survey retrieveSurveyById(@PathVariable String Id){
        Survey survey= surveyService.retrieveSurveyById(Id);
        if(survey==null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        return survey;

    }
    @RequestMapping("/surveys/{Id}/questions")
    public List<Question> retrieveSurveyQuestionsById(@PathVariable String Id){
        List<Question> questions= surveyService.retrieveSurveyQuestionsById(Id);
        if(questions==null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        return questions;

//        Survey survey= surveyService.retrieveSurveyById(Id);
//        if(survey==null)
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//
//        return survey.getQuestions();
    }

    @RequestMapping("/surveys/{surveyId}/questions/{queryId}")
    public Question retrieveSurveyQuestionByIds(@PathVariable String surveyId,@PathVariable String queryId){
        Question question= surveyService.retretrieveSurveyQuestionByIds(surveyId,queryId);
        if(question==null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        return question;

    }


    @RequestMapping(value="/surveys/{Id}/questions",method= RequestMethod.POST)
    public ResponseEntity<Object> addNewSurveyQuestionsById(@PathVariable String Id
             , @RequestBody Question question){

        surveyService.addNewSurveyQuestionsById(Id,question);

        return ResponseEntity.created(null).build();
    }


    @RequestMapping(value ="/surveys/{surveyId}/questions/{queryId}",method=RequestMethod.DELETE)
    public ResponseEntity<Object> deleteSurveyQuestionByIds(@PathVariable String surveyId,@PathVariable String queryId){
       String x= surveyService.deleteSurveyQuestionByIds(surveyId,queryId);


        return ResponseEntity.noContent().build();

    }

    @RequestMapping(value ="/surveys/{surveyId}/questions/{queryId}",method=RequestMethod.PUT)
    public ResponseEntity<Object> updateSurveyQuestionById(@PathVariable String surveyId,
                                                            @PathVariable String queryId,@RequestBody Question question){

        String x=surveyService.updateSurveyQuestionById(surveyId,queryId,question);
        if(x==null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return ResponseEntity.noContent().build();

    }

}
