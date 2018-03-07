package cn.bjd.platform.admin.web.pdf.chart;

import lombok.Data;

@Data
public class Line {
    private double yValue;
    private String  xValue;
    private String groupName;
    public Line(){

    }
    public Line(double yValue, String xValue, String groupName){
        this.yValue=yValue;
        this.xValue=xValue;
        this.groupName=groupName;
    }

    public double getYValue() {
        return yValue;
    }

    public void setYValue(double yValue) {
        this.yValue = yValue;
    }

    public String getXValue() {
        return xValue;
    }

    public void setXValue(String xValue) {
        this.xValue = xValue;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
