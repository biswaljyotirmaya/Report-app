package com.jb.reportapp.request;

import lombok.Data;

@Data
public class SearchRequest {
    private String planName;
    private String planStatus;
    private String gender;
    private boolean startDate;
    private boolean endDate;
}
