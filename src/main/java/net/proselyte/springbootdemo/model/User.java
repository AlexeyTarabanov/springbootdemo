package net.proselyte.springbootdemo.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    // то есть,,будет увеличиваться для данной сущности
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // так как имена наших колононк с нижним подчеркиванием
    // мы должны явно указать названия колонок
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;



}
