package Collection_Framwork_Assignment;


import java.util.logging.Logger;

import java.util.HashMap;
import java.util.Map;




class ParkingSlot {

    private String ownerName;
    private int carNumber;
    private int token;
    private int level;
    private int section;
    private int slot;
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public int getCarNumber() {
		return carNumber;
	}
	public void setCarNumber(int carNumber) {
		this.carNumber = carNumber;
	}
	public int getToken() {
		return token;
	}
	public void setToken(int token) {
		this.token = token;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getSection() {
		return section;
	}
	public void setSection(int section) {
		this.section = section;
	}
	public int getSlot() {
		return slot;
	}
	public void setSlot(int slot) {
		this.slot = slot;
	}
    
    

}

class Parked_CarOwnerList {

    private final int floor_levels = 3;
    private final int sections_per_floor = 4;
    private final int max_Cars_per_section_slots = 20;

    private Map<Integer, Assignment3Q7> parkedCarOwnerDetailsMap;
    private Map<Integer, Integer[]> parkedCarLocationMap;
    private int token;

    public Parked_CarOwnerList() {
        token = 1;
        parkedCarOwnerDetailsMap = new HashMap<>();
        parkedCarLocationMap = new HashMap<>();
    }

    public int add_new_car(Assignment3Q7 obj) {

        if (parkedCarOwnerDetailsMap.size() == floor_levels * sections_per_floor * max_Cars_per_section_slots) {
            return -1;
        }
        int floor = 1;
        int section = 1;
        int slot = 1;

        for (int i = 1; i <= floor_levels; i++) {
            for (int j = 1; j <= sections_per_floor; j++) {
                if (parkedCarLocationMap.containsKey(token)) {
                    token++;
                } else {
                    floor = i;
                    section = j;
                    parkedCarLocationMap.put(token, new Integer[]{floor, section, slot});
                    break;
                }
            }
        }
        parkedCarOwnerDetailsMap.put(token, obj);

        return token;
    }

    public void remove_car(int token) {
        parkedCarOwnerDetailsMap.remove(token);
        parkedCarLocationMap.remove(token);
    }

    public Integer[] get_Parked_car_location(int token) {
        return parkedCarLocationMap.get(token);
    }

    public String getOwnerName(int token) {
        Assignment3Q7 carOwner = parkedCarOwnerDetailsMap.get(token);
        return (carOwner != null) ? carOwner.getOwnerName() : null;
    }
}

public class Assignment3Q7 {
	
	

   
    private String ownerName;
    private String carModel;
    private int carNo;
    private int mobileNo;
    private String address;

    public Assignment3Q7(String ownerName, String carModel, int carNo, int mobileNo, String address) {
        this.ownerName = ownerName;
        this.carModel = carModel;
        this.carNo = carNo;
        this.mobileNo = mobileNo;
        this.address = address;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getCarModel() {
        return carModel;
    }

    public int getCarNo() {
        return carNo;
    }

    public int getMobileNo() {
        return mobileNo;
    }

    public String getAddress() {
        return address;
    }
    
    private static final Logger logger=Logger.getLogger(Assignment3Q7.class.getName());
    
    
    
    
    public static void main(String[] args) {

        Parked_CarOwnerList parkedCarOwnerList = new Parked_CarOwnerList();

        logger.info("In The Parking slot, All Cars Owner Details are mentioned below :- \n");

        Assignment3Q7 parkedCarOwnerDetailsCar1 = new Assignment3Q7("Manish Kushwaha", "Ferrari", 1001, 999347828, "H.no - 572 Semara gate Bhopal");

        logger.info("Car1 Owner full name is : " + parkedCarOwnerDetailsCar1.getOwnerName());
        logger.info("Car1 owner  model number is :" + parkedCarOwnerDetailsCar1.getCarModel());
        logger.info("Car1 owner car's number is :" + parkedCarOwnerDetailsCar1.getCarNo());
        logger.info("Car1 owner mobile number is :" + parkedCarOwnerDetailsCar1.getMobileNo());
        logger.info("Car1 owner Address is :" + parkedCarOwnerDetailsCar1.getAddress());

        int token1 = parkedCarOwnerList.add_new_car(parkedCarOwnerDetailsCar1);

        logger.info("Car1 is parked with token " + token1);

        Integer[] Car1_Location = parkedCarOwnerList.get_Parked_car_location(token1);

        logger.info("Car1 is located on floor " + Car1_Location[0] + " , Section " + Car1_Location[1] + " , Slot " + Car1_Location[2] + "\n");

        Assignment3Q7 parkedCarOwnerDetailCar2 = new Assignment3Q7("Aryan Srivastav", "Mercedes", 1002, 93983993, "H.no - 31/gazipur");

        logger.info("Car2 Owner full name is : " + parkedCarOwnerDetailCar2.getOwnerName());
        logger.info("Car2 owner  model number is :" + parkedCarOwnerDetailCar2.getCarModel());
        logger.info("Car2 owner car's number is :" + parkedCarOwnerDetailCar2.getCarNo());
        logger.info("Car2 owner mobile number is :" + parkedCarOwnerDetailCar2.getMobileNo());
        logger.info("Car2 owner Address is :" + parkedCarOwnerDetailCar2.getAddress());

        int token2 = parkedCarOwnerList.add_new_car(parkedCarOwnerDetailCar2);

        logger.info("Car2 is parked with token " + token2);

        Integer[] Car2_Location = parkedCarOwnerList.get_Parked_car_location(token1);

        logger.info("Car2 is located on floor " + Car2_Location[0] + " , Section " + Car2_Location[1] + " , Slot " + Car2_Location[1]);
    }
}
