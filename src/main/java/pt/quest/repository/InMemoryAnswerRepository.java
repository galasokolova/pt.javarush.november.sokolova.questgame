package pt.quest.repository;

import pt.quest.context.Tendency;
import pt.quest.entity.Answer;
import pt.quest.entity.Question;

import java.util.Map;
import java.util.Optional;

import static java.util.Objects.isNull;
import static pt.quest.service.GameService.log;

public class InMemoryAnswerRepository implements AnswerRepository {

    @Override
    public Map<Tendency, Answer> findAnswerOptionsByQuestion(Question question) {
        if (isNull(question)) {
            log.error("The question is null");
        }
        return question.getAnswers();
    }
    @Override
    public Optional<Answer> findAnswerByTendency(Tendency key, Question question){
        return Optional.ofNullable(findAnswerOptionsByQuestion(question).get(key));
    }
}
