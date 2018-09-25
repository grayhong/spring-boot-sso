package com.grayground.server.entity

import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import java.io.Serializable
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@Entity
open class EmailUser : Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null

    @NotNull
    @Size(max = 20)
    var username: String? = null

    @NotNull
    @Size(max = 255)
    @Column(updatable = false, unique = true)
    var email: String? = null

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    var dateCreated: Date? = null

    /**
     * Bcrypt hashed password. Bcrypt(ver. 2a)의 해쉬결과는 언제나 60바이트 문자열이다.
     */
    @Size(min = 60, max = 60)
    var password: String? = null

}