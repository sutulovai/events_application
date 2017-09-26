package com.events.application.entities

import lombok.Getter
import lombok.Setter
import javax.persistence.*

@Entity
@Table(name = "locations", schema = "events", catalog = "testdb")
@Getter @Setter
class LocationsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    var id: Int = 0

    @Basic
    @Column(name = "user_id", nullable = true)
    var userId: Int? = null

    @Basic
    @Column(name = "event_id", nullable = true)
    var eventId: Int? = null

    @Basic
    @Column(name = "latitude", nullable = true, precision = 0)
    var latitude: Double? = null

    @Basic
    @Column(name = "longitude", nullable = true, precision = 0)
    var longitude: Double? = null

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    var participantsByUserId: ParticipantsEntity? = null

    @ManyToOne
    @JoinColumn(name = "event_id", referencedColumnName = "id")
    var eventsByEventId: EventsEntity? = null

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false

        val that = o as LocationsEntity?

        if (id != that!!.id) return false
        if (if (userId != null) userId != that.userId else that.userId != null) return false
        if (if (eventId != null) eventId != that.eventId else that.eventId != null) return false
        if (if (latitude != null) latitude != that.latitude else that.latitude != null) return false
        return if (if (longitude != null) longitude != that.longitude else that.longitude != null) false else true

    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + if (userId != null) userId!!.hashCode() else 0
        result = 31 * result + if (eventId != null) eventId!!.hashCode() else 0
        result = 31 * result + if (latitude != null) latitude!!.hashCode() else 0
        result = 31 * result + if (longitude != null) longitude!!.hashCode() else 0
        return result
    }
}
