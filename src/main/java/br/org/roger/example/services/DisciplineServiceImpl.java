package br.org.roger.example.services;

import br.org.roger.example.model.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class DisciplineServiceImpl implements DisciplineService {

    private StudentCourseService studentCourseService;
    private StudentGroupService studentGroupService;
    private MatrixService matrixService;
    private MmatrixService mmatrixService;
    private StudentTermService studentTermService;
    private RegistrationService registrationService;

    public DisciplineServiceImpl() {
        this.studentCourseService = new StudentCourseServiceImpl();
        this.studentGroupService = new StudentGroupServiceImpl();
        this.matrixService = new MatrixServiceImpl();
        this.mmatrixService = new MmatrixServiceImpl();
        this.studentTermService = new StudentTermServiceImpl();
        this.registrationService = new RegistrationServiceImpl();
    }

    public List<Discipline> retornaDisciplinasDependencia() {

        Matrix matrix = getMatrix();

        List<MMatrix> previousTermsDisciplines = getmMatrices(matrix);

        List<Registration> registrationsList = getRegistrations();

        List<MMatrix> disciplinesDependencyList = filterNonRegisteredDisciplines(previousTermsDisciplines, registrationsList);

        List<Registration> pendingRegistrationsList = filterFailedDisciplines(registrationsList, disciplinesDependencyList);

        List<Discipline> requiredDisciplinesList = getRequiredDisciplines(matrix, pendingRegistrationsList);

        return getDisciplinesWithoutAchievement(requiredDisciplinesList);
    }

    private List<Discipline> getRequiredDisciplines(Matrix matrix, List<Registration> pendingRegistrationsList) {
        List<Discipline> disciplinesList = createDependencyDisciplinesList(pendingRegistrationsList, matrix);
        return getRequiredDisciplines(disciplinesList);
    }

    private List<Registration> getRegistrations() {
        StudentGroup studentGroup = studentGroupService.getByCodInstAndStudentAr();
        return registrationService.studentRegisteredDisciplines(studentGroup.getCode());
    }

    private List<MMatrix> getmMatrices(Matrix matrix) {
        Integer nextStudentTerm = studentTermService.nextTerm(matrix.getCod());
        List<MMatrix> matrixDisciplines = mmatrixService.getAllMatrixDisciplines(matrix.getId(), nextStudentTerm);
        return matrixDisciplines.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    private Matrix getMatrix() {
        StudentCourse studentCourse = studentCourseService.getByCodInstAndStudentArAndCourse();
        return matrixService.getMatrixById(studentCourse.getMatrixId());
    }

    private List<Discipline> getDisciplinesWithoutAchievement(List<Discipline> requiredDisciplinesList) {

        return null;
    }

    private List<Discipline> getRequiredDisciplines(List<Discipline> disciplinesList) {

        return null;
    }

    private List<Discipline> createDependencyDisciplinesList(List<Registration> pendingRegistrationsList, Matrix matrix) {

        return null;
    }

    private List<Registration> filterFailedDisciplines(List<Registration> registrationsList, List<MMatrix> disciplinesDependencyList) {

        return null;
    }

    private List<MMatrix> filterNonRegisteredDisciplines(List<MMatrix> previousTermsDisciplines, List<Registration> registrationsList) {

        return null;
    }
}
