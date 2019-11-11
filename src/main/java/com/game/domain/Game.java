package com.game.domain;

import java.util.Objects;

public class Game {
    private Integer id;
    private final String judge;
    private Boolean activity;

    protected Game(GameBuilder gameBuilder) {
        this.id = gameBuilder.id;
        this.judge = gameBuilder.judge;
        this.activity = gameBuilder.activity;
    }

    public static GameBuilder builder() {
        return new GameBuilder();
    }

    public Integer getId() {
        return id;
    }

    public String getJudge() {
        return judge;
    }

    public Boolean getActivity() {
        return activity;
    }

    public Game setId(Integer id) {
        this.id = id;
        return this;
    }

    public Game setActivity(Boolean activity) {
        this.activity = activity;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Game)) return false;
        Game game = (Game) o;
        return Objects.equals(id, game.id) &&
                Objects.equals(judge, game.judge) &&
                Objects.equals(activity, game.activity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, judge, activity);
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", judge=" + judge +
                ", activity=" + activity +
                '}';
    }

    public static class GameBuilder {
        private Integer id;
        private String judge;
        private Boolean activity;

        public GameBuilder() {
        }

        public Game build() {
            return new Game(this);
        }

        public GameBuilder withId(Integer id) {
            this.id = id;
            return this;
        }

        public GameBuilder withJudge(String judge) {
            this.judge = judge;
            return this;
        }

        public GameBuilder withActivity(Boolean activity) {
            this.activity = activity;
            return this;
        }
    }
}
