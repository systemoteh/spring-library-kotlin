package ru.systemoteh.springlibrarykotlin.domain

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate
import org.hibernate.annotations.SelectBeforeUpdate
import javax.persistence.*

@Entity
@Table(name = "genre")
@DynamicUpdate
@DynamicInsert
@SelectBeforeUpdate
data class Genre(
        @Id
        @SequenceGenerator(name = "genre_generator", sequenceName = "genre_id_seq", allocationSize = 1)
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genre_generator")
        val id: Long = 0,
        val name: String,
        @Basic(fetch = FetchType.LAZY)
        @OneToMany(mappedBy = "genre")
        val books: List<Book>
)