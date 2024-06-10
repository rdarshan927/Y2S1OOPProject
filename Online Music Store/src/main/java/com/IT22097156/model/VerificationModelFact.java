package com.IT22097156.model;

public class VerificationModelFact {
    public static VerificationModel createVerificationModel(int id, String fullname, String nic, String mobile, String email, String address, String userID, String status) {
        return new VerificationModel(id, fullname, nic, mobile, email, address, userID, status);
    }

    public static VerificationModel createVerificationModel(String fullname, String nic, String mobile, String email, String address, String userID, String status) {
        return new VerificationModel(fullname, nic, mobile, email, address, userID, status);
    }
}
