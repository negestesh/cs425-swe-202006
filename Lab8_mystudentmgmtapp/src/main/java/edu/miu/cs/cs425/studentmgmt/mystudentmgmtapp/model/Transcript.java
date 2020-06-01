package edu.miu.cs.cs425.studentmgmt.mystudentmgmtapp.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.awt.font.TransformAttribute;

@Entity
@Table(name = "transcript")
public class Transcript {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer transcriptId;


    @Column(name = "degree_title", nullable = false)
    @NotBlank
    private String degreeTitle;

    @OneToOne()
    @JoinColumn(name = "student_Id", nullable = false)
    private Student student;

    public Transcript() {
        super();
    }
    public Transcript(String degreeTitle){
        this.degreeTitle = degreeTitle;
    }

    public Integer getTranscriptId() {
        return transcriptId;
    }

    public void setTranscriptId(Integer transcriptId) {
        this.transcriptId = transcriptId;
    }

    public String getDegreeTitle() {
        return degreeTitle;
    }

    public void setDegreeTitle(String degreeTitle) {
        this.degreeTitle = degreeTitle;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return String.format(
                "Transcript [transcriptId=%s, degreeTitle=%s, student=%s]",
                this.transcriptId,
                this.degreeTitle,
                this.student.getStudentNumber());
    }
}
