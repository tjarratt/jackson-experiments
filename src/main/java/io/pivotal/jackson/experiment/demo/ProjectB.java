package io.pivotal.jackson.experiment.demo;

import java.time.LocalDate;
import java.util.Objects;

public class ProjectB {
    public String name;
    public LocalDate startDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectB projectB = (ProjectB) o;
        return Objects.equals(name, projectB.name) &&
                Objects.equals(startDate, projectB.startDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, startDate);
    }
}
