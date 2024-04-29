import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class ExchangeRateApiResponse {
    @SerializedName("result")
    private String result;
    @SerializedName("documentation")
    private String documentation;
    @SerializedName("terms_of_use")
    private String terms_of_use;
    @SerializedName("time_last_update_unix")
    private long time_last_update_unix;
    @SerializedName("time_last_update_utc")
    private String time_last_update_utc;
    @SerializedName("time_next_update_unix")
    private long time_next_update_unix;
    @SerializedName("time_next_update_utc")
    private String time_next_update_utc;
    @SerializedName("base_code")
    private String base_code;
    @SerializedName("conversion_rates")
    private Map<String, Double> conversion_rates;

    public ExchangeRateApiResponse(String result, String documentation, String terms_of_use,
                                   long time_last_update_unix, String time_last_update_utc,
                                   long time_next_update_unix, String time_next_update_utc,
                                   String base_code, Map<String, Double> conversion_rates) {
        this.result = result;
        this.documentation = documentation;
        this.terms_of_use = terms_of_use;
        this.time_last_update_unix = time_last_update_unix;
        this.time_last_update_utc = time_last_update_utc;
        this.time_next_update_unix = time_next_update_unix;
        this.time_next_update_utc = time_next_update_utc;
        this.base_code = base_code;
        this.conversion_rates = conversion_rates;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getDocumentation() {
        return documentation;
    }

    public void setDocumentation(String documentation) {
        this.documentation = documentation;
    }

    public String getTerms_of_use() {
        return terms_of_use;
    }

    public void setTerms_of_use(String terms_of_use) {
        this.terms_of_use = terms_of_use;
    }

    public long getTime_last_update_unix() {
        return time_last_update_unix;
    }

    public void setTime_last_update_unix(long time_last_update_unix) {
        this.time_last_update_unix = time_last_update_unix;
    }

    public String getTime_last_update_utc() {
        return time_last_update_utc;
    }

    public void setTime_last_update_utc(String time_last_update_utc) {
        this.time_last_update_utc = time_last_update_utc;
    }

    public long getTime_next_update_unix() {
        return time_next_update_unix;
    }

    public void setTime_next_update_unix(long time_next_update_unix) {
        this.time_next_update_unix = time_next_update_unix;
    }

    public String getTime_next_update_utc() {
        return time_next_update_utc;
    }

    public void setTime_next_update_utc(String time_next_update_utc) {
        this.time_next_update_utc = time_next_update_utc;
    }

    public String getBase_code() {
        return base_code;
    }

    public void setBase_code(String base_code) {
        this.base_code = base_code;
    }

    public Map<String, Double> getConversion_rates() {
        return conversion_rates;
    }

    public void setConversion_rates(Map<String, Double> conversion_rates) {
        this.conversion_rates = conversion_rates;
    }
    public Double getConversionRate(String currencyCode) {
        return conversion_rates.get(currencyCode);
    }



}
