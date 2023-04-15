package pt.quest.entity;

import java.util.Objects;

public class Answer {
    private final String text;
    private final Integer questionId;

    public Answer(String text, Integer questionId) {
        this.text = text;
        this.questionId = questionId;
    }

    public String getText() {
        return text;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Answer answer = (Answer) o;
        return Objects.equals(text, answer.text) &&
                Objects.equals(questionId, answer.questionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, questionId);
    }

    @Override
    public String toString() {
        return "Answer{" +
                "text='" + text + '\'' +
                ", questionId=" + questionId +
                '}';
    }
}
