package io.pivotal.jackson.experiment.demo;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    ObjectMapper mapper;

    @Test
    public void deserialize_dto_with_getters_and_setters_works() throws IOException {
        ProjectA project = new ProjectA();
        project.setName("expected-project");
        project.setStartDate(LocalDate.of(2019, 12, 1));
        ProjectA deserializedProject = getProjectFromJSON(ProjectA.class);

        assertThat(project).isEqualTo(deserializedProject);
    }

    @Test
    public void deserialize_dto_with_public_fields_works() throws IOException {
        ProjectB project = new ProjectB();
        project.name = "expected-project";
        project.startDate = LocalDate.of(2019, 12, 1);
        ProjectB deserializedProject = getProjectFromJSON(ProjectB.class);

        assertThat(project).isEqualTo(deserializedProject);
    }

    @Test
    public void deserialize_dto_with_getters_setters_all_public_works() throws IOException {
        ProjectC project = new ProjectC();
        project.setName("expected-project");
        project.startDate = LocalDate.of(2019, 12, 1);
        ProjectC deserializedProject = getProjectFromJSON(ProjectC.class);

        assertThat(project).isEqualTo(deserializedProject);
    }

    @Test(expected = JsonMappingException.class)
    public void deserialize_dto_with_getters_constructor_should_fail() throws IOException {
        ProjectD project = new ProjectD("expected-project", LocalDate.of(2019, 12, 1));
        ProjectD deserializedProject = getProjectFromJSON(ProjectD.class);

        assertThat(project).isEqualTo(deserializedProject);
    }

    @Test
    public void deserialize_dto_with_getters_setters_constructor_works() throws IOException {
        ProjectE project = new ProjectE("expected-project", LocalDate.of(2019, 12, 1));
        ProjectE deserializedProject = getProjectFromJSON(ProjectE.class);

        assertThat(project).isEqualTo(deserializedProject);
    }

    private <T> T getProjectFromJSON(Class<T> clazz) throws IOException {
        String givenJSON = "{\"name\": \"expected-project\", \"startDate\": \"2019-12-01T12:15:56\"}";

        return mapper.readValue(givenJSON, clazz);
    }
}
