package com.game.domain;

import java.util.Objects;

public class Question {

    private Integer id;
    private String body;
    private String answer;
    private String help;
    private String second_answer;
    private String third_answer;

    public Question(QuestionBuilder questionBuilder) {
        this.id = questionBuilder.id;
        this.body = questionBuilder.body;
        this.answer = questionBuilder.answer;
        this.help = questionBuilder.help;
        this.second_answer = questionBuilder.second_answer;
        this.third_answer = questionBuilder.third_answer;
    }

    public static QuestionBuilder builder() {
        return new QuestionBuilder();
    }

    public Integer getId() {
        return id;
    }

    public String getBody() {
        return body;
    }

    public String getAnswer() {
        return answer;
    }

    public String getHelp() {
        return help;
    }

    public String getSecond_answer() {
        return second_answer;
    }

    public String getThird_answer() {
        return third_answer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Question)) return false;
        Question question = (Question) o;
        return Objects.equals(id, question.id) &&
                Objects.equals(body, question.body) &&
                Objects.equals(answer, question.answer) &&
                Objects.equals(help, question.help) &&
                Objects.equals(second_answer, question.second_answer) &&
                Objects.equals(third_answer, question.third_answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, body, answer, help, second_answer, third_answer);
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", body='" + body + '\'' +
                ", answer='" + answer + '\'' +
                ", help='" + help + '\'' +
                ", second_answer='" + second_answer + '\'' +
                ", third_answer='" + third_answer + '\'' +
                '}';
    }

    public static class QuestionBuilder {
        private Integer id;
        private String body;
        private String answer;
        private String help;
        private String second_answer;
        private String third_answer;

        private QuestionBuilder() {
        }

        public Question build() {
            return new Question(this);
        }

        public QuestionBuilder withId(Integer id) {
            this.id = id;
            return this;
        }

        public QuestionBuilder withBody(String body) {
            this.body = body;
            return this;
        }

        public QuestionBuilder withAnswer(String answer) {
            this.answer = answer;
            return this;
        }

        public QuestionBuilder withHelp(String help) {
            this.help = help;
            return this;
        }

        public QuestionBuilder withSecond_answer(String second_answer) {
            this.second_answer = second_answer;
            return this;
        }

        public QuestionBuilder withThird_answer(String third_answer) {
            this.third_answer = third_answer;
            return this;
        }
    }
}
