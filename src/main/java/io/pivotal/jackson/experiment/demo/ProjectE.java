package io.pivotal.jackson.experiment.demo;

import java.time.LocalDate;
import java.util.Objects;

public class ProjectE {
    private String name;
    private LocalDate startDate;

    public ProjectE(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    public ProjectE() {

    }

    public String getName() {
        return name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectE projectD = (ProjectE) o;
        return Objects.equals(name, projectD.name) &&
                Objects.equals(startDate, projectD.startDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, startDate);
    }
}
