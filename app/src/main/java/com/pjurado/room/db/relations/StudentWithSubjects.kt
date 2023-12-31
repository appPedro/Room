package com.pjurado.room.db.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.pjurado.room.db.entities.Student
import javax.security.auth.Subject

data class StudentWithSubjects(
    @Embedded val student: Student,
    @Relation(
        parentColumn = "studentName",
        entityColumn = "subjectName",
        associateBy = Junction(StudentSubjectCrossRef::class)
    )
    val subjects: List<Subject>
)
