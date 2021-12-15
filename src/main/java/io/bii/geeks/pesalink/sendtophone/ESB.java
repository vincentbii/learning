package io.bii.geeks.pesalink.sendtophone;

public class ESB {
    private CBS cbs = new CBS();
    private EclecticsAPI eclecticsAPI = new EclecticsAPI();
    private USSD ussd = new USSD();

    public void FundsTransferRequest() {
        cbs.Debit_Source_Account();
        this.sendMessageToCustomer();
        eclecticsAPI.pesalinkRequest();
        ussd.Acknowledgement();
        cbs.FailedReversalRequest();
        this.ReversalNotification();
    }

    private void ReversalNotification() {
    }

    private void sendMessageToCustomer() {
    }
}
