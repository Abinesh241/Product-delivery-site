package com.example.delivery.constant;

public interface MessageCodes {
    public String SUCCESS = "200";
    public String SUCCESS_MSG = "SUCCESS";

    public String ERROR="400";
    public String ERROR_MSG="ERROR";

    public String signupstatusmessage="Signup done successfully";
    public String Errorsignupstatusmessage="Error occured!Please try again!";

    public String UserLogin_StatusMessage="Login done successfully";
    public String UserLoginFailure_StatusMessage="The username and password is incorrect";
    public String loginexception_StatusMessage="Something went wrong please try again!";

    public String otp_StatusMessage="Otp verified!";
    public String otpFailure_StatusMessage="The otp entered is incorrect";
    public String otpexception_StatusMessage="Error occured!Please try again!";

    public String editprofile_StatusMessage="Profile updated successfully!";
    public String editprofileError_StatusMessage="Error occured!Please try again!";

    public String postitem_StatusMessage="Item posted successfully and deliverymen are available";
    public String postitemError_StatusMessage="Something went wrong!Try later";
    public String postitem_nodeliveryman_StatusMessage="Item posted successfully but deliverymen are not active in your area";

    public String bookorder_StatusMessage="Order Booked!";
    public String orderpicked_StatusMessage="Sorry!Order Already Picked!";
    public String bookorder_exception_StatusMessage="Error occured!Please try again!";

    public String deliverorder_StatusMessage="Order Delivered Successfully";
    public String wrongid_StatusMessage="The ID does not exists!Check the ID!";
}

