package edu.miu.cs.cs425.studentmgmt.mystudentmgmtapp.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Classroom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "building_name", nullable = false)
    private String buildingName;

    @Column(name = "room_number", nullable = false)
    private String roomNumber;

    @OneToMany(mappedBy = "classroom")
     List<Student> students;

    public Classroom() {
        super();
    }

    public Classroom(String buildingName, String roomNumber){
        this.buildingName = buildingName;
        this.roomNumber = roomNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return String.format(
                "Classroom [id=%s, buildingName=%s, roomNumber=%s]",
                this.id,
                this.buildingName,
                this.roomNumber);
    }
}
