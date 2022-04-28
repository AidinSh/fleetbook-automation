package Qase;

import com.google.gson.annotations.SerializedName;

public class Run {

    @SerializedName("case_id")
    int caseId;

    String status;

    public Run(int caseId, String status) {
        this.caseId = caseId;
        this.status = status;
    }

    public int getCaseId() {
        return caseId;
    }

    public String getStatus() {
        return status;
    }
}
