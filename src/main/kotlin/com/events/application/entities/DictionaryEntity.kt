package com.events.application.entities

import lombok.Getter
import lombok.Setter
import javax.persistence.*

@Entity
@Table(name = "dictionary", schema = "events", catalog = "testdb")
@Getter @Setter
class DictionaryEntity {

    @Id
    @Column(name = "id", nullable = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    var id: Int? = null

    @Basic
    @Column(name = "dict_value", nullable = true, length = 200)
    var dictValue: String? = null

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false

        val that = o as DictionaryEntity?

        if (if (id != null) id != that!!.id else that!!.id != null) return false
        return if (if (dictValue != null) dictValue != that.dictValue else that.dictValue != null) false else true

    }

    override fun hashCode(): Int {
        var result = if (id != null) id!!.hashCode() else 0
        result = 31 * result + if (dictValue != null) dictValue!!.hashCode() else 0
        return result
    }
}
