package io.pivotal.jackson.experiment.demo;

import java.time.LocalDate;
import java.util.Objects;

public class ProjectA {
    private String name;
    private LocalDate startDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectA project = (ProjectA) o;
        return Objects.equals(name, project.name) &&
                Objects.equals(startDate, project.startDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, startDate);
    }
}
