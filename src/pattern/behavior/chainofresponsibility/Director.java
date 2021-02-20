package pattern.behavior.chainofresponsibility;

public class Director extends Handler{
    @Override
    public void handleRequest(Request request) {
        if( request.getRequestType() == RequestType.CONFERENCES){
            System.out.println("DIRECTOR CAN Approve COnferences");
        }else {
            successor.handleRequest(request);
        }
    }
}
