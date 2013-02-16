package entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity class Book {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id
    public String author
    public String title
    String toString() { "$title by $author" }
}