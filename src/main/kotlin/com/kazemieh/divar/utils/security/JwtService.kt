package com.kazemieh.divar.utils.security

import com.kazemieh.divar.core.user.entity.User
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.io.Decoders
import io.jsonwebtoken.security.Keys
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.time.Instant
import java.util.*
import javax.crypto.SecretKey

@Service
class JwtService {

    @Value("\${jwt.secret}}")
    lateinit var key: String
    // create from hmac generator from search in google

    private fun getSignKey(): SecretKey? {
        val keyBytes = Decoders.BASE64.decode(key)
        return Keys.hmacShaKeyFor(keyBytes)
    }

    fun generate(
        user: User,
        expirationDate: Date = Date.from(Instant.now().plusSeconds(60 * 60 * 24 * 30)),
        additionalClaims: Map<String, Any> = emptyMap()
    ): String =
        Jwts.builder()
            .header()
            .add("type", "jwt")
            .and()
            .claims()
            .subject(user.mobile)
            .issuedAt(Date(System.currentTimeMillis()))
            .expiration(expirationDate)
            .add(additionalClaims)
            .and()
            .signWith(getSignKey())
            .compact()

    fun isValid(token: String, user: User): Boolean {
        val mobile = extractMobile(token)
        return user.mobile == mobile && !isExpired(token)
    }

    fun extractMobile(token: String?): String? {
        if (token.isNullOrEmpty()) return null
        return try {
            getAllClaims(token.replace("Bearer ", "")).subject
        } catch (e: Exception) {
            null
        }
    }

    fun isExpired(token: String): Boolean =
        getAllClaims(token)
            .expiration
            .before(Date(System.currentTimeMillis()))

    private fun getAllClaims(token: String): Claims {
        val parser = Jwts.parser()
            .verifyWith(getSignKey())
            .build()

        return parser
            .parseSignedClaims(token)
            .payload
    }
}

