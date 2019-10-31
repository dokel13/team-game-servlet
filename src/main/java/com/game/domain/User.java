package com.game.domain;

public class User {

    private Long id;
    private String login;
    private String password;
    private Role role;

    protected User(UserBuilder userBuilder) {
        this.id = userBuilder.id;
        this.login = userBuilder.login;
        this.password = userBuilder.password;
        this.role = userBuilder.role;
    }

    public static UserBuilder builder() {
        return new UserBuilder();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
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
        private Long id;
        private String login;
        private String password;
        private Role role;

        private UserBuilder() {
        }

        public User build() {
            return new User(this);
        }

        public UserBuilder withId(Long id) {
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
