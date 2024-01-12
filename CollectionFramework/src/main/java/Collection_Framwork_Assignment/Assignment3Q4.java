package Collection_Framwork_Assignment;

import java.util.HashMap;

class DateClass {
    private int date;
    private int month;
    private int year;

    public DateClass(int date, int month, int year) {
        this.date = date;
        this.month = month;
        this.year = year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public int hashCode() {
        final int Prime = 51;
        int res = 1;
        res = Prime * res + date;
        res = Prime * res + month;
        return res;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DateClass other = (DateClass) obj;

        if (date != other.date) {
            return false;
        }
        if (month != other.month) {
            return false;
        }
        return true;
    }

    public int getYear() {
        return year;
    }
}

public class Assignment3Q4 {
	public String getEmployee(HashMap<DateClass, String> map, String employeeName) {
	    for (DateClass d1 : map.keySet()) {
	        if (map.get(d1).equals(employeeName)) {
	            int count = 0;
	            int year = 0;
	            for (DateClass d2 : map.keySet()) {
	                if (d1.equals(d2)) {
	                    count++;
	                    year = d2.getYear();
	                }
	            }
	            if (count == 1 || (count > 1 && d1.getYear() == year)) {
	                return employeeName;
	            }
	        }
	    }
	    return null;
	}

}
