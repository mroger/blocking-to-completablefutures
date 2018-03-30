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

        StudentCourse studentCourse = studentCourseService.getByCodInstAndStudentArAndCourse();

        StudentGroup studentGroup = studentGroupService.getByCodInstAndStudentAr();

        Matrix matrix = matrixService.getMatrixById(studentCourse.getMatrixId());

        List<MMatrix> matrixDisciplines = mmatrixService.getAllMatrixDisciplines(matrix.getId());

        Integer nextStudentTerm = studentTermService.nextTerm(matrix.getCod());

        List<MMatrix> previousTermsDisciplines = matrixDisciplines.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        List<Registration> registrationsList = registrationService.studentRegisteredDisciplines(studentGroup.getCode());

        List<MMatrix> disciplinesDependencyList = filterNonRegisteredDisciplines(previousTermsDisciplines, registrationsList);

        List<Registration> pendingRegistrationsList = filterFailedDisciplines(registrationsList);

        List<Discipline> disciplinesList = createDependencyDisciplinesList(pendingRegistrationsList, matrix);

        List<Discipline> requiredDisciplinesList = getRequiredDisciplines(disciplinesList);

        List<Discipline> disciplinesWithoutAchievement = getDisciplinesWithoutAchievement(requiredDisciplinesList);

        return null;
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

    private List<Registration> filterFailedDisciplines(List<Registration> registrationsList) {

        return null;
    }

    private List<MMatrix> filterNonRegisteredDisciplines(List<MMatrix> previousTermsDisciplines, List<Registration> registrationsList) {

        return null;
    }
}
