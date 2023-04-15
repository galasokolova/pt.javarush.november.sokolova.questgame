package pt.quest.repository;

import pt.quest.context.Tendency;
import pt.quest.entity.Answer;
import pt.quest.entity.Question;

import java.util.Map;
import java.util.Optional;

public interface AnswerRepository{
    Map<Tendency, Answer> findAnswerOptionsByQuestion(Question question);

    Optional<Answer> findAnswerByTendency(Tendency key, Question question);
}
