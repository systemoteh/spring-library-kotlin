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
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vote_sequence")
        @SequenceGenerator(name = "vote_sequence", sequenceName = "vote_id_seq")
        val id: Long,
        val value: String,
        @Column(name = "book_id")
        val book_id: Long,
        val username: String

)