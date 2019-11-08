package com.game.domain;

public class Game {
    private Integer id;
    private final String judge;
    private Boolean activity;
    private GameConfig gameConfig;

    protected Game(GameBuilder gameBuilder) {
        this.id = gameBuilder.id;
        this.judge = gameBuilder.judge;
        this.activity = gameBuilder.activity;
        this.gameConfig = gameBuilder.gameConfig;
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

    public GameConfig getGameConfig() {
        return gameConfig;
    }

    public Game setId(Integer id) {
        this.id = id;
        return this;
    }

    public Game setActivity(Boolean activity) {
        this.activity = activity;
        return this;
    }

    public Game setGameConfig(GameConfig gameConfig) {
        this.gameConfig = gameConfig;
        return this;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", judge=" + judge +
                ", activity=" + activity +
                ", gameConfig=" + gameConfig +
                '}';
    }

    public static class GameBuilder {
        private Integer id;
        private String judge;
        private Boolean activity;
        private GameConfig gameConfig;

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

        public GameBuilder withGameConfig(GameConfig gameConfig) {
            this.gameConfig = gameConfig;
            return this;
        }
    }
}
