package pt.quest.entity;

import pt.quest.context.Tendency;

import java.util.Map;
import java.util.Objects;

public class Question {
    private final String text;
    private final String url;
    private final Boolean isLast;
    private final Map<Tendency, Answer> answers;
    private final Integer id;

    public Question(String text, String url, Boolean isLast, Map<Tendency, Answer> answers, Integer id) {
        this.text = text;
        this.url = url;
        this.isLast = isLast;
        this.answers = answers;
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public String getUrl() {
        return url;
    }

    public Boolean isLast() {
        return isLast;
    }

    public Map<Tendency, Answer> getAnswers() {
        return answers;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return Objects.equals(text, question.text) &&
                Objects.equals(url, question.url) &&
                Objects.equals(isLast, question.isLast) &&
                Objects.equals(answers, question.answers) &&
                Objects.equals(id, question.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, url, isLast, answers, id);
    }

    @Override
    public String toString() {
        return "Question{" +
                "text='" + text + '\'' +
                ", url='" + url + '\'' +
                ", isLast=" + isLast +
                ", answers=" + answers +
                ", id=" + id +
                '}';
    }
}
