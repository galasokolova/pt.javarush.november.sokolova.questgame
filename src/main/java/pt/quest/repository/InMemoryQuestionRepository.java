package pt.quest.repository;

import pt.quest.context.QuestionCreator;
import pt.quest.entity.Question;

import java.util.Objects;
import java.util.Optional;

public class InMemoryQuestionRepository implements QuestionRepository {
    QuestionCreator questionCreator = new QuestionCreator();

    public InMemoryQuestionRepository() {
    }

    @Override
    public Question getInitialQuestion() {
        return questionCreator.getInitialQuestion();
    }

    public Question findQuestionById(int id) {
        return questionCreator.getQuestions().get(id);
    }

    @Override
    public Optional<Question> getQuestionByAnswerId(Integer answerId) {
        Question question = findQuestionById(answerId);
        if (question != null && Objects.equals(answerId, question.getId())) {
            return Optional.of(question);
        } else {
            return Optional.empty();
        }
    }

}


