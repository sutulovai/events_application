package com.events.application.entities

import lombok.Getter
import lombok.Setter
import javax.persistence.*
import java.sql.Date

@Entity
@Table(name = "passes_checkpoints", schema = "events", catalog = "testdb")
@Getter @Setter
class PassesCheckpointsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    var id: Int = 0

    @Basic
    @Column(name = "participant_id", nullable = true)
    var participantId: Int? = null

    @Basic
    @Column(name = "checkpoint_id", nullable = true)
    var checkpointId: Int? = null

    @Basic
    @Column(name = "passed_time", nullable = true)
    var passedTime: Date? = null

    @Basic
    @Column(name = "is_questionably", nullable = true)
    var questionably: Boolean? = null

    @Basic
    @Column(name = "description", nullable = true, length = 3000)
    var description: String? = null

    @ManyToOne
    @JoinColumn(name = "participant_id", referencedColumnName = "id")
    var participantsByParticipantId: ParticipantsEntity? = null

    @ManyToOne
    @JoinColumn(name = "checkpoint_id", referencedColumnName = "id")
    var checkpointsByCheckpointId: CheckpointsEntity? = null

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false

        val that = o as PassesCheckpointsEntity?

        if (id != that!!.id) return false
        if (if (participantId != null) participantId != that.participantId else that.participantId != null)
            return false
        if (if (checkpointId != null) checkpointId != that.checkpointId else that.checkpointId != null) return false
        if (if (passedTime != null) passedTime != that.passedTime else that.passedTime != null) return false
        if (if (questionably != null) questionably != that.questionably else that.questionably != null)
            return false
        return if (if (description != null) description != that.description else that.description != null) false else true

    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + if (participantId != null) participantId!!.hashCode() else 0
        result = 31 * result + if (checkpointId != null) checkpointId!!.hashCode() else 0
        result = 31 * result + if (passedTime != null) passedTime!!.hashCode() else 0
        result = 31 * result + if (questionably != null) questionably!!.hashCode() else 0
        result = 31 * result + if (description != null) description!!.hashCode() else 0
        return result
    }
}
