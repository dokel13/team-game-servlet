package com.game.domain;

public class Statistics {

    private final String judge;
    private final String team;
    private final int rightAnswers;
    private final int playersAmount;
    private final String winner;

    protected Statistics(StatisticsBuilder statisticsBuilder) {
        this.judge = statisticsBuilder.judge;
        this.team = statisticsBuilder.team;
        this.rightAnswers = statisticsBuilder.rightAnswers;
        this.playersAmount = statisticsBuilder.playersAmount;
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

    public int getRightAnswers() {
        return rightAnswers;
    }

    public int getPlayersAmount() {
        return playersAmount;
    }

    public String getWinner() {
        return winner;
    }

    @Override
    public String toString() {
        return "Statistics{" +
                "judge='" + judge + '\'' +
                ", team='" + team + '\'' +
                ", rightAnswers=" + rightAnswers +
                ", playersAmount=" + playersAmount +
                ", winner=" + winner +
                '}';
    }

    public static class StatisticsBuilder {
        private String judge;
        private String team;
        private int rightAnswers;
        private int playersAmount;
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

        public StatisticsBuilder withRightAnswers(int rightAnswers) {
            this.rightAnswers = rightAnswers;
            return this;
        }

        public StatisticsBuilder withPlayersAmount(int playersAmount) {
            this.playersAmount = playersAmount;
            return this;
        }

        public StatisticsBuilder withWinner(String winner) {
            this.winner = winner;
            return this;
        }
    }
}
