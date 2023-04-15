import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.quest.context.QuestionCreator;
import pt.quest.entity.Question;
import pt.quest.repository.AnswerRepository;
import pt.quest.repository.InMemoryAnswerRepository;
import pt.quest.repository.InMemoryQuestionRepository;
import pt.quest.repository.QuestionRepository;
import pt.quest.service.GameService;

import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GameServiceTest {
    QuestionRepository questionRepository;
    AnswerRepository answerRepository;
    QuestionCreator questionCreator = new QuestionCreator();

    GameService gameService = new GameService(new InMemoryQuestionRepository(), new InMemoryAnswerRepository());
    @BeforeEach
    public void setUp() {
        questionRepository = mock(QuestionRepository.class);
        answerRepository = mock(AnswerRepository.class);
    }

    @Test
    void shouldReturnEmptyOptionalWhenInitialQuestionIsEmpty() {

        when(questionRepository.getInitialQuestion()).thenReturn(null);
        GameService gameService = new GameService(questionRepository, answerRepository);

        Optional<Question> result = gameService.getInitialQuestion();

        Assertions.assertTrue(result.isEmpty());
    }

    @Test
    public void testGetNextQuestion() {

        int[] ids = {1, 2, 3, 4, 11, 22, 33};
        String[] texts = {questionCreator.getInitialQuestion().getText(), questionCreator.getAcceptCallResult().getText(), questionCreator.getGoToCaptainResult().getText(),
                questionCreator.getTellTruthResult().getText(), questionCreator.getNotAcceptCallResult().getText(), questionCreator.getNotGoToCaptainResult().getText(),
                questionCreator.getTellLiesResult().getText()};

        for (int i = 0; i < ids.length; i++) {
            Optional<Question> question = gameService.getNextQuestion(ids[i]);
            Assertions.assertTrue(question.isPresent());
            Assertions.assertEquals(texts[i], question.get().getText());
        }

        Optional<Question> question99 = gameService.getNextQuestion(99);
        Assertions.assertFalse(question99.isPresent());
    }


}


