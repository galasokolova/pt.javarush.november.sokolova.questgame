package pt.quest.repository;

import pt.quest.entity.Question;

import java.util.Optional;

public interface QuestionRepository {

    Question getInitialQuestion();

    Optional<Question> getQuestionByAnswerId(Integer answerId);

}
