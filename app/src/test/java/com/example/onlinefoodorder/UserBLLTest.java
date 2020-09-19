package com.example.onlinefoodorder;

import com.example.onlinefoodorder.BLL.UserBLL;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class UserBLLTest {
    @Test
    public void checkUsertest(){
        UserBLL userBLL = new UserBLL("james123", "james123");
        boolean res = userBLL.checkUser();
                assertEquals(true,res);
    }
}
