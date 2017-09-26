package com.events.application.entities

import lombok.Getter
import lombok.Setter
import javax.persistence.*

@Entity
@Table(name = "participants", schema = "events", catalog = "testdb")
@Getter @Setter
class ParticipantsEntity {
    @get:Id
    @get:Column(name = "id", nullable = false)
    var id: Int = 0
    @get:Basic
    @get:Column(name = "user_id", nullable = true)
    var userId: Int? = null
    @get:Basic
    @get:Column(name = "event_id", nullable = true)
    var eventId: Int? = null
    @get:OneToMany(mappedBy = "participantsByUserId")
    var locationsById: Collection<LocationsEntity>? = null
    @get:ManyToOne
    @get:JoinColumn(name = "user_id", referencedColumnName = "id")
    var usersByUserId: UsersEntity? = null
    @get:OneToMany(mappedBy = "participantsByParticipantId")
    var passesCheckpointsById: Collection<PassesCheckpointsEntity>? = null

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false

        val that = o as ParticipantsEntity?

        if (id != that!!.id) return false
        if (if (userId != null) userId != that.userId else that.userId != null) return false
        return if (if (eventId != null) eventId != that.eventId else that.eventId != null) false else true

    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + if (userId != null) userId!!.hashCode() else 0
        result = 31 * result + if (eventId != null) eventId!!.hashCode() else 0
        return result
    }
}
