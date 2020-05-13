
package se.kth.sem4.view;

/**
 * This class is responsible for the error messages shown to the user.
 */
public class ErrorMessageHandler {

    public void showErrorMessage(String message) {
        StringBuilder errorMsgBuilder = new StringBuilder();
        errorMsgBuilder.append("ERROR: ");
        errorMsgBuilder.append(message);
        System.out.println(errorMsgBuilder);
    }
}
