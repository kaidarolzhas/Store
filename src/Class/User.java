package Class;

import java.io.Serializable;

public class User implements Serializable {

        private Integer id;
        private String login;
        private String password;
        private String name;
        private String surname;
        private int age;

    public User(Integer id) {
        this.id = id;
    }

    public User(Integer id, String login, String password, String name, String surname, int age) {
            this.id = id;
            this.login = login;
            this.password = password;
            this.name = name;
            this.surname = surname;
            this.age =age;
        }

        public User(){
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSurname() { return surname; }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        public String info() {
            return id + ") email:" + login + ", password:" + password + ", name:" + name + ", surname:" + surname;
        }

        @Override
        public String toString() {
            return login + " " + password + " " + name + " " + surname + '\n';
        }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}


