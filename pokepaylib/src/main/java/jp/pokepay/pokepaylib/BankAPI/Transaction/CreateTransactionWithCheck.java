package jp.pokepay.pokepaylib.BankAPI.Transaction;

import jp.pokepay.pokepaylib.Responses.UserTransaction;
import jp.pokepay.pokepaylib.Request;
import jp.pokepay.pokepaylib.BankAPI.BankRequest;

public class CreateTransactionWithCheck extends BankRequest {
    public String checkId;
    public String accountId;

    public CreateTransactionWithCheck(String checkId, String accountId){
        this.checkId   = checkId;
        this.accountId = accountId;
    }

    protected final String path() {
        return "/transactions";
    }

    protected final Request.Method method() {
        return Request.Method.POST;
    }

    protected final String body() {
        String str = "{\"check_id\":\"" + checkId;
        if(accountId != null) {
            str += "\", \"account_id\":\"" + accountId;
        }
        str += "\"}";
        return str;
    }

    public final UserTransaction send(String accessToken) {
        return super.send(UserTransaction.class, accessToken);
    }
}
