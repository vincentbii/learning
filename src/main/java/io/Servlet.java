package io;

import io.bii.geeks.Dynamo.Dynamo_Adaptor;

public class Servlet {

    static void InitiateRequestFromChannel() {
        Map_Request_For_Processing();
        EJB.Route_To_EJB();
    }

    private static void Map_Request_For_Processing() {
    }

    private static class EJB {
        public static void Route_Request_To_Dynamo_Adaptor() {
            Dynamo_Adaptor.PostRequestForProcessing();

        }

        public static void Route_And_Configure_Request() {
            EJB.Route_Request_To_Dynamo_Adaptor();
        }

        public static void Map_Request_For_Processing() {
            EJB.Route_Request_To_Dynamo_Adaptor();
        }

        public static void Route_To_EJB() {
            if (CBS.Do_Debit_Customer_Account())
                EJB.Route_Request_To_Dynamo_Adaptor();
        }
    }

    private static class Dynamo {
        public static void Request_For_Authentication_Token() {

        }

        public static void Validate_Meter_Number() {
        }

        public static void Send_Lending_Request() {
        }
    }

    private static class CBS {
        public static boolean Do_Debit_Customer_Account() {
            return true;
        }
    }
}
