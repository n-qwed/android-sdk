package jp.pokepay.pokepaylib.Responses;

import android.support.annotation.NonNull;

import jp.pokepay.pokepaylib.Response;

public class BankError extends Response {
    @NonNull
    public String type;
    @NonNull
    public String message;
    public Object errors;
}
