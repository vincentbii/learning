package io.bii.geeks.Dynamo;

import io.bii.ESB;

public class ESB_Servlet {
    public static void SendRequestToServlet() {

        ESB_EJB.KPLC_Presentment();

        ESB_EJB.SendKPLCPrepaidTransaction();

        ESB_EJB.SendValidationRequest();


    }

    private static void ValidateCoreAccount() {

    }
}
