package ru.systemoteh.domain

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "author")
data class Author(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_sequence")
    @SequenceGenerator(name = "author_sequence", sequenceName = "author_seq")
    var id: Long = 0,
    val name: String,
    @Column(name = "birth_date")
    val birthDate: Date
)