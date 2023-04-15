package pt.quest.context;

import pt.quest.entity.Answer;
import pt.quest.entity.Question;

import java.util.*;

import static pt.quest.context.Tendency.LOSE;
import static pt.quest.context.Tendency.WIN;

public class QuestionCreator {

    private static final String INITIAL_QUESTION = "You've lost your memory. Will you accept a UFO's call?";
    private static final String ACCEPT_CALL_RESULT = "You've accepted the call. Will you go up to the captain's bridge?";
    private static final String NOT_ACCEPT_CALL_RESULT = "You've refused the call. You LOSE!!! Do you wanna restart the game?";
    private static final String GO_TO_CAPTAIN_RESULT = "You've come to the Captain's bridge. Who are you?";
    private static final String NOT_GO_TO_CAPTAIN_RESULT = "You've refused to talk to the Captain. You LOSE!!! Do you wanna restart the game?.";
    private static final String TELL_TRUTH_RESULT = "You've been brought back home. You WIN!!! Do you wanna restart the game?";
    private static final String TELL_LIES_RESULT = "You've told lies. You LOSE!!! Do you wanna restart the game?";


    private final Question initialQuestion = new Question(INITIAL_QUESTION, "/initial.jsp", false, getAcceptOrNotAcceptCallList(), 1);
    private final Question notAcceptCallResult = new Question(NOT_ACCEPT_CALL_RESULT, "/refuse_call.jsp",true, null, 11);
    private final Question acceptCallResult = new Question(ACCEPT_CALL_RESULT, "/accept_call.jsp", false, getGoToCaptainOrNotList(), 2);
    private final Question goToCaptainResult = new Question(GO_TO_CAPTAIN_RESULT, "/go_to_captain.jsp", false, getTellTruthOrLieList(), 3);
    private final Question notGoToCaptainResult = new Question(NOT_GO_TO_CAPTAIN_RESULT, "/not_go_to_captain.jsp", true, null, 22);
    private final Question tellTruthResult = new Question(TELL_TRUTH_RESULT, "/tell_truth.jsp", false, null, 4);
    private final Question tellLiesResult = new Question(TELL_LIES_RESULT, "/tell_lies.jsp", true, null, 33);


    public Map<Integer, Question> getQuestions(){
        Map<Integer, Question> questionList = new HashMap<>();
        questionList.put(1, initialQuestion);
        questionList.put(2, acceptCallResult);
        questionList.put(3, goToCaptainResult);
        questionList.put(4, tellTruthResult);
        questionList.put(11, notAcceptCallResult);
        questionList.put(22, notGoToCaptainResult);
        questionList.put(33, tellLiesResult);
        return questionList;
    }

    private Map<Tendency, Answer> getAcceptOrNotAcceptCallList(){
        Map<Tendency, Answer> acceptCallOrNotList = new HashMap<>();
        acceptCallOrNotList.put(WIN, new AnswerCreator().getAcceptCall());
        acceptCallOrNotList.put(LOSE, new AnswerCreator().getNotAcceptCall());
        return acceptCallOrNotList;
    }

    private Map<Tendency, Answer> getGoToCaptainOrNotList(){
        Map<Tendency, Answer> goToCaptainOrNotList = new HashMap<>();
        goToCaptainOrNotList.put(WIN, new AnswerCreator().getGoToCaptain());
        goToCaptainOrNotList.put(LOSE, new AnswerCreator().getNotGoToCaptain());
        return goToCaptainOrNotList;
    }
    private Map<Tendency, Answer> getTellTruthOrLieList(){
        Map<Tendency, Answer> tellTruthOrLieList = new HashMap<>();
        tellTruthOrLieList.put(WIN, new AnswerCreator().getTellTruth());
        tellTruthOrLieList.put(LOSE, new AnswerCreator().getTellLies());
        return tellTruthOrLieList;
    }
    public QuestionCreator() {
    }

    public Question getInitialQuestion() {
        return initialQuestion;
    }

    public Question getNotAcceptCallResult() {
        return notAcceptCallResult;
    }

    public Question getAcceptCallResult() {
        return acceptCallResult;
    }

    public Question getGoToCaptainResult() {
        return goToCaptainResult;
    }

    public Question getNotGoToCaptainResult() {
        return notGoToCaptainResult;
    }

    public Question getTellTruthResult() {
        return tellTruthResult;
    }

    public Question getTellLiesResult() {
        return tellLiesResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionCreator that = (QuestionCreator) o;
        return Objects.equals(initialQuestion, that.initialQuestion) &&
                Objects.equals(notAcceptCallResult, that.notAcceptCallResult) &&
                Objects.equals(acceptCallResult, that.acceptCallResult) &&
                Objects.equals(goToCaptainResult, that.goToCaptainResult) &&
                Objects.equals(notGoToCaptainResult, that.notGoToCaptainResult) &&
                Objects.equals(tellTruthResult, that.tellTruthResult) &&
                Objects.equals(tellLiesResult, that.tellLiesResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(initialQuestion,
                notAcceptCallResult,
                acceptCallResult,
                goToCaptainResult,
                notGoToCaptainResult,
                tellTruthResult,
                tellLiesResult);
    }
}
