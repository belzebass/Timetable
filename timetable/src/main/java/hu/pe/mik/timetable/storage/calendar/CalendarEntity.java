package hu.pe.mik.timetable.storage.calendar;

import hu.pe.mik.timetable.storage.event.EventEntity;
import hu.pe.mik.timetable.storage.user.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Calendars")
public class CalendarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "owner_id")
    private Long owner_id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "calendars")
    private List<UserEntity> users;

    @ManyToMany(fetch = FetchType.LAZY) //set to EAGER if needed
    @JoinTable(name = "event_list",
                joinColumns = @JoinColumn(name = "event_id", referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name = "calendar_id", referencedColumnName = "id"))
    private List<EventEntity> events;
}
