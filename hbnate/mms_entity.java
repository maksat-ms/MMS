package hibernate_test.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mms_entity")
public class mms_entity {
    @Id
    @Column(name="id")
    int id;
    @Column(name="fio")
    String fio;
    @Column(name="salary")
    int salary;

    public int getId() {                return id;    }
    public String getFio() {            return fio;    }
    public int getSalary() {            return salary;    }
    public void setId(int id) {         this.id = id;    }
    public void setFio(String fio) {    this.fio = fio;    }
    public void setSalary(int salary) { this.salary = salary;    }

    public mms_entity(){}

    public mms_entity(int id, String fio, int salary) {
        this.id = id;
        this.fio = fio;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "mms_entity{" +
                "id=" + id +
                ", fio='" + fio + '\'' +
                ", salary=" + salary +
                '}';
    }

}
