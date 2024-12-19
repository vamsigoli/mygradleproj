package mygradleproj.services;

import mygradleproj.data.MessageModel;
import org.apache.commons.lang3.StringUtils;

/**
 * Service class for providing a message.
 */
public final class Service {

    /**
     * printMessage that generates a message.
     */
    public  void printMessage() {
        MessageModel messageModel = new MessageModel();
        String m = StringUtils.trimToEmpty(messageModel.getMessage());
        System.out.println("Message is " + m);
    }
}
