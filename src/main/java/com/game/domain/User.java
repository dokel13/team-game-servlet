package com.game.domain;

public class User {

    private Integer id;
    private final String login;
    private String password;
    private final Role role;

    protected User(UserBuilder userBuilder) {
        this.id = userBuilder.id;
        this.login = userBuilder.login;
        this.password = userBuilder.password;
        this.role = userBuilder.role;
    }

    public static UserBuilder builder() {
        return new UserBuilder();
    }

    public Integer getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", role=" + role +
                '}';
    }

    public static class UserBuilder {
        private Integer id;
        private String login;
        private String password;
        private Role role;

        private UserBuilder() {
        }

        public User build() {
            return new User(this);
        }

        public UserBuilder withId(Integer id) {
            this.id = id;
            return this;
        }

        public UserBuilder withLogin(String login) {
            this.login = login;
            return this;
        }

        public UserBuilder withPassword(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder withRole(Role role) {
            this.role = role;
            return this;
        }
    }
}
