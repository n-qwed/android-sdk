package jp.pokepay.pokepaylib.MessagingAPI;

import jp.pokepay.pokepaylib.Responses.MessageUnreadCount;
import jp.pokepay.pokepaylib.Request;
import jp.pokepay.pokepaylib.BankAPI.BankRequest;

public class GetUnreadCount extends BankRequest {

    public GetUnreadCount() {}

    protected final String path() {
        return "/messages/unread-count";
    }

    protected final Request.Method method() {
        return Request.Method.GET;
    }

    public final MessageUnreadCount send(String accessToken) {
        return super.send(MessageUnreadCount.class, accessToken);
    }
}


