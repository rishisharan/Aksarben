package pattern.behavior.chainofresponsibility;

public class ChainOfResponsibility {
    public static void main(String[] args) {
        Director bryan = new Director();
        VP crystal = new VP();
        CEO jeff = new CEO();

        bryan.setSuccessor(crystal);
        crystal.setSuccessor(jeff);

        Request request = new Request(RequestType.CONFERENCES,1000);
        bryan.handleRequest(request);

         request = new Request(RequestType.CONFERENCES,10000);
        bryan.handleRequest(request);

        request = new Request(RequestType.PURCHASES,500);
        bryan.handleRequest(request);

    }
}
