package hu.pe.mik.timetable.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Table(name = "Users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "password")
    @JsonIgnoreProperties
    private String password;

    @Column(name = "email")
    private String email;

    @ManyToMany(fetch = FetchType.LAZY) //set to EAGER if needed
    @JoinTable(name = "calendar_list",
                joinColumns = @JoinColumn(name = "calendar_id", referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
    private List<CalendarEntity> calendars;
}
