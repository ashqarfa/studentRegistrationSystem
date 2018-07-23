class Registration {

    private int numberOfStudents = 0;

    private StudentRepository studentRepository = null;

    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    int getNumberOfStudents() {
        return numberOfStudents;
    }

    boolean registerStudent(String firstName, String lastName, String password) throws IllegalArgumentException {

        if (firstName.isEmpty() || lastName.isEmpty() || password.isEmpty()) {
            throw new IllegalArgumentException("cannot have empty argument");
        }

        if (firstName.matches(".*[^A-Za-z].*") || lastName.matches(".*[^A-Za-z].*")) {
            throw new IllegalArgumentException("names can only contain letters");
        }

        Student newStudent = new Student(firstName, lastName, numberOfStudents + 1);
        AccountCreator newAccount = AccountCreator.createAccount(newStudent, password, studentRepository.getAllStudents());
        newStudent.setAccount(newAccount);
        studentRepository.addStudent(newStudent);
        numberOfStudents++;
        return true;
    }
}
