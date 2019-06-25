package jp.pokepay.pokepaylib.BankAPI.Cashtray;

import java.util.HashMap;
import java.util.Map;

import jp.pokepay.pokepaylib.BankAPI.BankRequestError;
import jp.pokepay.pokepaylib.ProcessingError;
import jp.pokepay.pokepaylib.Responses.Cashtray;
import jp.pokepay.pokepaylib.Request;
import jp.pokepay.pokepaylib.BankAPI.BankRequest;

public class CreateCashtray extends BankRequest {
    public double amount;
    public String description;
    public int expiresIn;

    public CreateCashtray(double amount, String description, int expiresIn) {
        this.amount = amount;
        this.description = description;
        this.expiresIn = expiresIn;
    }

    protected final String path() {
        return "/cashtrays";
    }

    protected final Request.Method method() {
        return Request.Method.POST;
    }

    @Override
    protected final Map<String, Object> parameters() {
        return new HashMap<String, Object>() {{
            put("amount", amount >= 0 ? amount : null);
            put("description", description);
            put("expires_in", expiresIn >= 0 ? expiresIn : null);
        }};
    }

    public final Cashtray send(String accessToken) throws ProcessingError, BankRequestError {
        return super.send(Cashtray.class, accessToken);
    }
}
