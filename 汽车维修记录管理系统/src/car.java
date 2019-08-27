
public class car {
    private String plate_number;
    private String name;
    private String remark;
    private String  date;

    public car(){

    }

    public car(String plate_number, String name, String remark, String  date) {
        this.plate_number = plate_number;
        this.name = name;
        this.remark = remark;
        this.date = date;
    }

    public String getPlate_number() {
        return plate_number;
    }

    public void setPlate_number(String plate_number) {
        this.plate_number = plate_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String  getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return date + " : "+ remark + "\n";
    }
}
