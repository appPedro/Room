package com.pjurado.room.db.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.pjurado.room.db.entities.Student
import javax.security.auth.Subject

data class SubjectWithStudents(
    @Embedded val subject: Subject,
    @Relation(
        parentColumn = "subjectName",
        entityColumn = "studentName",
        associateBy = androidx.room.Junction(StudentSubjectCrossRef::class)
    )
    val students: List<Student>
)
