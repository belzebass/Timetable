package hu.pe.mik.timetable.storage.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import hu.pe.mik.timetable.storage.calendar.CalendarEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Users")
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

    @ManyToMany
    private Set<RoleEntity> roles;
}
