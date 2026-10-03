package ru.jumptojava.kinopoiskz.entity;

import jakarta.persistence.*;
import ru.jumptojava.kinopoiskz.entity.enums.ProcessType;
import ru.jumptojava.kinopoiskz.entity.enums.StatusOfProcess;

import java.time.Duration;
import java.time.LocalDateTime;

@Entity
@Table(name = "import_job")
public class ImportJob {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "start_time")
    private LocalDateTime startTime;

    @Column(name = "processing_time")
    private Integer processingTime;

    @Column(name = "films_count")
    private Integer filmsCount;

    @Column(name = "new_films_count")
    private Integer newFilmsCount;

    @Column(name = "process_type")
    @Enumerated(EnumType.STRING)
    private ProcessType processType;

    @Column(name = "status_of_process")
    @Enumerated(EnumType.STRING)
    private StatusOfProcess statusOfProcess;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public ImportJob() {
    }

    public ImportJob(LocalDateTime startTime, Integer processingTime, Integer filmsCount, Integer newFilmsCount, ProcessType processType, StatusOfProcess statusOfProcess, User user) {
        this.startTime = startTime;
        this.processingTime = processingTime;
        this.filmsCount = filmsCount;
        this.newFilmsCount = newFilmsCount;
        this.processType = processType;
        this.statusOfProcess = statusOfProcess;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public Integer getProcessingTime() {
        return processingTime;
    }

    public void setProcessingTime(Integer processingTime) {
        this.processingTime = processingTime;
    }

    public Integer getFilmsCount() {
        return filmsCount;
    }

    public void setFilmsCount(Integer filmsCount) {
        this.filmsCount = filmsCount;
    }

    public Integer getNewFilmsCount() {
        return newFilmsCount;
    }

    public void setNewFilmsCount(Integer newFilmsCount) {
        this.newFilmsCount = newFilmsCount;
    }

    public ProcessType getProcessType() {
        return processType;
    }

    public void setProcessType(ProcessType processType) {
        this.processType = processType;
    }

    public StatusOfProcess getStatusOfProcess() {
        return statusOfProcess;
    }

    public void setStatusOfProcess(StatusOfProcess statusOfProcess) {
        this.statusOfProcess = statusOfProcess;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
