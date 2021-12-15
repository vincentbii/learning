package io.bii.geeks.Dynamo;

public class ESB_EJB {
    public static void SendValidationRequest() {
        ESB_CBS_Adaptor.T24_AccountValidation();
    }

    public static void KPLC_Presentment() {
        Dynamo_Adaptor.Presentment();
    }

    public static void SendKPLCPrepaidTransaction() {
        ESB_CBS_Adaptor.Debit_CustomerAccount();
        Dynamo_Adaptor.SendPrepaidTransaction();
    }
}
