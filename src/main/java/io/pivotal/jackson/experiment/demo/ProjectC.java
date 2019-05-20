package io.pivotal.jackson.experiment.demo;

import java.time.LocalDate;
import java.util.Objects;

public class ProjectC {
    public String name;
    public LocalDate startDate;

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
        ProjectC projectC = (ProjectC) o;
        return Objects.equals(name, projectC.name) &&
                Objects.equals(startDate, projectC.startDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, startDate);
    }
}
