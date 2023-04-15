package pt.quest;

import pt.quest.context.AnswerCreator;
import pt.quest.context.QuestionCreator;
import pt.quest.entity.Answer;
import pt.quest.entity.Question;
import pt.quest.repository.InMemoryAnswerRepository;
import pt.quest.repository.InMemoryQuestionRepository;
import pt.quest.service.GameService;

import java.util.List;
import java.util.Optional;

public class Main {
   


    public static void main(String[] args) {
        GameService gameService = new GameService(new InMemoryQuestionRepository(), new InMemoryAnswerRepository());
        System.out.println(new AnswerCreator().getAcceptCall().getText());
        System.out.println(gameService.getInitialQuestion());

    }
    
}