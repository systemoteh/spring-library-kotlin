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
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genre_sequence")
        @SequenceGenerator(name = "genre_sequence", sequenceName = "genre_id_seq")
        val id: Long = 0,
        val name: String,
        @Basic(fetch = FetchType.LAZY)
        @OneToMany(mappedBy = "genre")
        val books: List<Book>
)