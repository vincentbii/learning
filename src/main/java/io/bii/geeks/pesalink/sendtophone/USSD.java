package io.bii.geeks.pesalink.sendtophone;

public class USSD {
    private ESB esb = new ESB();
    private EclecticsAPI eclecticsAPI = new EclecticsAPI();
    private FundsTransfer fundsTransfer = new FundsTransfer();

    public void sendToCard(){
        SelectSourceAccount();
        EnterCardNumber();
        EnterAmount();
        esb.FundsTransferRequest();
    }

    private void EnterCardNumber() {

    }

    public void sendToBank(){
        SelectSourceAccount();
        SelectDestinationBank();
        EnterRecipientAccountNumber();
        EnterAmount();
        esb.FundsTransferRequest();
    }

    private void EnterRecipientAccountNumber() {
    }

    private void SelectDestinationBank() {

    }

    private void SelectSourceAccount() {

    }

    public void sendToPhone() {
//        this.chooseAccountFrom();
//        this.EnterPhoneNumber();
        eclecticsAPI.accountLookup();
//        this.selectDestinationAccount();
//        this.EnterAmount();
//        this.Purpose();
//        this.Authenticate();
        esb.FundsTransferRequest();
    }

    private void Authenticate() {
    }

    private void Purpose() {
        System.out.println("Choose Purpose");
    }

    private void EnterAmount() {
    }

    private void selectDestinationAccount() {
    }

    private void EnterPhoneNumber() {
    }

    private void chooseAccountFrom() {


    }

    public void RespondWithSuccess() {
    }

    public void RespondWithFailed() {
    }

    public void Acknowledgement() {

    }
}
