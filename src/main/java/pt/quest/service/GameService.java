package pt.quest.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pt.quest.context.Tendency;
import pt.quest.entity.Answer;
import pt.quest.entity.Question;
import pt.quest.repository.AnswerRepository;
import pt.quest.repository.QuestionRepository;

import java.util.Map;
import java.util.Optional;


import static java.util.Objects.isNull;

public class GameService {
    public static final Logger log = LogManager.getLogger(GameService.class);
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;

    public GameService(QuestionRepository questionRepository, AnswerRepository answerRepository) {
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
    }
    public Optional<Question> getInitialQuestion() {

        return Optional.ofNullable(questionRepository.getInitialQuestion());
    }

    public Map<Tendency, Answer> getNextAnswer(Question question){
        if (isNull(question)) {
            log.error("The question is null");
        }
        return answerRepository.findAnswerOptionsByQuestion(question);
    }

    public Optional<Answer> findAnswerByTendency(Tendency key, Question question){

        return answerRepository.findAnswerByTendency(key, question);
    }

    public Optional<Question> getNextQuestion(Integer id){

        return questionRepository.getQuestionByAnswerId(id);
    }

}

