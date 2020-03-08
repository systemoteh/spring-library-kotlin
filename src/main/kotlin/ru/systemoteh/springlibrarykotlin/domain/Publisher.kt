package ru.systemoteh.springlibrarykotlin.domain

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate
import org.hibernate.annotations.SelectBeforeUpdate
import javax.persistence.*

@Entity
@Table(name = "publisher")
@DynamicUpdate
@DynamicInsert
@SelectBeforeUpdate
data class Publisher(
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "publisher_sequence")
        @SequenceGenerator(name = "publisher_sequence", sequenceName = "publisher_id_seq")
        val id: Long = 0,
        val name: String,
        @Basic(fetch = FetchType.LAZY)
        @OneToMany(mappedBy = "publisher")
        val books: List<Book>
)