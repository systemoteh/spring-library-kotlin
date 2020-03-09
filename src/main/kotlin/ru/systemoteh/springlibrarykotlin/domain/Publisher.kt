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
        @SequenceGenerator(name = "publisher_generator", sequenceName = "publisher_id_seq", allocationSize = 1)
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "publisher_generator")
        val id: Long = 0,
        val name: String,
        @Basic(fetch = FetchType.LAZY)
        @OneToMany(mappedBy = "publisher")
        val books: List<Book>
)