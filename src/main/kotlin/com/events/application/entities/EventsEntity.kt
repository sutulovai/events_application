package com.events.application.entities

import lombok.Getter
import lombok.Setter
import java.sql.Date
import javax.persistence.*

@Entity
@Table(name = "events", schema = "events", catalog = "testdb")
@Getter @Setter
class EventsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    var id: Int = 0

    @Basic
    @Column(name = "type_id", nullable = true)
    var typeId: Int? = null

    @Basic
    @Column(name = "event_name", nullable = true, length = 300)
    var eventName: String? = null

    @Basic
    @Column(name = "date_start", nullable = true)
    var dateStart: Date? = null

    @Basic
    @Column(name = "owner_id", nullable = false)
    var ownerId: Int = 0

    @Basic
    @Column(name = "is_protected_event", nullable = true)
    var protectedEvent: Boolean? = null

    @Basic
    @Column(name = "qr_enable", nullable = true)
    var qrEnable: Boolean? = null

    @Basic
    @Column(name = "description", nullable = true, length = 4000)
    var description: String? = null

    @OneToMany(mappedBy = "eventsByEventId", targetEntity = CheckpointsEntity::class)
    var checkpointsById: Collection<CheckpointsEntity>? = null

    @ManyToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "id", nullable = false)
    var usersByOwnerId: UsersEntity? = null

    @OneToMany(mappedBy = "eventsByEventId")
    var locationsById: Collection<LocationsEntity>? = null

    @OneToMany(mappedBy = "eventsByEventId")
    var timeSlicesById: Collection<TimeSlicesEntity>? = null

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false

        val that = o as EventsEntity?

        if (id != that!!.id) return false
        if (ownerId != that.ownerId) return false
        if (if (typeId != null) typeId != that.typeId else that.typeId != null) return false
        if (if (eventName != null) eventName != that.eventName else that.eventName != null) return false
        if (if (dateStart != null) dateStart != that.dateStart else that.dateStart != null) return false
        if (if (protectedEvent != null) protectedEvent != that.protectedEvent else that.protectedEvent != null)
            return false
        if (if (qrEnable != null) qrEnable != that.qrEnable else that.qrEnable != null) return false
        return if (if (description != null) description != that.description else that.description != null) false else true

    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + if (typeId != null) typeId!!.hashCode() else 0
        result = 31 * result + if (eventName != null) eventName!!.hashCode() else 0
        result = 31 * result + if (dateStart != null) dateStart!!.hashCode() else 0
        result = 31 * result + ownerId
        result = 31 * result + if (protectedEvent != null) protectedEvent!!.hashCode() else 0
        result = 31 * result + if (qrEnable != null) qrEnable!!.hashCode() else 0
        result = 31 * result + if (description != null) description!!.hashCode() else 0
        return result
    }
}
