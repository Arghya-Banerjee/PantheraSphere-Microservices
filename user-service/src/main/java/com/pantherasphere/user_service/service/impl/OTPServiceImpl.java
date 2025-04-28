package com.pantherasphere.user_service.service.impl;

import com.pantherasphere.user_service.service.OTPService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
@Slf4j
public class OTPServiceImpl implements OTPService {

    private static final int OTP_VALID_DURATION_MINUTES = 5;

    private final Map<String, OtpData> otpStorage = new HashMap<>();

    @Override
    public void generateAndSendOtp(String emailOrPhone) {
        String otpCode = String.format("%06d", new Random().nextInt(999999));
        OtpData otpData = new OtpData(otpCode, LocalDateTime.now());

        otpStorage.put(emailOrPhone, otpData);

        // Simulate sending OTP
        log.info("OTP for {} is {}", emailOrPhone, otpCode);
    }

    @Override
    public boolean verifyOtp(String emailOrPhone, String otpCode) {
        OtpData storedOtp = otpStorage.get(emailOrPhone);

        if (storedOtp == null) {
            return false;
        }

        if (storedOtp.getExpiryTime().plusMinutes(OTP_VALID_DURATION_MINUTES).isBefore(LocalDateTime.now())) {
            otpStorage.remove(emailOrPhone); // Expired
            return false;
        }

        boolean isValid = storedOtp.getOtpCode().equals(otpCode);

        if (isValid) {
            otpStorage.remove(emailOrPhone); // Remove OTP after successful verification
        }

        return isValid;
    }

    private static class OtpData {
        private final String otpCode;
        private final LocalDateTime expiryTime;

        public OtpData(String otpCode, LocalDateTime expiryTime) {
            this.otpCode = otpCode;
            this.expiryTime = expiryTime;
        }

        public String getOtpCode() {
            return otpCode;
        }

        public LocalDateTime getExpiryTime() {
            return expiryTime;
        }
    }
}
