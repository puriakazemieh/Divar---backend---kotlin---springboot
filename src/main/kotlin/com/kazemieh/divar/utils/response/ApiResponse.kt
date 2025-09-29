package com.kazemieh.divar.utils.response

import org.springframework.http.ResponseEntity

object ApiResponse {

    fun <T> success(data: T, message: String = ""): ResponseEntity<*> {
        val successResponse = SuccessResponse(data = data, message = message)
        return ResponseEntity.ok(successResponse)
    }

    fun <T> error(apiError: ApiError): ResponseEntity<*> {
        val failureResponse = FailureResponse(message = apiError.message, errorCode = apiError.httpStatus.value())
        return ResponseEntity.status(apiError.httpStatus).body(failureResponse)
    }
}


enum class Status { SUCCESS, FAILURE }

data class SuccessResponse<T>(
    val status: Status = Status.SUCCESS,
    val message: String = "",
    val data: T?
)

data class FailureResponse(
    val status: Status = Status.FAILURE,
    val message: String = "",
    val errorCode: Int
)

