# First_sprinngboot_project

The Rest Api basically is for the survey which will contain ->
 id,title, description,questions
 So I started by creating a bean for survey and for question which contains ->  String id,description,options,correctAnswer
 
 Now the api contains basically 4 kinds of operations->
 Get-> 
 /surveys
 gives all the surveys
 
 /surveys/{Id}
 gives a particular survey
 
 
 /surveys/{Id}/questions
 gives all questions corresponding to a particular survey
 
 
 /surveys/{surveyId}/questions/{queryId}
  gives particular question of a particular survey
 
 
 POST-
/surveys/{Id}/questions
to post questions corresponding to a particular survey

Delete->
surveys/{surveyId}/questions/{queryId}
to delete question corresponding to a particular survey id

PUT-
/surveys/{surveyId}/questions/{queryId}
to change questions corresponding to a particular survey
