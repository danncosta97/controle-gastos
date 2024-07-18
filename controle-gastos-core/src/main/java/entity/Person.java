package entity;

import java.util.Objects;

import jakarta.persistence.*;

@NamedQueries(
        @NamedQuery(
                name = Person.FIND_ALL,
                query = "SELECT * FROM Person"
        )
)
@Entity
public class Person {

    public static final String FIND_ALL = "Person.findAll";

    private Long id;
    private String name;

    @Id
    @GeneratedValue
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
