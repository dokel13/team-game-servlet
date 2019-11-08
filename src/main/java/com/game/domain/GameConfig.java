package com.game.domain;

public class GameConfig {

    private final Integer id;
    private final String teamName;
    private final Integer playersAmount;
    private final Integer questionsAmount;
    private final Integer helpAmount;
    private final Integer questionTime;

    protected GameConfig(ConfigBuilder configBuilder) {
        this.id = configBuilder.id;
        this.teamName = configBuilder.teamName;
        this.playersAmount = configBuilder.playersAmount;
        this.questionsAmount = configBuilder.questionsAmount;
        this.helpAmount = configBuilder.helpAmount;
        this.questionTime = configBuilder.questionTime;
    }

    public static ConfigBuilder builder() {
        return new ConfigBuilder();
    }

    public Integer getId() {
        return id;
    }

    public String getTeamName() {
        return teamName;
    }

    public Integer getPlayersAmount() {
        return playersAmount;
    }

    public Integer getQuestionsAmount() {
        return questionsAmount;
    }

    public Integer getHelpAmount() {
        return helpAmount;
    }

    public Integer getQuestionTime() {
        return questionTime;
    }

    @Override
    public String toString() {
        return "GameConfig{" +
                "id=" + id +
                ", teamName='" + teamName + '\'' +
                ", playersAmount=" + playersAmount +
                ", questionsAmount=" + questionsAmount +
                ", helpAmount=" + helpAmount +
                ", questionTime=" + questionTime +
                '}';
    }

    public static class ConfigBuilder {
        private Integer id;
        private String teamName;
        private Integer playersAmount;
        private Integer questionsAmount;
        private Integer helpAmount;
        private Integer questionTime;

        public ConfigBuilder() {
        }

        public GameConfig build() {
            return new GameConfig(this);
        }

        public ConfigBuilder withId(Integer id) {
            this.id = id;
            return this;
        }

        public ConfigBuilder withTeamName(String teamName) {
            this.teamName = teamName;
            return this;
        }

        public ConfigBuilder withPlayersAmount(Integer playersAmount) {
            this.playersAmount = playersAmount;
            return this;
        }

        public ConfigBuilder withQuestionsAmount(Integer questionsAmount) {
            this.questionsAmount = questionsAmount;
            return this;
        }

        public ConfigBuilder withHelpAmount(Integer helpAmount) {
            this.helpAmount = helpAmount;
            return this;
        }

        public ConfigBuilder withQuestionTime(Integer questionTime) {
            this.questionTime = questionTime;
            return this;
        }
    }
}
