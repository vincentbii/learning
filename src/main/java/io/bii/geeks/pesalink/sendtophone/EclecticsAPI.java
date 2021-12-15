package io.bii.geeks.pesalink.sendtophone;

public class EclecticsAPI {
    private Eclectics eclectics = new Eclectics();

    public void accountLookup() {
        eclectics.accountLookup();
    }


    public boolean pesalinkRequest() {
        return eclectics.pesalinkRequest();
    }


    public String waitForAcknoledgement() {
        return eclectics.acknoledgment();
    }
}
