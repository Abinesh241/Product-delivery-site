package com.example.delivery.repository.impl;

import com.example.delivery.constant.MessageCodes;
import com.example.delivery.entity.DeliveryEntity;
import com.example.delivery.entity.UserEntity;
import com.example.delivery.io.Baseresponse;
import com.example.delivery.io.BookorderRequest;
import com.example.delivery.io.ItemRequest;
import com.example.delivery.repository.Deliveryrepository;
import com.example.delivery.repository.Userrepository;
import javassist.bytecode.stackmap.BasicBlock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DeliveryrepositoryImpl {
    @Autowired
    Deliveryrepository deliveryrepository;
    @Autowired
    Userrepository userrepository;
    String Status = "";
    String Code = "";
    String Statusmessage = "";
    Object data = null;
    public Baseresponse postitem(int id,ItemRequest request){
        try{
            UserEntity userentity=userrepository.findById(id).orElse(null);

            DeliveryEntity delivery=new DeliveryEntity();
            delivery.setName(request.getName());
            delivery.setReceivername(request.getReceivername());
            delivery.setItemname(request.getItemname());
            delivery.setFromss(request.getFrom());
            delivery.setToo(request.getTo());
            delivery.setPincode(request.getPincode());
            delivery.setOrderstatus("Available");
            delivery.setMessagestatus("messagenotsent");
            delivery.setUserEntity(userentity);
            deliveryrepository.save(delivery);
            List<UserEntity>userentities=userrepository.deliveryman(request.getPincode());
            if (userentities!=null && userentities.size()>0){
                for (int i = 0; i < userentities.size(); i++) {
                    String to = userentities.get(i).getEmail();
                    DeliveryEntity delivery1 = deliveryrepository.findid(id);
                    int k = delivery1.getOrderid();
                    String s = String.valueOf(k);
                    String s1 = request.getFrom();
                    String s2 = request.getTo();
                    String s3 = request.getItemname();
                    String s4 = "id:" + s + "   " + "From:" + s1 + "   " + "To:" + s2 + "   " + "Itemname:" + s3;
                    mail(to, s4);
                }
                delivery.setMessagestatus("messagesent");
                deliveryrepository.save(delivery);
                Code = MessageCodes.SUCCESS;
                Status = MessageCodes.SUCCESS_MSG;
                Statusmessage = MessageCodes.postitem_StatusMessage;
                data = request;
            }else {
                delivery.setMessagestatus("no deliveryman");
                deliveryrepository.save(delivery);
                Code= MessageCodes.SUCCESS;
                Status=MessageCodes.SUCCESS_MSG;
                Statusmessage=MessageCodes.postitem_nodeliveryman_StatusMessage;
                data=request;
            }
        }catch (Exception e){
            Code=MessageCodes.ERROR;
            Status=MessageCodes.ERROR_MSG;
            Statusmessage=MessageCodes.postitemError_StatusMessage;
            data=null;
        }
        return Baseresponse.builder()
                .code(Code)
                .status(Status)
                .statusmessage(Statusmessage)
                .data(data)
                .build();

    }
    @Autowired
    private JavaMailSender mailSender;
    public void mail(String to, String text) {
        SimpleMailMessage mailmessage = new SimpleMailMessage();
        mailmessage.setFrom("abineshkavin2002@gmail.com");
        mailmessage.setTo(String.valueOf(to));
        mailmessage.setText(String.valueOf(text));
        mailSender.send(mailmessage);
    }
    public Baseresponse bookorder(BookorderRequest request){
        try{
            DeliveryEntity delivery2=deliveryrepository.bookorder(request.getOrderid());
            if (delivery2!=null){
                delivery2.setOrderstatus(request.getOrderstatus());
                deliveryrepository.save(delivery2);
                DeliveryEntity deliveryentity4=deliveryrepository.findusergmail(request.getOrderid());
                UserEntity userEntity=deliveryentity4.getUserEntity();
                String to=userEntity.getEmail();
                String text="Your Order Was Picked";
                mail(to,text);
                DeliveryEntity delivery3=new DeliveryEntity();
                delivery3.setFromss(delivery2.getFromss());
                delivery3.setToo(delivery2.getToo());
                delivery3.setItemname(delivery2.getItemname());
                delivery3.setName(delivery2.getName());
                delivery3.setPincode(delivery2.getPincode());
                delivery3.setReceivername(delivery2.getReceivername());
                delivery3.setPhoneno(delivery2.getPhoneno());
                delivery3.setReceiverphoneno(delivery2.getReceiverphoneno());
                Code = MessageCodes.SUCCESS;
                Status = MessageCodes.SUCCESS_MSG;
                Statusmessage = MessageCodes.bookorder_StatusMessage;
                data = delivery3;
            }else{
                Code = MessageCodes.SUCCESS;
                Status = MessageCodes.SUCCESS_MSG;
                Statusmessage = MessageCodes.orderpicked_StatusMessage;
                data = null;
            }
        }catch (Exception e){
            Code=MessageCodes.ERROR;
            Status=MessageCodes.ERROR_MSG;
            Statusmessage=MessageCodes.bookorder_exception_StatusMessage;
            data=null;
        }
        return Baseresponse.builder()
                .code(Code)
                .status(Status)
                .statusmessage(Statusmessage)
                .data(data)
                .build();
    }

    public Baseresponse deliverorder(BookorderRequest request){
        try{
            DeliveryEntity deliveryentity1=deliveryrepository.deliverorder(request.getOrderid());
            if (deliveryentity1!=null){
                UserEntity userEntity= deliveryentity1.getUserEntity();
                String to=userEntity.getEmail();
                String text="Your Order Was Delivered";
                mail(to,text);
                deliveryentity1.setOrderstatus(request.getOrderstatus());
                deliveryrepository.save(deliveryentity1);
                Code = MessageCodes.SUCCESS;
                Status = MessageCodes.SUCCESS_MSG;
                Statusmessage = MessageCodes.deliverorder_StatusMessage;
                data = null;
            }else{
                Code=MessageCodes.ERROR;
                Status=MessageCodes.ERROR_MSG;
                Statusmessage=MessageCodes.wrongid_StatusMessage;
                data=null;
            }
        }catch(Exception e){
            Code=MessageCodes.ERROR;
            Status=MessageCodes.ERROR_MSG;
            Statusmessage=MessageCodes.bookorder_exception_StatusMessage;
            data=null;
        }
        return Baseresponse.builder()
                .code(Code)
                .status(Status)
                .statusmessage(Statusmessage)
                .data(data)
                .build();
    }

}
