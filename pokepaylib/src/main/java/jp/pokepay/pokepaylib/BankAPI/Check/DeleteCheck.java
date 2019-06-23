package jp.pokepay.pokepaylib.BankAPI.Check;

import jp.pokepay.pokepaylib.Responses.NoContent;
import jp.pokepay.pokepaylib.Request;
import jp.pokepay.pokepaylib.BankAPI.BankRequest;

public class DeleteCheck extends BankRequest {
    public String id;

    public DeleteCheck(String id) {
        this.id = id;
    }

    protected final String path() {
        return "/checks/" + id;
    }

    protected final Request.Method method() {
        return Request.Method.DELETE;
    }

    public final NoContent send(String accessToken) {
        return super.send(NoContent.class, accessToken);
    }
}
