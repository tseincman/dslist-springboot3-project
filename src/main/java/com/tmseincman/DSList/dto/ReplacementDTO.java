package com.tmseincman.DSList.dto;

public class ReplacementDTO {
    private Integer sourceIndex;
    private Integer destionationIndex;

    public ReplacementDTO(){}

    public Integer getSourceIndex() {
        return sourceIndex;
    }

    public void setSourceIndex(Integer sourceIndex) {
        this.sourceIndex = sourceIndex;
    }

    public Integer getDestionationIndex() {
        return destionationIndex;
    }

    public void setDestionationIndex(Integer destionationIndex) {
        this.destionationIndex = destionationIndex;
    }
}
