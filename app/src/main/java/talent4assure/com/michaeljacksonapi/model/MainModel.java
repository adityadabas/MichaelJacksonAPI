package talent4assure.com.michaeljacksonapi.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by adity on 4/18/2018.
 */

public class MainModel {

    @SerializedName("resultCount")
    private int resultcount;
    @SerializedName("results")
    private List<DataList> results;

    public int getResultcount() {
        return resultcount;
    }

    public void setResultcount(int resultcount) {
        this.resultcount = resultcount;
    }

    public List<DataList> getResults() {
        return results;
    }

    public void setResults(List<DataList> results) {
        this.results = results;
    }


}
