package com.events.application.entities

import lombok.Getter
import lombok.Setter
import javax.persistence.*

@Entity
@Table(name = "users", schema = "events", catalog = "testdb")
@Getter @Setter
class UsersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    var id: Int = 0

    @Basic
    @Column(name = "users_login", nullable = false, length = 100)
    var usersLogin: String? = null

    @Basic
    @Column(name = "users_password", nullable = true, length = 1000)
    var usersPassword: String? = null

    @Basic
    @Column(name = "full_name", nullable = true, length = 300)
    var fullName: String? = null

    @Basic
    @Column(name = "users_email", nullable = true, length = 150)
    var usersEmail: String? = null

    @Basic
    @Column(name = "isadmin", nullable = true)
    var isadmin: Boolean? = null

    @OneToMany(mappedBy = "usersByOwnerId")
    var eventsById: Collection<EventsEntity>? = null

    @OneToMany(mappedBy = "usersByUserId")
    var participantsById: Collection<ParticipantsEntity>? = null

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false

        val that = o as UsersEntity?

        if (id != that!!.id) return false
        if (if (usersLogin != null) usersLogin != that.usersLogin else that.usersLogin != null) return false
        if (if (usersPassword != null) usersPassword != that.usersPassword else that.usersPassword != null)
            return false
        if (if (fullName != null) fullName != that.fullName else that.fullName != null) return false
        if (if (usersEmail != null) usersEmail != that.usersEmail else that.usersEmail != null) return false
        return if (if (isadmin != null) isadmin != that.isadmin else that.isadmin != null) false else true

    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + if (usersLogin != null) usersLogin!!.hashCode() else 0
        result = 31 * result + if (usersPassword != null) usersPassword!!.hashCode() else 0
        result = 31 * result + if (fullName != null) fullName!!.hashCode() else 0
        result = 31 * result + if (usersEmail != null) usersEmail!!.hashCode() else 0
        result = 31 * result + if (isadmin != null) isadmin!!.hashCode() else 0
        return result
    }
}
