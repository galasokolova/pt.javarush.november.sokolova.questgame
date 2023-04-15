package pt.quest.context;

import pt.quest.controller.GameController;
import pt.quest.dispatcher.MethodMap;
import pt.quest.dispatcher.RegisterForControllers;
import pt.quest.repository.AnswerRepository;
import pt.quest.repository.InMemoryAnswerRepository;
import pt.quest.repository.InMemoryQuestionRepository;
import pt.quest.repository.QuestionRepository;
import pt.quest.service.GameService;

import java.util.Map;

public class GameContext {
    private GameContext() {
    }
    private static final AnswerRepository ANSWER_REPOSITORY = new InMemoryAnswerRepository();
    private static final QuestionRepository QUESTION_REPOSITORY = new InMemoryQuestionRepository();
    private static final GameService GAME_SERVICE = new GameService(QUESTION_REPOSITORY, ANSWER_REPOSITORY);
    private static final GameController GAME_CONTROLLER = new GameController(GAME_SERVICE);
    public static final Map<String, MethodMap> URL_TO_METHODMAP = new RegisterForControllers().register(GAME_CONTROLLER);

}
