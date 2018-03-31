package br.org.roger.example.services;

import br.org.roger.example.model.Discipline;
import br.org.roger.example.model.MMatrix;
import br.org.roger.example.model.Matrix;
import br.org.roger.example.model.Registration;
import br.org.roger.example.services.support.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
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

    public List<Discipline> dependencyDisciplines() throws ExecutionException, InterruptedException {

        long start = System.currentTimeMillis();

        //Matrix matrix = getMatrix();
        final CompletionStage<Matrix> matrix = getMatrix();

        //List<MMatrix> previousTermsDisciplines = getmMatrices(matrix);
        final CompletionStage<List<MMatrix>> previousTermsDisciplines =
            matrix
            .thenComposeAsync(m -> getmMatrices(m));

        //List<Registration> registrationsList = getRegistrations();
        final CompletionStage<List<Registration>> registrationsList = getRegistrations();

        //List<MMatrix> disciplinesDependencyList = filterNonRegisteredDisciplines(previousTermsDisciplines, registrationsList);
        final CompletionStage<List<MMatrix>> disciplinesDependencyList =
            previousTermsDisciplines
            .thenCombineAsync(registrationsList, (p, r) -> new Pair<>(p, r))
            .thenComposeAsync(pair -> filterNonRegisteredDisciplines(pair.left, pair.right));

        //List<Registration> pendingRegistrationsList = filterFailedDisciplines(registrationsList, disciplinesDependencyList);
        final CompletionStage<List<Registration>> pendingRegistrationsList =
            registrationsList
            .thenCombineAsync(disciplinesDependencyList, (r, d) -> filterFailedDisciplines(r, d));

        //List<Discipline> requiredDisciplinesList = getRequiredDisciplines(matrix, pendingRegistrationsList);
        final CompletionStage<List<Discipline>> requiredDisciplinesList =
            matrix
            .thenCombineAsync(pendingRegistrationsList, (m, r) -> getRequiredDisciplines(m, r));

        long end = System.currentTimeMillis();

        System.out.println("Time elapsed in depDisciplines() before get: " + (end - start) / 1000.0);

        //return getDisciplinesWithoutAchievement(requiredDisciplinesList);
        final List<Discipline> disciplines = requiredDisciplinesList
                .thenApplyAsync(d -> getDisciplinesWithoutAchievement(d)).toCompletableFuture().get();

        end = System.currentTimeMillis();

        System.out.println("Time elapsed in depDisciplines(): " + (end - start) / 1000.0);

        return disciplines;
    }

    private CompletionStage<Matrix> getMatrix() {
        return CompletableFuture
            .supplyAsync(() -> studentCourseService.getByCodInstAndStudentArAndCourse())
            .thenApplyAsync(sc -> matrixService.getMatrixById(sc.getMatrixId()));
    }

    private CompletionStage<List<MMatrix>> getmMatrices(Matrix matrix) {
        return CompletableFuture
            .supplyAsync(() -> studentTermService.nextTerm(matrix.getCod()))
            .thenApplyAsync(nextStudentTerm -> mmatrixService.getAllMatrixDisciplines(matrix.getId(), nextStudentTerm))
            .thenApplyAsync(matrixDisciplines -> matrixDisciplines.stream()
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList()));
    }

    private CompletionStage<List<Registration>> getRegistrations() {
        return CompletableFuture
            .supplyAsync(() -> studentGroupService.getByCodInstAndStudentAr())
            .thenApplyAsync(studentGroup -> registrationService.studentRegisteredDisciplines(studentGroup.getCode()));
    }

    private List<Discipline> getRequiredDisciplines(final Matrix matrix, final List<Registration> pendingRegistrationsList) {
        final List<Discipline> disciplinesList = createDependencyDisciplinesList(pendingRegistrationsList, matrix);
        return getRequiredDisciplines(disciplinesList);
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

    private CompletionStage<List<MMatrix>> filterNonRegisteredDisciplines(List<MMatrix> previousTermsDisciplines, List<Registration> registrationsList) {
        return CompletableFuture
            .supplyAsync(() -> {
                return new ArrayList<>();
            });
    }
}
