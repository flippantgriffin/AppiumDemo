import org.testng.annotations.DataProvider;

public class TestData {

    @DataProvider(name="InputData")
    public Object[][] getDataforEditField(){

        Object[][] objects=new Object[][]{
                {"hello"},{"12345"}
        };
        return objects;

    }
}


