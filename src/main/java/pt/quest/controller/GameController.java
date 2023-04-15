package pt.quest.controller;

import pt.quest.context.Tendency;
import pt.quest.dispatcher.MethodType;
import pt.quest.dispatcher.RequestMapping;
import pt.quest.entity.Answer;
import pt.quest.entity.Question;
import pt.quest.service.GameService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;


public class GameController {
    String restartButton = "/index.jsp";
    Question initialQuestion;
    Question acceptCallResult;
    Question goOrNotGoToCaptainResult;
    Question tellTruthOrLieResult;

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }
    @RequestMapping(url = "/initial", method = MethodType.GET)
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession currentSession = request.getSession();

        currentSession.setAttribute("restart", restartButton);

        initialQuestion = gameService.getInitialQuestion().orElse(new Question("", "", null, null, null));
        currentSession.setAttribute("initialQuestion", initialQuestion);

        Map<Tendency, Answer> acceptCallAnswers = gameService.getNextAnswer(initialQuestion);

        for (Answer acceptCallAnswer : acceptCallAnswers.values()){
            acceptCallResult = gameService.getNextQuestion(acceptCallAnswer.getQuestionId()).orElse(new Question("", "", null, null, null));

            if (!acceptCallResult.isLast() && Objects.equals(acceptCallResult.getId(), acceptCallAnswer.getQuestionId())){
                acceptCallAnswer = gameService.findAnswerByTendency(Tendency.WIN, initialQuestion).orElse(new Answer("", null));
                currentSession.setAttribute("acceptCallAnswer", acceptCallAnswer);
                currentSession.setAttribute("acceptCallResult", acceptCallResult);                       // link to accept_call.jsp


                Map<Tendency, Answer> goToCaptainAnswers = gameService.getNextAnswer(acceptCallResult);
                for (Answer goToCaptainAnswer : goToCaptainAnswers.values()){

                    goOrNotGoToCaptainResult = gameService.getNextQuestion(goToCaptainAnswer.getQuestionId()).orElse(new Question("", "", null, null, null));
                    if (!goOrNotGoToCaptainResult.isLast() && Objects.equals(goOrNotGoToCaptainResult.getId(), goToCaptainAnswer.getQuestionId())){
                        goToCaptainAnswer = gameService.findAnswerByTendency(Tendency.WIN, acceptCallResult).orElse(new Answer("", null));
                        currentSession.setAttribute("goToCaptainAnswer", goToCaptainAnswer);
                        currentSession.setAttribute("goToCaptainResult", goOrNotGoToCaptainResult);          // link to go_to_captain.jsp


                        Map<Tendency, Answer> tellTruthOrLieAnswers = gameService.getNextAnswer(goOrNotGoToCaptainResult);
                        for (Answer truthOrLieAnswer : tellTruthOrLieAnswers.values()){
                            tellTruthOrLieResult = gameService.getNextQuestion(truthOrLieAnswer.getQuestionId()).orElse(new Question("", "", null, null, null));
                            if (!tellTruthOrLieResult.isLast() && Objects.equals(tellTruthOrLieResult.getId(), truthOrLieAnswer.getQuestionId())){
                                truthOrLieAnswer = gameService.findAnswerByTendency(Tendency.WIN, goOrNotGoToCaptainResult).orElse(new Answer("", null));
                                currentSession.setAttribute("tellTruthAnswer", truthOrLieAnswer);
                                currentSession.setAttribute("tellTruthResult", tellTruthOrLieResult);                 // link to tell_truth.jsp
                            }else {
                                truthOrLieAnswer = gameService.findAnswerByTendency(Tendency.LOSE, goOrNotGoToCaptainResult).orElse(new Answer("", null));
                                currentSession.setAttribute("tellLiesAnswer", truthOrLieAnswer);
                                currentSession.setAttribute("tellLiesResult", tellTruthOrLieResult);                // link to tell_lies.jsp
                            }
                        }
                    }else {
                        goToCaptainAnswer = gameService.findAnswerByTendency(Tendency.LOSE, acceptCallResult).orElse(new Answer("", null));
                        currentSession.setAttribute("notGoToCaptainAnswer", goToCaptainAnswer);
                        currentSession.setAttribute("notGoToCaptainResult", goOrNotGoToCaptainResult);      // link to not_go_to_captain_result.jsp
                    }
                }
            }else {
                acceptCallAnswer = gameService.findAnswerByTendency(Tendency.LOSE, initialQuestion).orElse(new Answer("", null));
                currentSession.setAttribute("refuseCallAnswer", acceptCallAnswer);
                currentSession.setAttribute("refuseResult", acceptCallResult);                        //  link to refuse_call.jsp  -  restart
            }
        }

        currentSession = request.getSession(true);
        String sessionId = currentSession.getId();

        currentSession = request.getSession(false);
        if (currentSession != null) {
            Integer counter = (Integer) currentSession.getAttribute("counter");
            if (counter == null) {
                counter = 1;
            } else {
                counter++;
            }
            currentSession.setAttribute("counter", counter);
        }



        request.getRequestDispatcher("/initial.jsp").forward(request, response);
    }

}


