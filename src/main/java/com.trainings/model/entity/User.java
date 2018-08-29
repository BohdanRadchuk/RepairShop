package com.trainings.model.entity;

public class User {
    private int id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private final Role role;

    private User(int id, String name, String surname, String email, String password, Role role) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    /**
     *
     */
    public static class UserBuilder {

        private int nestedId;
        private String nestedName;
        private String nestedSurname;
        private String nestedEmail;
        private String nestedPassword;
        private Role nestedRole;

        public UserBuilder() {
        }

        public UserBuilder userId(int userId) {
            this.nestedId = userId;
            return this;
        }


        public UserBuilder name(String name) {
            this.nestedName = name;
            return this;
        }

        public UserBuilder surname(String surname) {
            this.nestedSurname = surname;
            return this;
        }

        public UserBuilder email(String email) {
            this.nestedEmail = email;
            return this;
        }

        public UserBuilder password(String password) {
            this.nestedPassword = password;
            return this;
        }

        public UserBuilder role(Role role) {
            this.nestedRole = role;
            return this;
        }

        public User build() {
            return new User(nestedId, nestedName, nestedSurname, nestedEmail, nestedPassword, nestedRole);
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role.name() +
                '}';
    }
}
