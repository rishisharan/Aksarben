package pattern.behavior.chainofresponsibility;

public class VP extends Handler {

    @Override
    public void handleRequest(Request request) {
        if( request.getRequestType() == RequestType.PURCHASES){
            System.out.println("VP can approve a purchase");
        }else {
            successor.handleRequest(request);
        }
    }
}
