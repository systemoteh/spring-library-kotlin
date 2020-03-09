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
        @SequenceGenerator(name = "author_generator", sequenceName = "author_id_seq", allocationSize = 1)
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_generator")
        val id: Long = 0,
        val name: String,
        @Temporal(TemporalType.DATE)
        @Column(name = "birth_date")
        val birthDate: Date
)