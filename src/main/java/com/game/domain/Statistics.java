package com.game.domain;

public class Statistics {

    private final String judge;
    private final String team;
    private final String captain;
    private final int rightAnswers;
    private final int wrongAnswers;
    private final String winner;

    protected Statistics(StatisticsBuilder statisticsBuilder) {
        this.judge = statisticsBuilder.judge;
        this.team = statisticsBuilder.team;
        this.captain = statisticsBuilder.captain;
        this.rightAnswers = statisticsBuilder.rightAnswers;
        this.wrongAnswers = statisticsBuilder.wrongAnswers;
        this.winner = statisticsBuilder.winner;
    }

    public static StatisticsBuilder builder() {
        return new StatisticsBuilder();
    }

    public String getJudge() {
        return judge;
    }

    public String getTeam() {
        return team;
    }

    public String getCaptain() {
        return captain;
    }

    public int getRightAnswers() {
        return rightAnswers;
    }

    public int getWrongAnswers() {
        return wrongAnswers;
    }

    public String getWinner() {
        return winner;
    }

    @Override
    public String toString() {
        return "Statistics{" +
                "judge='" + judge + '\'' +
                ", team='" + team + '\'' +
                ", captain='" + captain + '\'' +
                ", rightAnswers=" + rightAnswers +
                ", wrongAnswers=" + wrongAnswers +
                ", winner=" + winner +
                '}';
    }

    public static class StatisticsBuilder {
        private String judge;
        private String team;
        private String captain;
        private int rightAnswers;
        private int wrongAnswers;
        private String winner;

        private StatisticsBuilder() {
        }

        public Statistics build() {
            return new Statistics(this);
        }

        public StatisticsBuilder withJudge(String judge) {
            this.judge = judge;
            return this;
        }

        public StatisticsBuilder withTeam(String team) {
            this.team = team;
            return this;
        }

        public StatisticsBuilder withCaptain(String captain) {
            this.captain = captain;
            return this;
        }

        public StatisticsBuilder withRightAnswers(int rightAnswers) {
            this.rightAnswers = rightAnswers;
            return this;
        }

        public StatisticsBuilder withWrongAnswers(int wrongAnswers) {
            this.wrongAnswers = wrongAnswers;
            return this;
        }

        public StatisticsBuilder withWinner(String winner) {
            this.winner = winner;
            return this;
        }
    }
}
