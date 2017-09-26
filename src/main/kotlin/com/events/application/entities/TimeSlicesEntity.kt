package com.events.application.entities

import lombok.Getter
import lombok.Setter
import javax.persistence.*

@Entity
@Table(name = "time_slices", schema = "events", catalog = "testdb")
@Getter @Setter
class TimeSlicesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    var id: Int = 0

    @Basic
    @Column(name = "segment_from", nullable = true)
    var segmentFrom: Int? = null

    @Basic
    @Column(name = "segment_to", nullable = true)
    var segmentTo: Int? = null

    @Basic
    @Column(name = "event_id", nullable = true)
    var eventId: Int? = null

    @Basic
    @Column(name = "time_count", nullable = true)
    var timeCount: Int? = null

    @ManyToOne
    @JoinColumn(name = "segment_from", referencedColumnName = "id")
    var checkpointsBySegmentFrom: CheckpointsEntity? = null

    @ManyToOne
    @JoinColumn(name = "segment_to", referencedColumnName = "id")
    var checkpointsBySegmentTo: CheckpointsEntity? = null

    @ManyToOne
    @JoinColumn(name = "event_id", referencedColumnName = "id")
    var eventsByEventId: EventsEntity? = null

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false

        val that = o as TimeSlicesEntity?

        if (id != that!!.id) return false
        if (if (segmentFrom != null) segmentFrom != that.segmentFrom else that.segmentFrom != null) return false
        if (if (segmentTo != null) segmentTo != that.segmentTo else that.segmentTo != null) return false
        if (if (eventId != null) eventId != that.eventId else that.eventId != null) return false
        return if (if (timeCount != null) timeCount != that.timeCount else that.timeCount != null) false else true

    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + if (segmentFrom != null) segmentFrom!!.hashCode() else 0
        result = 31 * result + if (segmentTo != null) segmentTo!!.hashCode() else 0
        result = 31 * result + if (eventId != null) eventId!!.hashCode() else 0
        result = 31 * result + if (timeCount != null) timeCount!!.hashCode() else 0
        return result
    }
}
