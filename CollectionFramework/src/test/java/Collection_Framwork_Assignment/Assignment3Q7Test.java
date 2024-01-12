package Collection_Framwork_Assignment;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Assignment3Q7Test {


    @Test
    void testRemoveCar() {
        Parked_CarOwnerList parkedCarOwnerList = new Parked_CarOwnerList();

        Assignment3Q7 car1 = new Assignment3Q7("Manish Kushwaha", "Ferrari", 1001, 999347828, "H.no - 572 Semara gate Bhopal");
        int token1 = parkedCarOwnerList.add_new_car(car1);

        assertNotNull(parkedCarOwnerList.getOwnerName(token1));

        parkedCarOwnerList.remove_car(token1);

        assertNull(parkedCarOwnerList.getOwnerName(token1));
        assertNull(parkedCarOwnerList.get_Parked_car_location(token1));
    }
}
