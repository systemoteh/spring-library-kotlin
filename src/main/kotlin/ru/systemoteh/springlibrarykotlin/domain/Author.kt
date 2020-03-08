package ru.systemoteh.springlibrarykotlin.domain

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate
import org.hibernate.annotations.SelectBeforeUpdate
import java.util.*
import javax.persistence.*

@Entity
@Table(catalog = "library", name = "author")
@DynamicUpdate
@DynamicInsert
@SelectBeforeUpdate
data class Author(
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_sequence")
        @SequenceGenerator(name = "author_sequence", sequenceName = "author_id_seq")
        val id: Long = 0,
        val name: String,
        @Column(name = "birth_date")
        val birthDate: Date
)