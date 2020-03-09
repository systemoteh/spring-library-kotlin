package ru.systemoteh.springlibrarykotlin.domain

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate
import org.hibernate.annotations.SelectBeforeUpdate
import javax.persistence.*

@Entity
@Table(name = "vote")
@DynamicUpdate
@DynamicInsert
@SelectBeforeUpdate
data class Vote(
        @Id
        @SequenceGenerator(name = "vote_generator", sequenceName = "vote_id_seq", allocationSize = 1)
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vote_generator")
        val id: Long,
        val value: String,
        @Column(name = "book_id")
        val book_id: Long,
        val username: String

)