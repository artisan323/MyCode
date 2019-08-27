package com.ssm.pojo;

public class Department {
    private Integer depyId;

    private String deptName;

    public Department() {
    }

    public Department(Integer depyId, String deptName) {
        this.depyId = depyId;
        this.deptName = deptName;
    }

    public Integer getDepyId() {
        return depyId;
    }

    public void setDepyId(Integer depyId) {
        this.depyId = depyId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }

    @Override
    public String toString() {
        return "Department{" +
                "depyId=" + depyId +
                ", deptName='" + deptName + '\'' +
                '}';
    }
}