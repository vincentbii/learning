package io.bii;

public class ESB {
    public static void main(String[] args) {
        OutGoingPesalink();
    }

    public static void OutGoingPesalink() {
        if (InitiatePesalinkTransaction())
            SendADebitTransactionToT24();
        T24.ReceiveAndProcessPesalinkRequest();
        T24.ResponseToKonnectWithTransactionStatus();
        SendPesalinkTransactionRequestToIPSL();
        IPSL.ProcessReceivedRequest();
        IPSL.RespondToKonnectWithTransactionStatus();
        UpdateKonnectDatabaseForReporting();
    }

    private static void UpdateKonnectDatabaseForReporting() {
    }

    private static void SendADebitTransactionToT24() {
        System.out.println("ESB.SendADebitTransactionToT24");
    }

    private static void SendPesalinkTransactionRequestToIPSL() {
        System.out.println("ESB.SendPesalinkTransactionRequestToIPSL");
    }

    private static boolean InitiatePesalinkTransaction() {
        System.out.println("ESB.InitiatePesalinkTransaction");
        return true;
    }

    public static void Send_Pin_Reset_Request() {
        System.out.println("ESB.Send_Pin_Reset_Request");
        Safaricom.Send_STK_PUSH_Request();
        Customer_Phone_Number_Confirmed();
        Update_Customer_Pin_With_NewPin();

    }

    private static void Customer_Phone_Number_Confirmed() {
        System.out.println("ESB.Customer_Phone_Number_Confirmed");
    }

    private static void Update_Customer_Pin_With_NewPin() {
        System.out.println("ESB.Update_Customer_Pin_With_NewPin");
    }

    private static class IPSL {
        public static void ProcessReceivedRequest() {
            System.out.println("IPSL.ProcessReceivedRequest");
        }

        public static void RespondToKonnectWithTransactionStatus() {
            System.out.println("IPSL.RespondToKonnectWithTransactionStatus");
        }
    }

    private static class T24 {
        public static void ReceiveAndProcessPesalinkRequest() {
            System.out.println("T24.ReceiveAndProcessPesalinkRequest");
        }

        public static void ResponseToKonnectWithTransactionStatus() {
            System.out.println("T24.ResponseToKonnectWithTransactionStatus");
        }
    }
}
