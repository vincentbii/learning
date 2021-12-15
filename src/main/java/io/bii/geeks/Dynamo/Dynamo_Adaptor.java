package io.bii.geeks.Dynamo;

import io.Servlet;

public class Dynamo_Adaptor {
    public static void Presentment() {
        Dynamo.HTTP_Request_ValidatePrepaidNumber();
    }

    public static void SendPrepaidTransaction() {
        Dynamo.HTTP_Request_Get_Token();
    }

    public static void PostRequestForProcessing() {
        Dynamo.Check_If_Dynamo_Is_Up();
        Dynamo.Request_For_Authentication_Token();
        Dynamo.Validate_Meter_Number();
        Dynamo.Send_Lending_Request();
    }
}
