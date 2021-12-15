package io.bii.pinreset;

import io.bii.ESB;

public class Channel {

    public static void main(String[] args) {
        System.out.println("Channel.main");
        Initiate_Pin_Reset_Request();
    }

    private static void Initiate_Pin_Reset_Request() {
        System.out.println("Channel.Initiate_Pin_Reset_Request");
        Dial_667();
        Enter_1();
        Enter_ID_Number();
        Confirm_Terms_and_Conditions();
        ESB.Send_Pin_Reset_Request();

    }

    private static void Confirm_Terms_and_Conditions() {
        System.out.println("Channel.Confirm_Terms_and_Conditions");
    }

    private static void Enter_ID_Number() {
        System.out.println("Channel.Enter_ID_Number");
    }

    private static void Enter_1() {
        System.out.println("Channel.Enter_1");
    }

    private static void Dial_667() {
        System.out.println("Channel.Dial_667");
    }
}
