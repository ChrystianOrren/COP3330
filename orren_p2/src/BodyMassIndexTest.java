import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BodyMassIndexTest {

    @Test
    void CategoryMethod(){
        BodyMassIndex b = new BodyMassIndex(67, 115);
        assertEquals(1, b.Category());

    }

    @Test
    void UnderweightTest(){
        BodyMassIndex bmiTest = new BodyMassIndex(67, 115);
        assertEquals(18.009578970817554, bmiTest.bmi1);
    }

    @Test
    void NormalTest(){
        BodyMassIndex bmiTest = new BodyMassIndex(72, 160);
        assertEquals(21.697530864197528, bmiTest.bmi1);
    }

    @Test
    void OverweightTest(){
        BodyMassIndex bmiTest = new BodyMassIndex(72, 200);
        assertEquals(27.12191358024691, bmiTest.bmi1);
    }

    @Test
    void ObeseTest(){
        BodyMassIndex bmiTest = new BodyMassIndex(72, 250);
        assertEquals(33.90239197530864, bmiTest.bmi1);
    }

}