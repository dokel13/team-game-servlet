package com.game.domain;

public class Question {

    private Integer id;
    private String body;
    private String answer;
    private String help;
    private String second_answer;
    private String third_answer;
    private String fourth_answer;
    private String author;

    public Question(QuestionBuilder questionBuilder) {
        this.id = questionBuilder.id;
        this.body = questionBuilder.body;
        this.answer = questionBuilder.answer;
        this.help = questionBuilder.help;
        this.second_answer = questionBuilder.second_answer;
        this.third_answer = questionBuilder.third_answer;
        this.fourth_answer = questionBuilder.fourth_answer;
        this.author = questionBuilder.author;
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

    public String getFourth_answer() {
        return fourth_answer;
    }

    public String getAuthor() {
        return author;
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
                ", fourth_answer='" + fourth_answer + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    public static class QuestionBuilder {
        private Integer id;
        private String body;
        private String answer;
        private String help;
        private String second_answer;
        private String third_answer;
        private String fourth_answer;
        private String author;

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

        public QuestionBuilder withFourth_answer(String fourth_answer) {
            this.fourth_answer = fourth_answer;
            return this;
        }

        public QuestionBuilder withAuthor(String author) {
            this.author = author;
            return this;
        }
    }
}
