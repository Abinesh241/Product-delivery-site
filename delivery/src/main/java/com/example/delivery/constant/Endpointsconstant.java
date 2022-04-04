package com.example.delivery.constant;

public interface Endpointsconstant {
public interface usersignup{
    public String url="/usersignup";
}
public interface login{
    public String url="/login";
}
public interface verifyotp {
    public String url = "/verifyotp";
}
public interface editprofile{
    public String url="/editprofile/{id}";
}
public interface postitem{
    public String url="/postitem/{id}";
}
public interface bookorder{
    public String url="bookorder";
}
public interface deliverorder{
    public String url="deliverorder";
}
}
