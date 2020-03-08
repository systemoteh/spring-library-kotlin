package ru.systemoteh.springlibrarykotlin.domain

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate
import org.hibernate.annotations.SelectBeforeUpdate
import javax.persistence.*

@Entity
@Table(name = "book")
@DynamicUpdate
@DynamicInsert
@SelectBeforeUpdate
data class Book(
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_sequence")
        @SequenceGenerator(name = "book_sequence", sequenceName = "book_id_seq")
        val id: Long = 0,
        val name: String,
        val isbn: String,
        @Column(name = "page_count")
        val pageCount: Int,
        @Column(name = "publish_year")
        val publishYear: Int,
        @Column(name = "view_count")
        val viewCount: Long,
        @Column(name = "total_rating")
        val totalRating: Long,
        @Column(name = "total_vote_count")
        val totalVoteCount: Long,
        @Column(name = "avg_rating")
        val avgRating: Long,
        @ManyToOne @JoinColumn
        val genre: Genre,
        @ManyToOne @JoinColumn
        val author: Author,
        @ManyToOne @JoinColumn
        val publisher: Publisher,
        @Lob
        @Column(updatable = false)
        private val content: ByteArray,
        private val image: ByteArray
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Book

        if (id != other.id) return false
        if (name != other.name) return false
        if (isbn != other.isbn) return false
        if (pageCount != other.pageCount) return false
        if (publishYear != other.publishYear) return false
        if (viewCount != other.viewCount) return false
        if (totalRating != other.totalRating) return false
        if (totalVoteCount != other.totalVoteCount) return false
        if (avgRating != other.avgRating) return false
        if (genre != other.genre) return false
        if (author != other.author) return false
        if (publisher != other.publisher) return false
        if (!content.contentEquals(other.content)) return false
        if (!image.contentEquals(other.image)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + isbn.hashCode()
        result = 31 * result + pageCount
        result = 31 * result + publishYear
        result = 31 * result + viewCount.hashCode()
        result = 31 * result + totalRating.hashCode()
        result = 31 * result + totalVoteCount.hashCode()
        result = 31 * result + avgRating.hashCode()
        result = 31 * result + genre.hashCode()
        result = 31 * result + author.hashCode()
        result = 31 * result + publisher.hashCode()
        result = 31 * result + content.contentHashCode()
        result = 31 * result + image.contentHashCode()
        return result
    }
}