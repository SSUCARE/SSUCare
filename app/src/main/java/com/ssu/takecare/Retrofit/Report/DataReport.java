package com.ssu.takecare.Retrofit.Report;

import com.google.gson.annotations.SerializedName;

public class DataReport {
    @SerializedName("reportId")
    public int reportId;

    public int getReportId() {
        return reportId;
    }
}
