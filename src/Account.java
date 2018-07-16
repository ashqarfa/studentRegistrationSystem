class Account {

    private String email;
    private String password;
    private Student student;


    Account(String email, String password, Student student) {
        this.email = email;
        this.password = password;
        this.student = student;
    }

    void setPassword(String password) {
        this.password = password;
    }
}
