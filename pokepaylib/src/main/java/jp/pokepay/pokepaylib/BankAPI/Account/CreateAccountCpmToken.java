package jp.pokepay.pokepaylib.BankAPI.Account;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import jp.pokepay.pokepaylib.BankAPI.BankRequest;
import jp.pokepay.pokepaylib.BankAPI.BankRequestError;
import jp.pokepay.pokepaylib.ProcessingError;
import jp.pokepay.pokepaylib.Request;
import jp.pokepay.pokepaylib.Responses.AccountCpmToken;

public class CreateAccountCpmToken extends BankRequest {

    public static final int SCOPE_PAYMENT = 1;
    public static final int SCOPE_TOPUP = 2;
    public static final int SCOPE_BOTH = 3;

    @NonNull
    public String accountId;
    public int scopes;
    public Integer expiresIn;
    public String additionalInfo;

    public CreateAccountCpmToken(String accountId, int scopes, Integer expiresIn, String additionalInfo) {
        this.accountId = accountId;
        this.scopes = scopes;
        this.expiresIn = expiresIn;
        this.additionalInfo = additionalInfo;
    }

    protected final String path() {
        return "/accounts/" + accountId + "/cpm";
    }

    protected final Request.Method method() {
        return Request.Method.POST;
    }

    @Override
    protected final Map<String, Object> parameters() {
        return new HashMap<String, Object>() {{
            ArrayList<String> scopesArray = new ArrayList<String>();
            if ((scopes & SCOPE_PAYMENT) != 0) scopesArray.add("payment");
            if ((scopes & SCOPE_TOPUP) != 0) scopesArray.add("topup");
            put("scopes", scopesArray);
            put("expires_in", expiresIn);
            put("additional_info", additionalInfo);
        }};
    }

    public final AccountCpmToken send(String accessToken) throws ProcessingError, BankRequestError {
        return super.send(AccountCpmToken.class, accessToken);
    }
}