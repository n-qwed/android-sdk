package jp.pokepay.pokepaylib.BankAPI.User;

import jp.pokepay.pokepaylib.BankAPI.BankRequestError;
import jp.pokepay.pokepaylib.ProcessingError;
import jp.pokepay.pokepaylib.Responses.NoContent;
import jp.pokepay.pokepaylib.Request;
import jp.pokepay.pokepaylib.BankAPI.BankRequest;

public class SendConfirmationEmail extends BankRequest {
    public String id;
    public String email;

    public SendConfirmationEmail(String id, String email) {
        this.id   = id;
        this.email = email;
    }

    protected final String path() {
        return "/users/" + id + "/emails/" + email;
    }

    protected final Request.Method method() {
        return Request.Method.PUT;
    }

    public final NoContent send(String accessToken) throws ProcessingError, BankRequestError {
        return super.send(NoContent.class, accessToken);
    }
}
