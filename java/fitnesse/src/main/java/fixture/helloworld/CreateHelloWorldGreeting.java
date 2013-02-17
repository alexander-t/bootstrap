package fixture.helloworld;

public class CreateHelloWorldGreeting {
    private String receiver;

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String message() {
        return "Hello " + receiver + "!";
    }
}
