package domain;

import fakerepositories.FakeStudentRepository;

public class FakeStudentRegistrationService implements StudentRegistrationService {

    private FakeStudentRepository fakeStudentRepository = new FakeStudentRepository();


    public FakeStudentRegistrationService(FakeStudentRepository fakeStudentRepository) {
        this.fakeStudentRepository = fakeStudentRepository;
    }

    @Override
    public int newId() {
        return fakeStudentRepository.getAllStudents().size() + 1;
    }

    @Override
    public long count(StudentName name) {
        return fakeStudentRepository.getAllStudents().stream().filter(st -> st.getName().equals(name)).count();
    }
}
