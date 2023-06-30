package com.example.tvseries.dto.oas;


import org.eclipse.microprofile.openapi.annotations.media.Schema;

public class ChangeEmailOAS {
    @Schema(name = "ChangeEmailOAS.Request")
    public class Request {
        @Schema(required = true, example = "someone@example.com", description = "New email")
        public String email;

        @Schema(required = true, example = "111111", description = "6 Digit")
        public String otp;
    }

//    @Schema(name = "ChangeEmailOAS.BadRequest")
//    public class BadRequest {
//        @Schema(example = GeneralErrorMessage.BAD_REQUEST, enumeration = {
//                GeneralErrorMessage.BAD_REQUEST, GeneralErrorMessage.DATA_NOT_EXISTS,
//                AuthErrorMessage.WRONG_OTP,
//                UserErrorMessage.EMAIL_EXISTS, UserErrorMessage.EMAIL_NOT_CHANGED
//        })
//        public String message;
//    }
}
