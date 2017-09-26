package com.events.application.entities

import lombok.Getter
import lombok.Setter
import javax.persistence.*

@Entity
@Table(name = "checkpoints", schema = "events", catalog = "testdb")
@Getter @Setter
class CheckpointsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    var id: Int = 0

    @Basic
    @Column(name = "checkpoints_name", nullable = true)
    var checkpointsName: Int? = null

    @Basic
    @Column(name = "event_id", nullable = true)
    var eventId: Int? = null

    @Basic
    @Column(name = "latitude", nullable = true, precision = 0)
    var latitude: Double? = null

    @Basic
    @Column(name = "longitude", nullable = true, precision = 0)
    var longitude: Double? = null

    @Basic
    @Column(name = "description", nullable = true, length = 4000)
    var description: String? = null

    @ManyToOne
    @JoinColumn(name = "event_id", referencedColumnName = "id", table = "events")
    var eventsByEventId: EventsEntity? = null

    @OneToMany(mappedBy = "checkpointsByCheckpointId", targetEntity = CheckpointsEntity::class)
    var passesCheckpointsById: Collection<PassesCheckpointsEntity>? = null

    @OneToMany(mappedBy = "checkpointsBySegmentFrom", targetEntity = TimeSlicesEntity::class)
    var timeSlicesById: Collection<TimeSlicesEntity>? = null

    @OneToMany(mappedBy = "checkpointsBySegmentTo", targetEntity = TimeSlicesEntity::class)
    var timeSlicesById_0: Collection<TimeSlicesEntity>? = null

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false

        val that = other as CheckpointsEntity?

        if (id != that!!.id) return false
        if (if (checkpointsName != null) checkpointsName != that.checkpointsName else that.checkpointsName != null)
            return false
        if (if (eventId != null) eventId != that.eventId else that.eventId != null) return false
        if (if (latitude != null) latitude != that.latitude else that.latitude != null) return false
        if (if (longitude != null) longitude != that.longitude else that.longitude != null) return false
        return if (if (description != null) description != that.description else that.description != null) false else true

    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + if (checkpointsName != null) checkpointsName!!.hashCode() else 0
        result = 31 * result + if (eventId != null) eventId!!.hashCode() else 0
        result = 31 * result + if (latitude != null) latitude!!.hashCode() else 0
        result = 31 * result + if (longitude != null) longitude!!.hashCode() else 0
        result = 31 * result + if (description != null) description!!.hashCode() else 0
        return result
    }
}
