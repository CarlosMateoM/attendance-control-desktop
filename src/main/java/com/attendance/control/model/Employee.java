package com.attendance.control.model;



import com.attendance.control.view.components.table.EventAction;
import com.attendance.control.view.components.table.ModelAction;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique=true)
    private String cc;
    private String firstName;
    private String lastName;
    @Column(unique=true)
    private int fingerprintId;
    @ToString.Exclude
    @ManyToMany(mappedBy = "employees", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Attendance> attendances = new ArrayList<>();
    
    
    public Object[] toRowTable(EventAction event) {
        return new Object[]{id, firstName + " " + lastName, cc, new ModelAction(event, this)};
    }
}
